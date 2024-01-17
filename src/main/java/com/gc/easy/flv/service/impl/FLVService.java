package com.gc.easy.flv.service.impl;


import com.gc.easy.flv.factories.Converter;
import com.gc.easy.flv.factories.ConverterFactories;
import com.gc.easy.flv.service.IFLVService;
import com.gc.easy.flv.service.IOutputStreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FLV流转换
 * 
 * @author gc.x
 */
@Slf4j
@Service
public class FLVService implements IFLVService {

	private ConcurrentHashMap<String, Converter> converters = new ConcurrentHashMap<>();
	@Autowired(required = false)
	private IOutputStreamService iOutputStreamService;

	@Override
	public void open(Integer channel,String url, HttpServletResponse response, HttpServletRequest request) {
		String key = md5(url);
		AsyncContext async = request.startAsync();
		async.setTimeout(0);
		if (converters.containsKey(key)) {
			Converter c = converters.get(key);
			try {
				c.addOutputStreamEntity(key, async);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				throw new IllegalArgumentException(e.getMessage());
			}
		} else {
			List<AsyncContext> outs = new ArrayList<>();
			outs.add(async);
			ConverterFactories c = new ConverterFactories(url, key, converters, outs,iOutputStreamService,channel);
			c.start();
			converters.put(key, c);
		}
		response.setContentType("video/x-flv");
		response.setHeader("Connection", "keep-alive");
		response.setStatus(HttpServletResponse.SC_OK);
		try {
			response.flushBuffer();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public String md5(String plainText) {
		StringBuilder buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			buf = new StringBuilder("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		}
		return buf.toString();
	}

}

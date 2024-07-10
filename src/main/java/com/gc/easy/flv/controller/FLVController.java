package com.gc.easy.flv.controller;

import com.gc.easy.flv.service.IFLVService;
import com.gc.easy.flv.service.IOpenFLVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * FLV流转换
 * 
 * @author gc.x
 */
@RestController
public class FLVController {

	@Autowired
	private IFLVService service;
	@Autowired(required = false)
	private IOpenFLVService openFLVService;

	@GetMapping(value = "/get/flv/hls/stream_{channel}.flv")
	public void open(@PathVariable(value = "channel") Integer channel, HttpServletResponse response,
					  HttpServletRequest request) {
		String url = openFLVService.getUrl(channel);
		if(!StringUtils.isEmpty(url)){
			service.open(channel,url, response, request,openFLVService);
		}
	}
	@GetMapping(value = "/get/flv/hls/stream")
	public void open1(String url, HttpServletResponse response,
					 HttpServletRequest request) throws UnsupportedEncodingException {
		if(!StringUtils.isEmpty(url)){
			String decodedUrl = java.net.URLDecoder.decode(url, "UTF-8");
			service.open(decodedUrl, response, request,openFLVService);
		}
	}
}

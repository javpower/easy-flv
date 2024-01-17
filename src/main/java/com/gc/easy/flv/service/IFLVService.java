package com.gc.easy.flv.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFLVService {

	/**
	 * 打开一个流地址
	 * 
	 * @param url
	 * @param response
	 */
	public void open(Integer channel,String url, HttpServletResponse response, HttpServletRequest request);

}

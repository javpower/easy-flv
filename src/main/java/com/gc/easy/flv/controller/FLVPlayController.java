package com.gc.easy.flv.controller;

import com.gc.easy.flv.config.FlvConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FLV流转换
 * 
 * @author gc.x
 */
@Controller
public class FLVPlayController {
	@Autowired
	private FlvConfig flvConfig;
	@GetMapping(value = "/flv/hls/stream_{channel}.flv")
	public String getAppHtml(@PathVariable(value = "channel") Integer channel, Model model)  {
		String videoPath=flvConfig.getHost()+"/get/flv/hls/stream_"+channel+".flv";
		model.addAttribute("videoPath", videoPath);
		model.addAttribute("wight", flvConfig.getWight());
		model.addAttribute("height", flvConfig.getHeight());
		return "video";
	}
}

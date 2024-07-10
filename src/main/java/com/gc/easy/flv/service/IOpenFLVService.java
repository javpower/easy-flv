package com.gc.easy.flv.service;

import org.bytedeco.opencv.opencv_core.IplImage;

public interface IOpenFLVService {


    /**
     * 通过通道号获取url
     * @param channel
     * @return
     */
    String  getUrl(Integer channel);

    /**
     * 抓取一帧视频并将其转换为图像预处理
     * @param iplImage
     */
    void preview(IplImage iplImage);

    /**
     * 开启预处理
     * @return
     */
    boolean openPreview();
}
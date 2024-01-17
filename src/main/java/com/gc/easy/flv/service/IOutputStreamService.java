package com.gc.easy.flv.service;

import com.gc.easy.flv.factories.state.OutputImage;

public interface IOutputStreamService {

    //是否回写流
    public boolean write();

    /**
     * 通过通道号获取url
     * @param image  需要处理的图片
     * @return 处理后的图片
     */
    public byte[] handler(OutputImage image);

}
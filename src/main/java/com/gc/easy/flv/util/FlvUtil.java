package com.gc.easy.flv.util;

import com.alibaba.fastjson.JSONObject;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FlvUtil {

    private static BufferedImage getBufferedImageByFrame(String filePath) throws IOException {
        FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(filePath);
        return getBufferedImageByFrame(grabber);
    }

    private static BufferedImage getBufferedImageByFrame(FFmpegFrameGrabber grabber)
            throws FrameGrabber.Exception {
        grabber.start();
        Frame frame;
        frame = grabber.grabImage();
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage buffer = converter.getBufferedImage(frame);
        grabber.stop();
        return buffer;
    }

    public static byte[] getFlvImg(String path) throws Exception {
        return bufferedImageToByteArray(getBufferedImageByFrame(path));
    }


    /**
     * 将BufferedImage转换为byte[]
     *
     * @param image
     * @return
     */
    public static byte[] bufferedImageToByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", os);
        return os.toByteArray();
    }

    /**
     * 上传文件
     *
     * @param data     文件数据
     * @param url      上传地址
     * @param fileName 文件名称
     * @return
     */
    public static JSONObject postFile(byte[] data, String url, String fileName) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        ByteArrayResource contentsAsResource = new ByteArrayResource(data) {
            @Override
            public String getFilename() {
                return fileName;
            }
        };
        paramMap.add("file", contentsAsResource);
        return restTemplate.postForObject(url, paramMap, JSONObject.class);
    }
}

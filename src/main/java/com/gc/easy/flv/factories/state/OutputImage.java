package com.gc.easy.flv.factories.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutputImage {
    //图片
    private byte[] image;

    private Date recordTime;

    private Integer channel;


}

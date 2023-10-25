package com.example.springdemo.Entity;

import lombok.Data;

/**
 * @author lfmu
 */
@Data
public class MsgRequestVO {
    private String payload;

    private String messageId;

    private String product;

    private String topic;
}

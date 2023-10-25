package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 满减活动类型及id
 * 
 * @author wb.guoqi@mesg.corp.netease.com
 */
@Data
@AllArgsConstructor
@Builder
public class ActivityInfo {
    /**
     * 满减活动id
     */
    private String activityName;

    /**
     * 满减活动类型 0全场；1专属
     */
    private int type;

}

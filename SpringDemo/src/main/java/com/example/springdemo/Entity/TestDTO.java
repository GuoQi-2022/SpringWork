package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {

    /**
     * sku的状态(0-可售， 1-关闭（sku关闭/作废）， 2-不可售（售卖渠道不包含b站）)
     */
    private Boolean user;
}

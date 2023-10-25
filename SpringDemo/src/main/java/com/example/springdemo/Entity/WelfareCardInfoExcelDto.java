package com.example.springdemo.Entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tmind
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WelfareCardInfoExcelDto {
    @Excel(name = "actName")
    private String actName;
    @Excel(name = "id")
    private String id;
    @Excel(name = "actId")
    private String actId;
    @Excel(name = "remainAmount")
    private Long remainAmount;
    @Excel(name = "cardAmount")
    private Long cardAmount;
    @Excel(name = "cardId")
    private String cardId;
}

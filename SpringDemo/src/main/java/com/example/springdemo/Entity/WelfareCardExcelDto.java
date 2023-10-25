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
public class WelfareCardExcelDto {
    @Excel(name = "actName")
    private String actName;
    @Excel(name = "id")
    private String id;
}

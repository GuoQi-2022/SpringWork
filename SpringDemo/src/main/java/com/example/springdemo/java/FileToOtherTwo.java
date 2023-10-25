package com.example.springdemo.java;

import com.example.springdemo.Entity.LotteryAnnouncementMapDto;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.Entity.LotteryAnnouncementExcelDto;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wb.guoqi
 * @create 2021/12/20 15:35
 */
@Slf4j
public class FileToOtherTwo {
    private static final String FILE_URL = "C:\\Users\\Tmind\\Documents\\";
//    private static final String FILE_NAME = "222222.xlsx";
    private static final String FILE_NAME = "333333.xlsx";
//    private static final String FILE_NAME = "工行中奖名单 (1).xlsx";

    public static void main(String[] args) {
        File file = new File(FILE_URL+FILE_NAME);
        MultipartFile multipartFile = getMultipartFile(file);
        List<LotteryAnnouncementExcelDto> lotteryAnnouncementExcelDtoList = parseCardExcel(multipartFile);
        Map<String, List<LotteryAnnouncementMapDto>> lotteryAnnouncementMap = new HashMap<>();
        for (LotteryAnnouncementExcelDto excelDto : lotteryAnnouncementExcelDtoList) {

            List<LotteryAnnouncementMapDto> lotteryAnnouncementMapDtos = lotteryAnnouncementMap.get(excelDto.getUserId());
            if (CollectionUtils.isEmpty(lotteryAnnouncementMapDtos)) {
                lotteryAnnouncementMapDtos = new ArrayList<>();
            }
            LotteryAnnouncementMapDto build = LotteryAnnouncementMapDto.builder()
                    .cdKey(excelDto.getCdKey()).itemName(excelDto.getItemName()).build();
            lotteryAnnouncementMapDtos.add(build);
            lotteryAnnouncementMap.put(excelDto.getUserId(), lotteryAnnouncementMapDtos);
        }
        System.out.println(JSON.toJSONString(lotteryAnnouncementMap));
    }

    private static List<LotteryAnnouncementExcelDto> parseCardExcel(MultipartFile file) {
        List<LotteryAnnouncementExcelDto> list;
        try {
            InputStream inputStream = file.getInputStream();
            ImportParams importParams = new ImportParams();
            list = ExcelImportUtil.importExcel(inputStream, LotteryAnnouncementExcelDto.class, importParams);
        } catch (Exception e) {
            throw new IllegalArgumentException("上传的文件错误");
        }
        return list;
    }

    private static MultipartFile getMultipartFile(File file) {
        FileInputStream fileInputStream = null;
        MultipartFile multipartFile = null;
        try {
            fileInputStream = new FileInputStream(file);
            multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multipartFile;
    }
}

package com.example.springdemo.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.Entity.WelfareCardExcelDto;
import com.example.springdemo.Entity.WelfareCardInfoExcelDto;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wb.guoqi
 * @create 2021/12/20 15:35
 */
@Slf4j
public class FileToOther {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Tmind\\Desktop\\aaaaaaaaaaa.xls");
        File file2 = new File("C:\\Users\\Tmind\\Desktop\\重复发放福粒卡明细.xlsx");
        MultipartFile multipartFile = getMultipartFile(file);
        MultipartFile multipartFile2 = getMultipartFile(file2);
        List<WelfareCardExcelDto> welfareCardExcelDtos = parseCardExcel(multipartFile);
        List<WelfareCardInfoExcelDto> welfareCardExcelDtos2 = parseCardExcel2(multipartFile2);
        Map<String, List<WelfareCardExcelDto>> collect1 = welfareCardExcelDtos.stream().collect(Collectors.groupingBy(WelfareCardExcelDto::getActName));
        Set<String> keySet = collect1.keySet();
        List<String> reCardIds = new ArrayList<>();
        /*活动*/
        for (String key : keySet) {
            List<WelfareCardExcelDto> welfareCardExcelDtos1 = collect1.get(key);
            List<String> actIds = welfareCardExcelDtos1.stream().map(WelfareCardExcelDto::getId).collect(Collectors.toList());

            /*重复记录*/
            List<WelfareCardInfoExcelDto> collect2 = welfareCardExcelDtos2.stream().filter(i -> actIds.contains(i.getActId())).collect(Collectors.toList());
            Optional<WelfareCardInfoExcelDto> any = collect2.stream().filter(i -> null == i.getRemainAmount()).findAny();

            List<String> reCardIds2 = new ArrayList<>();
            if (any.isPresent()) {
                reCardIds.addAll(collect2.stream().filter(i -> !i.getId().equals(any.get().getId())).map(WelfareCardInfoExcelDto::getCardId).collect(Collectors.toList()));
            } else {
                reCardIds2.addAll(collect2.stream().filter(i -> i.getCardAmount().equals(i.getRemainAmount())).map(WelfareCardInfoExcelDto::getCardId).collect(Collectors.toList()));
                if (collect2.size() == reCardIds2.size()) {
                    if (reCardIds2.size() != 0 ) {
                        reCardIds2.remove(reCardIds2.get(0));
                    }
                }
                reCardIds.addAll(reCardIds2);
            }
        }
        System.out.println(reCardIds.size());
        System.out.println(JSON.toJSONString(reCardIds));
//        welfareCardExcelDtos2.stream().filter(i -> reCardIds.contains(i.getRemainAmount()));



        List<String> collect = welfareCardExcelDtos2.stream().map(WelfareCardInfoExcelDto::getActId).collect(Collectors.toList());
        List<WelfareCardExcelDto> collect2 = welfareCardExcelDtos.stream().filter(i -> !collect.contains(i.getId())).collect(Collectors.toList());
        List<String> collect3 = collect2.stream().map(WelfareCardExcelDto::getId).collect(Collectors.toList());
        List<String> collect4 = collect2.stream().map(WelfareCardExcelDto::getActName).collect(Collectors.toList());
        System.out.println("collect3:"+JSON.toJSONString(collect3));
        System.out.println("collect4:"+JSON.toJSONString(collect4));
    }


    private static List<WelfareCardExcelDto> parseCardExcel(MultipartFile file) {
        List<WelfareCardExcelDto> list;
        try {
            InputStream inputStream = file.getInputStream();
            ImportParams importParams = new ImportParams();
            list = ExcelImportUtil.importExcel(inputStream, WelfareCardExcelDto.class, importParams);
        } catch (Exception e) {
            throw new IllegalArgumentException("上传的文件错误");
        }
        return list;
    }

    private static List<WelfareCardInfoExcelDto> parseCardExcel2(MultipartFile file) {
        List<WelfareCardInfoExcelDto> list;
        try {
            InputStream inputStream = file.getInputStream();
            ImportParams importParams = new ImportParams();
            list = ExcelImportUtil.importExcel(inputStream, WelfareCardInfoExcelDto.class, importParams);
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

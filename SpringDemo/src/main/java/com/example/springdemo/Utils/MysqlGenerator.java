package com.example.springdemo.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

/**
 * @author gq
 * @date 2020/11/6 14:24
 */
public class MysqlGenerator {
    /**
     * 运行后在控制台输入数据库中的需要生成相应代码的表的表名（多张表用“，”隔开）
     */
    public static String scanner() {
        String tip = "表名，多个英文逗号分隔";
        Scanner scanner = new Scanner(System.in);
        StringBuilder helpel = new StringBuilder();
        helpel.append("请输入" + tip + ":");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        /* ***************************项目地址（绝对地址，如：D://PROJECT/Demo/）*********************************** */
        String projectPath = "D://workspaces//SpringDemo";
        gc.setOutputDir(projectPath + "/src/main/java");
        /* ***************************创建人(生成的是注释)*********************************** */
        gc.setAuthor("郭旗");
        gc.setOpen(false);
        gc.setIdType(IdType.AUTO);
        gc.setSwagger2(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        //是否覆盖已有文件
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig dsc = getDataSource();
        mpg.setDataSource(dsc);
        /* 包配置 */
        PackageConfig pc = new PackageConfig();
        /* pc.setModuleName(scanner("模块名")); */
        /* ***************************存放总地址*********************************** */
        pc.setParent("com.example.springdemo");
        /* ***************************存放分地址（entity）*********************************** */
        pc.setEntity("entity");
        /* ***************************存放分地址（dao）*********************************** */
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {}
        };
        String templatePath = "/templates/mapper.xml.vm";
        List<FileOutConfig> focList = new ArrayList<>();
        /* ***************************存放分地址（mapper）*********************************** */
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + "/" + tableInfo.getEntityName() + "Mapper"
                    + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setMapper(ConstVals.TEMPLATE_MAPPER);
        mpg.setTemplate(templateConfig);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.no_change);
        strategy.setRestControllerStyle(true);
        strategy.setEntitySerialVersionUID(false);
        strategy.setEntityTableFieldAnnotationEnable(false);
        strategy.setEntityLombokModel(true);
//        strategy.setInclude(scanner().split(","));
        strategy.setInclude("tb_yx_history_record");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "tb_yx_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();

    }

    /**
     * 数据源配置
     */
    private static DataSourceConfig getDataSource() {
        DataSourceConfig dsc = new DataSourceConfig();
        /* ***************************数据库*********************************** */
        dsc.setUrl(
            "jdbc:mysql://localhost:3306/testDemo?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        /* ***************************用户名*********************************** */
        dsc.setUsername("root");
        /* ***************************密码*********************************** */
        dsc.setPassword("123456");
        dsc.setTypeConvert(new OracleTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                String t = fieldType.toLowerCase();
                if (t.contains("char")) {
                    return DbColumnType.STRING;
                } else {
                    if (!t.contains("date") && !t.contains("timestamp")) {
                        if (t.contains("number")) {
                            if (t.matches("number\\(+\\d\\)")) {
                                return DbColumnType.INTEGER;
                            }
                            if (t.matches("number\\(+\\d{2}+\\)")) {
                                return DbColumnType.LONG;
                            }
                            return DbColumnType.DOUBLE;
                        }
                        if (t.contains("int")) {
                            return DbColumnType.INTEGER;
                        }
                        if (t.contains("bigint")) {
                            return DbColumnType.LONG;
                        }
                        if (t.contains("float")) {
                            return DbColumnType.FLOAT;
                        }
                        if (t.contains("char")) {
                            return DbColumnType.STRING;
                        }
                        if (t.contains("varchar")) {
                            return DbColumnType.STRING;
                        }
                        if (t.contains("blob")) {
                            return DbColumnType.BLOB;
                        }
                        if (t.contains("binary")) {
                            return DbColumnType.BYTE_ARRAY;
                        }
                        if (t.contains("raw")) {
                            return DbColumnType.BYTE_ARRAY;
                        }
                    } else {
                        switch (globalConfig.getDateType()) {
                            case ONLY_DATE:
                                return DbColumnType.DATE;
                            case SQL_PACK:
                                return DbColumnType.TIMESTAMP;
                            case TIME_PACK:
                                return DbColumnType.LOCAL_DATE_TIME;
                            default:
                        }
                    }
                    return DbColumnType.STRING;
                }

                /* return super.processTypeConvert(globalConfig, fieldType); */
            }
        });
        return dsc;
    }
}

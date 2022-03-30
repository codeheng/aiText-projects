package com.heng.springboot.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/*
* mybatis-plus代码生成器
* by heng
* @since 2022-02-12
* */
public class CodeGenerator {
    public static void main(String[] args) {
        generate();
    }
    private static void generate() {
        //自己的数据库配置
        String url = "jdbc:mysql://localhost:3306/heng?serverTimezone=GMT%2b8";
        String username = "root";
        String password = "123";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("heng") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\idea_project\\vue\\vue_springboot\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.heng.springboot") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:\\idea_project\\vue\\vue_springboot\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); //利用Lombok生成
                    builder.controllerBuilder().enableHyphenStyle() //开启驼峰转连字符
                            .enableRestStyle(); //开启生成@RestController控制器，让其访问时数据返回json
                    builder.addInclude("sys_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "sys_"); // 设置过滤表前缀
                })
       //         .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}

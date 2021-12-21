package com.renaissance;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateType;

/**
 * 功能描述
 *
 * @author weishanyuan
 * @since 2021-10-14
 */
public class Generator {

    private static String url = "jdbc:mysql://10.69.192.157:3306/msl_mall";
    private static String username = "root";
    private static String password = "password";
    private static String parentPackage = "com.renaissance";
    private static String author = "Generator";
    private static String outputDir = "/mall-entity/src/main/java";

    public static void main(String[] args) {
        FastAutoGenerator.create(url, username, password)
            .globalConfig(builder -> {
                builder.author(author)
                    .enableSwagger()
                    .fileOverride()
                    .disableOpenDir()
                    .outputDir(System.getProperty("user.dir")+outputDir);
            })
            .packageConfig(builder -> {
                builder.parent(parentPackage);
            })
            .templateConfig(builder -> {
                builder.disable(TemplateType.SERVICE, TemplateType.SERVICEIMPL, TemplateType.CONTROLLER, TemplateType.XML);
            })
            .strategyConfig(builder -> {
                builder.entityBuilder()
                    .disableSerialVersionUID()
                    .enableLombok();
            })
            .execute();
    }

}

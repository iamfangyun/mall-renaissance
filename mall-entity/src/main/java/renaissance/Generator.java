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

    public static void main(String[] args) {
        FastAutoGenerator.create(url, username, password)
            .globalConfig(builder -> {
                builder.author("Generator")
                    .enableSwagger()
                    .fileOverride()
                    .disableOpenDir()
                    .outputDir(System.getProperty("user.dir")+"/mall-entity/src/main/java");
            })
            .packageConfig(builder -> {
                builder.parent(parentPackage);
            })
            .templateConfig(builder -> {
                builder.disable(TemplateType.SERVICE, TemplateType.SERVICEIMPL, TemplateType.CONTROLLER, TemplateType.XML);
            })
            .execute();
    }

}

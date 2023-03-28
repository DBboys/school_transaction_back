/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.song.test;

/**
 * spring-boot-plus代码生成器入口类
 *
 * @author geekidea
 * @date 2019-10-22
 **/
public class SpringBootPlusGenerator {

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        // 公共配置
        // 数据库配置
        codeGenerator
                .setUserName("root")
                .setPassword("codemole")
                .setDriverName("com.mysql.jdbc.Driver")
                .setDriverUrl("jdbc:mysql://127.0.0.1:3306/transaction?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");

        // 包信息
        codeGenerator
                .setProjectPackagePath("com/song")
                .setParentPackage("com.song");

        // 组件作者等配置
        codeGenerator
                .setModuleName("system")
                .setAuthor("song")
                .setPkIdColumnName("id");

        // 生成策略
        codeGenerator
                .setGeneratorStrategy(CodeGenerator.GeneratorStrategy.ALL)
                .setPageListOrder(true)
                .setParamValidation(true);

        // 生成实体映射相关代码,可用于数据库字段更新
        // 当数据库字段更新时，可自定义自动生成哪些那文件
        codeGenerator
                .setGeneratorEntity(true)
                .setGeneratorQueryParam(true)
                .setGeneratorQueryVo(true);

        // 生成业务相关代码
//        如果是修改已存在的表中字段，前四项改为false，如果是新增的数据表，前四项改为true
        codeGenerator
                .setGeneratorController(true)
                .setGeneratorService(true)
                .setGeneratorServiceImpl(true)
                .setGeneratorMapper(true)
                .setGeneratorMapperXml(true);

        // 是否覆盖已有文件
        codeGenerator.setFileOverride(true);

        // 初始化公共变量
        codeGenerator.init();

        // 需要生成的表数组
        // xxx,yyy,zzz为需要生成代码的表名称
        String[] tables = {
//                "shizuku_anime_table",
//                "shizuku_tag_anime"
//                "shizuku_anime_link",
//                "shizuku_announcement",
//                "shizuku_comments"
//                "shizuku_score",
//                "shizuku_sub",
//                "shizuku_subtitle",
//                "shizuku_tag"
//                "shizuku_visit",
//                "shizuku_voice_actor"
                "account",
                "announcement",
                "article",
                "article_type",
                "commission_type",
                "commission",
                "good",
                "good_type",
                "hole"
        };




        // 循环生成
        for (String table : tables) {
            // 设置需要生成的表名称
            codeGenerator.setTableName(table);
            // 生成代码
            codeGenerator.generator();
        }

    }

}

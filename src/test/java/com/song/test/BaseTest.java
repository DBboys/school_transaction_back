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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

//    @Autowired
//    WechatAPIService wechatAPIService;
//
//    @Autowired
//    PsyArchivesMapper psyArchivesMapper;
//
//    @Autowired
//    PsyEvaluationMapper psyEvaluationMapper;
//
//    @Autowired
//    PsyEvaluationRecordMapper psyEvaluationRecordMapper;

    @Test
    public void test01() throws Exception{
//        QueryWrapper<PsyArchives> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("student_id", 10000L);
//        queryWrapper.eq("evaluation_id", 40000L);
//        queryWrapper.like("year", "2020");
//        List<PsyArchives> psyArchives = psyArchivesMapper.selectList(queryWrapper);
//        System.out.println(psyArchives);
//        PsyEvaluation psyEvaluation = psyEvaluationMapper.selectById(1407944685967642625L);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
//        String format = simpleDateFormat.format(psyEvaluation.getEnableTime());
//        System.out.println(format);
//        String year = "2021";
//        String[] split = year.split(",");
//        System.out.println(split);
//        List<String> strings = Arrays.asList(split);
//        System.out.println(strings);
//        if(strings.contains("2021")) {
//            System.out.println("true");
//        }
//        File file = new File("D:\\test");
//        File[] files = file.listFiles();
//        System.out.println(files.length);
//        QueryWrapper<PsyEvaluationRecord> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("distinct school_name");
//        List<PsyEvaluationRecord> psyEvaluationRecords = psyEvaluationRecordMapper.selectList(queryWrapper);
//        System.out.println(psyEvaluationRecords);
    }
}

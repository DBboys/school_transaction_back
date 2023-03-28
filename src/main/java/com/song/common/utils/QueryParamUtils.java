package com.song.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.common.param.QueryDateParam;
import com.song.common.param.QueryParam;

import java.util.Date;

/**
 * 查询类的工具
 * @author shizuku
 * @date 2020/2/13 14:07
 */
public class QueryParamUtils {

    /**
     * 通过QueryParam 构造Page
     * @param queryParam
     * @return
     */
    public static Page buildPageByQueryParam(QueryParam queryParam){
        if(queryParam == null){
            return null;
        }
        Page page = new Page();
        page.setSize(queryParam.getSize());
        page.setCurrent(queryParam.getCurrent());
        return page;
    }

    /**
     * 通过QueryDateParam 构造QueryWrapper
     * @param queryWrapper
     * @param queryParam
     * @param timeColumnName
     */
    public static void buildQueryWrapperByDateQueryParam(QueryWrapper queryWrapper, QueryDateParam queryParam,
                                                         String timeColumnName){
        buildDateQueryByStatisticParam(queryWrapper,queryParam,timeColumnName);
    }

    /**
     * 对有的时间操作的
     * @param queryWrapper
     * @param queryParam
     * @param timeColumnName
     */
    public static void buildDateQueryByStatisticParam(QueryWrapper queryWrapper,QueryDateParam queryParam,
                                                      String timeColumnName){
        if(queryParam == null || queryWrapper == null){
            return ;
        }
        // 处理开始时间
        Date queryStartDate = queryParam.getQueryStartDate();
        if(queryStartDate != null){
            queryWrapper.ge(timeColumnName,queryStartDate);
        }

        //处理结束时间
        Date queryEndDate = queryParam.getQueryEndDate();
        if(queryEndDate != null){
            queryWrapper.le(timeColumnName,queryEndDate);
        }
    }

//    /**
//     * 构造全参数的QueryWrapper
//     * @param queryWrapper
//     * @param queryParam
//     */
//    public static void buildAllByStatisticParam(QueryWrapper queryWrapper,
//                                                StatisQueryParam queryParam){
//        if(queryWrapper == null || queryParam == null){
//            return ;
//        }
//        String column_name = "create_time";
//        buildCompanyListByStatisticParam(queryWrapper,queryParam);
//        buildDateQueryByStatisticParam(queryWrapper,queryParam,column_name);
//    }

//    /**
//     * 构造企业Id查询参数
//     * @param queryWrapper
//     * @param queryParam
//     */
//    public static void buildCompanyListByStatisticParam(QueryWrapper queryWrapper,
//                                                        StatisQueryParam queryParam){
//        if(queryParam == null || queryWrapper == null){
//            return;
//        }
//        List<Long> companyIdList = queryParam.getCompanyIdList();
//        if(CollectionUtils.isNotEmpty(companyIdList)){
//            queryWrapper.in("company_id",companyIdList);
//        }
//    }

}

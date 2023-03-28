package com.song.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shizuku
 * @date 2020/4/30 13:17
 */
public class IPageUtils<T,S> {


    /**
     * 完成source 到 targe 的转换
     * @param sourceIPage
     * @return
     */
    public IPage<T> convertFromSource(IPage<S> sourceIPage){
        IPage<T> targetIPage = new Page<>();
        if(sourceIPage == null){
            return targetIPage;
        }
        targetIPage.setTotal(sourceIPage.getTotal());
        targetIPage.setSize(sourceIPage.getSize());
        targetIPage.setCurrent(sourceIPage.getCurrent());
        List<T> targetList = new ArrayList<>();
        targetIPage.setRecords(targetList);

        return targetIPage;
    }
}

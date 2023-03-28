package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.Commission;
import com.song.module.param.CommissionQueryParam;
import com.song.module.vo.CommissionQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 代办表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface CommissionMapper extends BaseMapper<Commission> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    CommissionQueryVo getCommissionById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param commissionQueryParam
     * @return
     */
    IPage<CommissionQueryVo> getCommissionPageList(@Param("page") Page page, @Param("param") CommissionQueryParam commissionQueryParam);

}

package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.CommissionType;
import com.song.module.param.CommissionTypeQueryParam;
import com.song.module.vo.CommissionTypeQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 代办类型表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface CommissionTypeMapper extends BaseMapper<CommissionType> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    CommissionTypeQueryVo getCommissionTypeById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param commissionTypeQueryParam
     * @return
     */
    IPage<CommissionTypeQueryVo> getCommissionTypePageList(@Param("page") Page page, @Param("param") CommissionTypeQueryParam commissionTypeQueryParam);

}

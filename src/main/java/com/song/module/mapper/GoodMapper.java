package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.Good;
import com.song.module.param.GoodQueryParam;
import com.song.module.vo.GoodQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 商品表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface GoodMapper extends BaseMapper<Good> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    GoodQueryVo getGoodById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param goodQueryParam
     * @return
     */
    IPage<GoodQueryVo> getGoodPageList(@Param("page") Page page, @Param("param") GoodQueryParam goodQueryParam);

}

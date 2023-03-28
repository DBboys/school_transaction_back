package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.GoodType;
import com.song.module.param.GoodTypeQueryParam;
import com.song.module.vo.GoodTypeQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 商品类型表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface GoodTypeMapper extends BaseMapper<GoodType> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    GoodTypeQueryVo getGoodTypeById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param goodTypeQueryParam
     * @return
     */
    IPage<GoodTypeQueryVo> getGoodTypePageList(@Param("page") Page page, @Param("param") GoodTypeQueryParam goodTypeQueryParam);

}

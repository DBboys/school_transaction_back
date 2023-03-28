package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.Hole;
import com.song.module.param.HoleQueryParam;
import com.song.module.vo.HoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 树洞表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface HoleMapper extends BaseMapper<Hole> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    HoleQueryVo getHoleById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param holeQueryParam
     * @return
     */
    IPage<HoleQueryVo> getHolePageList(@Param("page") Page page, @Param("param") HoleQueryParam holeQueryParam);

}

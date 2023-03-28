package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.Announcement;
import com.song.module.param.AnnouncementQueryParam;
import com.song.module.vo.AnnouncementQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 公告表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    AnnouncementQueryVo getAnnouncementById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param announcementQueryParam
     * @return
     */
    IPage<AnnouncementQueryVo> getAnnouncementPageList(@Param("page") Page page, @Param("param") AnnouncementQueryParam announcementQueryParam);

}

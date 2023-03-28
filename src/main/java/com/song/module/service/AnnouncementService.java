package com.song.module.service;

import com.song.module.entity.Announcement;
import com.song.common.service.BaseService;
import com.song.module.param.AnnouncementQueryParam;
import com.song.module.vo.AnnouncementQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 公告表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface AnnouncementService extends BaseService<Announcement> {

    /**
     * 保存
     *
     * @param announcement
     * @return
     * @throws Exception
     */
    boolean saveAnnouncement(Announcement announcement) throws Exception;

    /**
     * 修改
     *
     * @param announcement
     * @return
     * @throws Exception
     */
    boolean updateAnnouncement(Announcement announcement) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteAnnouncement(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    AnnouncementQueryVo getAnnouncementById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param announcementQueryParam
     * @return
     * @throws Exception
     */
    Paging<AnnouncementQueryVo> getAnnouncementPageList(AnnouncementQueryParam announcementQueryParam) throws Exception;

}

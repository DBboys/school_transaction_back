package com.song.module.service.impl;

import com.song.module.entity.Announcement;
import com.song.module.mapper.AnnouncementMapper;
import com.song.module.service.AnnouncementService;
import com.song.module.param.AnnouncementQueryParam;
import com.song.module.vo.AnnouncementQueryVo;
import com.song.common.service.impl.BaseServiceImpl;
import com.song.common.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 公告表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class AnnouncementServiceImpl extends BaseServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveAnnouncement(Announcement announcement) throws Exception {
        return super.save(announcement);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateAnnouncement(Announcement announcement) throws Exception {
        return super.updateById(announcement);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteAnnouncement(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public AnnouncementQueryVo getAnnouncementById(Serializable id) throws Exception {
        return announcementMapper.getAnnouncementById(id);
    }

    @Override
    public Paging<AnnouncementQueryVo> getAnnouncementPageList(AnnouncementQueryParam announcementQueryParam) throws Exception {
        Page page = setPageParam(announcementQueryParam, OrderItem.desc("create_time"));
        IPage<AnnouncementQueryVo> iPage = announcementMapper.getAnnouncementPageList(page, announcementQueryParam);
        return new Paging(iPage);
    }

}

package com.song.module.controller;

import com.song.module.entity.Announcement;
import com.song.module.service.AnnouncementService;
import com.song.module.param.AnnouncementQueryParam;
import com.song.module.vo.AnnouncementQueryVo;
import com.song.common.api.ApiResult;
import com.song.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import com.song.common.vo.Paging;
import com.song.common.param.IdParam;

/**
 * <pre>
 * 公告表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/announcement")
@Api("公告表 API")
public class AnnouncementController extends BaseController {

    @Autowired
    private AnnouncementService announcementService;

    /**
     * 添加公告表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Announcement对象", notes = "添加公告表", response = ApiResult.class)
    public ApiResult<Boolean> addAnnouncement(@Valid @RequestBody Announcement announcement) throws Exception {
            boolean flag = announcementService.saveAnnouncement(announcement);
            return ApiResult.result(flag);
    }

    /**
     * 修改公告表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Announcement对象", notes = "修改公告表", response = ApiResult.class)
    public ApiResult<Boolean> updateAnnouncement(@Valid @RequestBody Announcement announcement) throws Exception {
            boolean flag = announcementService.updateAnnouncement(announcement);
            return ApiResult.result(flag);
    }

    /**
     * 删除公告表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Announcement对象", notes = "删除公告表", response = ApiResult.class)
    public ApiResult<Boolean> deleteAnnouncement(@PathVariable("id") Long id) throws Exception {
            boolean flag = announcementService.deleteAnnouncement(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取公告表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Announcement对象详情", notes = "查看公告表", response = AnnouncementQueryVo.class)
    public ApiResult<AnnouncementQueryVo> getAnnouncement(@PathVariable("id") Long id) throws Exception {
        AnnouncementQueryVo announcementQueryVo = announcementService.getAnnouncementById(id);
        return ApiResult.ok(announcementQueryVo);
    }

    /**
     * 公告表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取Announcement分页列表", notes = "公告表分页列表", response = AnnouncementQueryVo.class)
    public ApiResult<Paging<AnnouncementQueryVo>> getAnnouncementPageList(@Valid @RequestBody AnnouncementQueryParam announcementQueryParam) throws Exception {
        Paging<AnnouncementQueryVo> paging = announcementService.getAnnouncementPageList(announcementQueryParam);
        return ApiResult.ok(paging);
    }

}


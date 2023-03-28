package com.song.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.song.common.entity.BaseEntity;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 公告表
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Announcement对象", description = "公告表")
public class Announcement extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "公告标题")
    @NotBlank(message = "公告标题不能为空")
    private String title;

    @ApiModelProperty(value = "公告图片地址")
    @NotBlank(message = "公告图片地址不能为空")
    private String description;

    @ApiModelProperty(value = "公告图片")
    private String url;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "假删")
    private Integer isDeleted;

}

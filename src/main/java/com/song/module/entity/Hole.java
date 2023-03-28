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
 * 树洞表
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Hole对象", description = "树洞表")
public class Hole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "标题")
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "描述内容")
    @NotBlank(message = "描述内容不能为空")
    private String description;

    @ApiModelProperty(value = "发布人")
    @NotBlank(message = "发布人不能为空")
    private String username;

    @ApiModelProperty(value = "发布者id")
    @NotNull(message = "发布者id不能为空")
    private Long userId;

private Date createTime;

private Date updateTime;

    @ApiModelProperty(value = "假删")
    private Integer isDeleted;

    @ApiModelProperty(value = "是否匿名")
    private Integer isAnonymity;

}

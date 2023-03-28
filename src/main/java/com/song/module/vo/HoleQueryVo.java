package com.song.module.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 树洞表 查询结果对象
 * </pre>
 *
 * @author song
 * @date 2023-03-24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "HoleQueryVo对象", description = "树洞表查询参数")
public class HoleQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "描述内容")
    private String description;

    @ApiModelProperty(value = "发布人")
    private String username;

    @ApiModelProperty(value = "发布者id")
    private Long userId;

private Date createTime;

private Date updateTime;

    @ApiModelProperty(value = "假删")
    private Integer isDeleted;

    @ApiModelProperty(value = "是否匿名")
    private Integer isAnonymity;

}
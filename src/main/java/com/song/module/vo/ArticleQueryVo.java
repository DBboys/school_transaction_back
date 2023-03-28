package com.song.module.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 文章表 查询结果对象
 * </pre>
 *
 * @author song
 * @date 2023-03-24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ArticleQueryVo对象", description = "文章表查询参数")
public class ArticleQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "文章类型")
    private Long typeId;

    @ApiModelProperty(value = "文章作者")
    private String username;

    @ApiModelProperty(value = "文章作者id")
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "假删")
    private Integer isDeleted;

}
package com.song.module.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 代办表 查询结果对象
 * </pre>
 *
 * @author song
 * @date 2023-03-24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CommissionQueryVo对象", description = "代办表查询参数")
public class CommissionQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "代办内容")
    private String content;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户名")
    private String username;

private Date createTime;

private Date updateTime;

    @ApiModelProperty(value = "悬赏价格")
    private Double price;

    @ApiModelProperty(value = "代办类型")
    private Long typeId;

    @ApiModelProperty(value = "假删除")
    private Integer isDeleted;

}
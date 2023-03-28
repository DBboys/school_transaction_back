package com.song.module.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 商品表 查询结果对象
 * </pre>
 *
 * @author song
 * @date 2023-03-24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "GoodQueryVo对象", description = "商品表查询参数")
public class GoodQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品描述")
    private String descrption;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "商品状态")
    private Integer status;

    @ApiModelProperty(value = "所属人")
    private String username;

    @ApiModelProperty(value = "所属人id")
    private Long userId;

    @ApiModelProperty(value = "购买人")
    private String buyName;

    @ApiModelProperty(value = "购买人id")
    private Long buyId;

private Date createTime;

private Date updateTime;

    @ApiModelProperty(value = "商品图片")
    private String urls;

    @ApiModelProperty(value = "商品类型")
    private Long typeId;

    @ApiModelProperty(value = "假删")
    private Integer isDeleted;

    @ApiModelProperty(value = "是否二手")
    private Integer isSecond;

}
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
 * 商品表
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Good对象", description = "商品表")
public class Good extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    @NotBlank(message = "商品名称不能为空")
    private String name;

    @ApiModelProperty(value = "商品描述")
    @NotBlank(message = "商品描述不能为空")
    private String descrption;

    @ApiModelProperty(value = "价格")
    @NotNull(message = "价格不能为空")
    private Double price;

    @ApiModelProperty(value = "商品状态")
    private Integer status;

    @ApiModelProperty(value = "所属人")
    @NotBlank(message = "所属人不能为空")
    private String username;

    @ApiModelProperty(value = "所属人id")
    @NotNull(message = "所属人id不能为空")
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
    @NotNull(message = "商品类型不能为空")
    private Long typeId;

    @ApiModelProperty(value = "假删")
    private Integer isDeleted;

    @ApiModelProperty(value = "是否二手")
    private Integer isSecond;

}

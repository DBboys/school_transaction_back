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
 * 代办表
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Commission对象", description = "代办表")
public class Commission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "代办内容")
    @NotBlank(message = "代办内容不能为空")
    private String content;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

private Date createTime;

private Date updateTime;

    @ApiModelProperty(value = "悬赏价格")
    @NotNull(message = "悬赏价格不能为空")
    private Double price;

    @ApiModelProperty(value = "代办类型")
    @NotNull(message = "代办类型不能为空")
    private Long typeId;

    @ApiModelProperty(value = "假删除")
    private Integer isDeleted;

}

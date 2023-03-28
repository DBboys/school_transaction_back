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
 * 代办类型表
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CommissionType对象", description = "代办类型表")
public class CommissionType extends BaseEntity {

    private static final long serialVersionUID = 1L;

@TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "代办类型")
    @NotNull(message = "代办类型不能为空")
    private Integer type;

private Date createTime;

private Date updateTime;

}

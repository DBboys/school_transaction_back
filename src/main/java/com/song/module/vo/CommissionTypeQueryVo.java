package com.song.module.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 代办类型表 查询结果对象
 * </pre>
 *
 * @author song
 * @date 2023-03-24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CommissionTypeQueryVo对象", description = "代办类型表查询参数")
public class CommissionTypeQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

private Long id;

    @ApiModelProperty(value = "代办类型")
    private Integer type;

private Date createTime;

private Date updateTime;

}
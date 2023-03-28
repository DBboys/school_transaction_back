package com.song.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shizuku
 * @date 2020/2/12 22:33
 */
@Data
@ApiModel("分页参数")
public abstract class PageParam implements Serializable {

    @ApiModelProperty("页数")
    private Integer pageIndex;

    @ApiModelProperty("每页大小")
    private Integer pageSize;
}

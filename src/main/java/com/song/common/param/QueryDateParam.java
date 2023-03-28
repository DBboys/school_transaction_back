package com.song.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 带查询时间的QueryParam
 * @author shizuku
 * @date 2020/2/25 20:07
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "QueryDateParam", description = "员工Web 端的查询参数")
public abstract class QueryDateParam extends QueryParam{

    /**
     * 查询开始时间
     */
    @ApiModelProperty("查询开始时间")
    private Date queryStartDate;

    /**
     * 查询结束时间
     */
    @ApiModelProperty("查询结束时间")
    private Date queryEndDate;
}

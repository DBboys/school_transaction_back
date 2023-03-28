package com.song.system.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.song.common.param.OrderQueryParam;

/**
 * <pre>
 * 系统日志 查询参数对象
 * </pre>
 *
 * @author shizuku
 * @date 2022-10-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysLogQueryParam对象", description = "系统日志查询参数")
public class SysLogQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
}

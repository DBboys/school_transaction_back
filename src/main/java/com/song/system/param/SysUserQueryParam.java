package com.song.system.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.song.common.param.OrderQueryParam;

/**
 * <pre>
 * 系统用户 查询参数对象
 * </pre>
 *
 * @author shizuku
 * @date 2022-10-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserQueryParam对象", description = "系统用户查询参数")
public class SysUserQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
}

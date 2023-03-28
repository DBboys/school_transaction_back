package com.song.module.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.song.common.param.OrderQueryParam;

/**
 * <pre>
 * 树洞表 查询参数对象
 * </pre>
 *
 * @author song
 * @date 2023-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "HoleQueryParam对象", description = "树洞表查询参数")
public class HoleQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
}

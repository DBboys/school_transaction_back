package com.song.module.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.song.common.param.OrderQueryParam;

/**
 * <pre>
 * 文章类型表 查询参数对象
 * </pre>
 *
 * @author song
 * @date 2023-03-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ArticleTypeQueryParam对象", description = "文章类型表查询参数")
public class ArticleTypeQueryParam extends OrderQueryParam {
    private static final long serialVersionUID = 1L;
}

package com.song.shiro.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 *  查询结果对象
 * </pre>
 *
 * @author shizuku
 * @date 2022-06-16
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "SysUserQueryVo对象", description = "查询参数")
public class SysUserQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "盐")
    private String salt;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "角色类型")
    private Integer roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "状态0：禁用1：正常")
    private Integer status;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "头像")
    private String head;

    @ApiModelProperty(value = "删除标志:0:正常1：删除")
    private Integer delFlag;

}
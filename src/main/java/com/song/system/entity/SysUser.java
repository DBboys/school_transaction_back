package com.song.system.entity;

import com.song.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <pre>
 * 系统用户
 * </pre>
 *
 * @author shizuku
 * @since 2022-10-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUser对象", description = "系统用户")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "性别，0：女，1：男，2: 其他")
    private Integer gender;

    @ApiModelProperty(value = "头像")
    private String head;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态，0：禁用，1：启用，2：锁定")
    private Integer status;

    @ApiModelProperty(value = "角色类型")
    private Integer roleId;

    @ApiModelProperty(value = "是否第一次登陆：1：是，0：否")
    private Integer isFirstLogin;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}

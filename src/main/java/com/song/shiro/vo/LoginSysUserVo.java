/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.song.shiro.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 * 登录用户对象，响应给前端
 * </p>
 *
 * @author geekidea
 * @date 2019-05-15
 **/
@Data
@Accessors(chain = true)
public class LoginSysUserVo implements Serializable {

    private static final long serialVersionUID = -1758338570596088158L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "手机号-账号")
    private String phone;

//    @ApiModelProperty(value = "密码")
//    private String password;

    @ApiModelProperty(value = "企业id")
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "企业网址")
    private String enterpriseWebsite;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "联系电话")
    private String contactPhone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

//    @ApiModelProperty(value = "盐值")
//    private String salt;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

//    @ApiModelProperty(value = "用户名")
//    private String username;
//
//    @ApiModelProperty(value = "昵称")
//    private String nickname;
//
//    @ApiModelProperty(value = "性别，0：女，1：男，默认1")
//    private Integer gender;
//
//    @ApiModelProperty(value = "状态，0：禁用，1：启用，2：锁定")
//    private Integer state;
//
//    @ApiModelProperty("部门id")
//    private Long departmentId;
//
//    @ApiModelProperty("部门名称")
//    private String departmentName;

//    @ApiModelProperty("角色id")
//    private Long roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("权限编码列表")
    private Set<String> permissionCodes;

//    @ApiModelProperty(value = "手机号码")
//    private String phone;

    @ApiModelProperty(value = "？ 角色类型：1：教育局管理员，2 ：学校管理员")
    private Integer roleType;

//    @ApiModelProperty(value = "是否第一次登陆：1：是，0：否")
//    private Integer isFirstLogin;
//
//    @ApiModelProperty(value = "系统人员Id，教师、学生的主键")
//    private Long personId;
//
//    @ApiModelProperty(value = "系统人员，可能属性：教师、学生、教育局工作人员")
//    private Object person;
//
//    @ApiModelProperty(value = "学校id")
//    private Long schoolId;
//
//    @ApiModelProperty(value = "学校名称")
//    private String schoolName;
//
//    @ApiModelProperty(value = "登录账号")
//    private String schoolRollNo;

}

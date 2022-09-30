package com.example.security.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表(SysUser)表实体类
 *
 * @author makejava
 * @since 2022-09-27 18:10:22
 */
@Data
@TableName("sys_user")
@ApiModel(value="SysUser",description="用户表实体类")
public class User extends Model<User> implements Serializable {

                        
    @TableId(type=IdType.AUTO)
    @ApiModelProperty(name = "id", value = "主键")
    private Long id;
                        
    @ApiModelProperty(name = "userName", value = "用户名")
    private String userName;
                        
    @ApiModelProperty(name = "nickName", value = "昵称")
    private String nickName;
                        
    @ApiModelProperty(name = "password", value = "密码")
    private String password;
                        
    @ApiModelProperty(name = "status", value = "账号状态（0正常 1停用）")
    private String status;
                        
    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;
                        
    @ApiModelProperty(name = "phonenumber", value = "手机号")
    private String phonenumber;
                        
    @ApiModelProperty(name = "sex", value = "用户性别（0男，1女，2未知）")
    private String sex;
                        
    @ApiModelProperty(name = "avatar", value = "头像")
    private String avatar;
                        
    @ApiModelProperty(name = "userType", value = "用户类型（0管理员，1普通用户）")
    private String userType;
                        
    @ApiModelProperty(name = "createBy", value = "创建人的用户id",hidden=true)
    private Long createBy;
                        
    @ApiModelProperty(name = "createTime", value = "创建时间",hidden=true)
    private LocalDateTime createTime;
                        
    @ApiModelProperty(name = "updateBy", value = "更新人",hidden=true)
    private Long updateBy;
                        
    @ApiModelProperty(name = "updateTime", value = "更新时间",hidden=true)
    private LocalDateTime updateTime;
                        
    @ApiModelProperty(name = "delFlag", value = "删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;
    
    private static final long serialVersionUID = 689774509010718119L;
}

package com.hc.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author vicente
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Userinfo extends Model<Userinfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("userPwd")
    private String userPwd;

    /**
     * 用户性别
     */
    @TableField("userSex")
    private String userSex;

    /**
     * 用户年龄
     */
    @TableField("userAge")
    private Integer userAge;

    /**
     * 用户手机
     */
    @TableField("userPhone")
    private String userPhone;

    /**
     * 用户地址
     */
    @TableField("userSite")
    private String userSite;

    /**
     * 用户是否为经理
     */
    @TableField("userManager")
    private String userManager;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}

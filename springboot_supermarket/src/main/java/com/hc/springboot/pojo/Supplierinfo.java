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
public class Supplierinfo extends Model<Supplierinfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 供应商id
     */
    @TableId(value = "supId", type = IdType.AUTO)
    private Integer supId;

    /**
     * 供应商名称
     */
    @TableField("supName")
    private String supName;

    /**
     * 供应商简介
     */
    @TableField("supIntro")
    private String supIntro;

    /**
     * 供应商联系人
     */
    @TableField("supContacts")
    private String supContacts;

    /**
     * 供应商联系电话
     */
    @TableField("supPhone")
    private String supPhone;

    /**
     * 供应商地址
     */
    @TableField("supSite")
    private String supSite;

    /**
     * 供应商传真
     */
    @TableField("supFax")
    private String supFax;


    @Override
    protected Serializable pkVal() {
        return this.supId;
    }

}

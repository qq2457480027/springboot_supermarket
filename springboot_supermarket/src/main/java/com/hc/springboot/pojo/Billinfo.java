package com.hc.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

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
public class Billinfo extends Model<Billinfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 账单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @TableField("comName")
    private String comName;

    /**
     * 商品描述
     */
    @TableField("comDescribe")
    private String comDescribe;

    /**
     * 账单时间
     */
    @TableField("billDate")
    private Date billDate;

    /**
     * 供应商编号
     */
    @TableField("supId")
    private Integer supId;

    /**
     * 是否付款
     */
    private Integer payment;

    /**
     * 账单报价
     */
    @TableField("billOffer")
    private Double billOffer;

    /**
     * 商品数量
     */
    @TableField("comQuantity")
    private Integer comQuantity;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

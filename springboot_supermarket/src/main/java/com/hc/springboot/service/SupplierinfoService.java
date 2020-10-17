package com.hc.springboot.service;

import com.hc.springboot.pojo.Billinfo;
import com.hc.springboot.pojo.Supplierinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.springboot.util.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vicente
 * @since 2020-09-22
 */
public interface SupplierinfoService extends IService<Supplierinfo> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page findSupplierinfoPage(Page page);
}

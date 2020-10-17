package com.hc.springboot.mapper;

import com.hc.springboot.pojo.Supplierinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hc.springboot.util.Page;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author vicente
 * @since 2020-09-22
 */
public interface SupplierinfoMapper extends BaseMapper<Supplierinfo> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<Supplierinfo> searchSupplierinfoPage(Page page);

    /**
     * 获取供应商的记录总数
     * @return
     */
    Integer totalCount(Page page);
}

package com.hc.springboot.service.impl;

import com.hc.springboot.pojo.Supplierinfo;
import com.hc.springboot.mapper.SupplierinfoMapper;
import com.hc.springboot.service.SupplierinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vicente
 * @since 2020-09-22
 */
@Service
public class SupplierinfoServiceImpl extends ServiceImpl<SupplierinfoMapper, Supplierinfo> implements SupplierinfoService {

    @Autowired
    SupplierinfoMapper supplierinfoMapper;

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page findSupplierinfoPage(Page page) {
        page.setTotalCount(supplierinfoMapper.totalCount(page));
        Map<String,Object> map = new HashMap<>();
        map.put("currentPageNo",(page.getCurrentPageNo()-1)*page.getPageSize());
        page.setParamMap(map);
        page.setList(supplierinfoMapper.searchSupplierinfoPage(page));
        return page;
    }
}

package com.hc.springboot.service.impl;

import com.hc.springboot.pojo.Billinfo;
import com.hc.springboot.mapper.BillinfoMapper;
import com.hc.springboot.service.BillinfoService;
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
public class BillinfoServiceImpl extends ServiceImpl<BillinfoMapper, Billinfo> implements BillinfoService {

    @Autowired
    BillinfoMapper billinfoMapper;

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page findBillinfoPage(Page page) {
        page.setTotalCount(billinfoMapper.totalCount(page));
        Map<String,Object> map = new HashMap<>();
        map.put("currentPageNo",(page.getCurrentPageNo()-1)*page.getPageSize());
        page.setParamMap(map);
        page.setList(billinfoMapper.searchBillinfoPage(page));
        return page;
    }

    /**
     * 新增账单
     *
     * @param billinfo
     * @return
     */
    @Override
    public int addBillinfo(Billinfo billinfo) {
        return billinfoMapper.insertBillinfo(billinfo);
    }

    /**
     * 修改账单
     *
     * @param billinfo
     * @return
     */
    @Override
    public int modifyBillinfo(Billinfo billinfo) {
        return billinfoMapper.updateBillinfo(billinfo);
    }

}

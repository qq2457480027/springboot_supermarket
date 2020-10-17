package com.hc.springboot.service;

import com.hc.springboot.pojo.Billinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.springboot.pojo.vo.BillinfoImplVO;
import com.hc.springboot.util.Page;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vicente
 * @since 2020-09-22
 */
public interface BillinfoService extends IService<Billinfo> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page findBillinfoPage(Page page);

    /**
     * 新增供应商
     * @param billinfo
     * @return
     */
    int addBillinfo(Billinfo billinfo);

    /**
     * 修改供应商
     * @param billinfo
     * @return
     */
    int modifyBillinfo(Billinfo billinfo);

}

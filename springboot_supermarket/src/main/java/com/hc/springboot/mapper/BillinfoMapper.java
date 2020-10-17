package com.hc.springboot.mapper;

import com.hc.springboot.pojo.Billinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hc.springboot.pojo.vo.BillinfoImplVO;
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
public interface BillinfoMapper extends BaseMapper<Billinfo> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<BillinfoImplVO> searchBillinfoPage(Page page);

    /**
     * 获取供应商的记录总数
     * @return
     */
    Integer totalCount(Page page);

    /**
     * 新增账单
     * @param billinfo
     * @return
     */
    int insertBillinfo(Billinfo billinfo);

    /**
     * 修改账单
     * @param billinfo
     * @return
     */
    int updateBillinfo(Billinfo billinfo);
}

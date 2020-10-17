package com.hc.springboot.mapper;

import com.hc.springboot.pojo.Supplierinfo;
import com.hc.springboot.pojo.Userinfo;
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
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    /**
     * 根据用户名和密码查询用户
     * @param userinfo
     * @return
     */
    Userinfo searchUserinfoByUserNameAndUserPwd(Userinfo userinfo);

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<Userinfo> searchUserinfoPage(Page page);

    /**
     * 获取供应商的记录总数
     * @return
     */
    Integer totalCount(Page page);

    /**
     * 修改用户信息
     * @param userinfo
     * @return
     */
    int updateUserinfo(Userinfo userinfo);
}

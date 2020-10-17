package com.hc.springboot.service;

import com.hc.springboot.pojo.Userinfo;
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
public interface UserinfoService extends IService<Userinfo> {

    /**
     * 用户登录
     * @param userinfo
     * @return
     */
    Userinfo login(Userinfo userinfo);

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page findUserinfoPage(Page page);

    /**
     * 修改用户信息
     * @param userinfo
     * @return
     */
    int modifyUserinfo(Userinfo userinfo);
}

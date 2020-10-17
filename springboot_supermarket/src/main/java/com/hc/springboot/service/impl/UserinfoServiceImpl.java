package com.hc.springboot.service.impl;

import com.hc.springboot.pojo.Userinfo;
import com.hc.springboot.mapper.UserinfoMapper;
import com.hc.springboot.service.UserinfoService;
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
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    /**
     * 用户登录
     *
     * @param userinfo
     * @return
     */
    @Override
    public Userinfo login(Userinfo userinfo) {
        return userinfoMapper.searchUserinfoByUserNameAndUserPwd(userinfo);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page findUserinfoPage(Page page) {
        page.setTotalCount(userinfoMapper.totalCount(page));
        Map<String,Object> map = new HashMap<>();
        map.put("currentPageNo",(page.getCurrentPageNo()-1)*page.getPageSize());
        page.setParamMap(map);
        page.setList(userinfoMapper.searchUserinfoPage(page));
        return page;
    }

    /**
     * 修改用户信息
     *
     * @param userinfo
     * @return
     */
    @Override
    public int modifyUserinfo(Userinfo userinfo) {
        return userinfoMapper.updateUserinfo(userinfo);
    }
}

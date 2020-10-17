package com.hc.springboot;

import com.hc.springboot.pojo.Userinfo;
import com.hc.springboot.service.UserinfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootSupermarketApplicationTests {

    @Autowired
    UserinfoService userinfoService;

    @Test
    void contextLoads() {
        System.out.println(userinfoService.getById(13));
    }

}

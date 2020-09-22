package com.cxl.test;

import com.cxl.order.OrderApplication;
import com.cxl.order.entry.User;
import com.cxl.order.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class TestUser {
    @Autowired
    private UserService userService;
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setId(1);
        user.setUsername("cxl");
        user.setPassword("123456");
        userService.insertUser(user);
    }

    @Test
    public void testSelectByUser(){
        User user = userService.SelectByUsername("cxl");
        System.out.println(user);
    }
}

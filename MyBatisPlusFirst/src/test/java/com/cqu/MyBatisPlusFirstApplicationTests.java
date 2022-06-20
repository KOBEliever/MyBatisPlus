package com.cqu;

import com.cqu.dao.UserDao;
import com.cqu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisPlusFirstApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void TestGetAll() {
        List<User> user = userDao.selectList(null);
        System.out.println(user);
    }

}

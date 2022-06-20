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
    void testSave(){
        User user = new User();
        user.setName("黑马程序员");
        user.setAge(16);
        user.setPassword("159753");
        user.setTel("123456789");
        userDao.insert(user);
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setName("Tom888");
        user.setTel("wowowow");
        userDao.updateById(user);
    }
    @Test
    void testDelete(){
        userDao.deleteById(1538890099570364418L);
    }
    @Test
    void testGetById(){
        User user = userDao.selectById(2L);
        System.out.println(user);
    }
    @Test
    void TestGetAll() {
        List<User> user = userDao.selectList(null);
        System.out.println(user);
    }

}

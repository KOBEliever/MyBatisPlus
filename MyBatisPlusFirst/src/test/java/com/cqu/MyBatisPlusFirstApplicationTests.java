package com.cqu;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqu.dao.UserDao;
import com.cqu.domain.User;
import com.cqu.query.UserQuery;
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
    @Test
    void TestGetByPage(){
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());
    }
    @Test
    void TestGetByParam(){
//        //方式一：按条件查询
//        QueryWrapper queryWrapper = new QueryWrapper();
//        //小于
//        queryWrapper.lt("age",18);
//        List<User> userList = userDao.selectList(queryWrapper);
//        System.out.println(userList);
//        //方式二：lambda格式
//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        //小于
//        queryWrapper.lambda().lt(User::getAge,18);
//        List<User> userList = userDao.selectList(queryWrapper);
//        System.out.println(userList);
        //方式三：lambda格式

        UserQuery userQuery = new UserQuery();
//        userQuery.setAge(18);
        userQuery.setAge2(40);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        //小于
        //先判断第一个参数是否为true，若为true则连接当前条件
        lambdaQueryWrapper.lt(null != userQuery.getAge2(),User::getAge,userQuery.getAge2());
        //大于
        lambdaQueryWrapper.gt(null != userQuery.getAge(),User::getAge,userQuery.getAge());
        List<User> userList = userDao.selectList(lambdaQueryWrapper);
        System.out.println(userList);
    }
}

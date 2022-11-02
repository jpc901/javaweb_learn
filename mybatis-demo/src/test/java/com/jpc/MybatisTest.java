package com.jpc;

import com.jpc.mapper.UserMapper;
import com.jpc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testSellect() throws IOException {
        // 1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取Mapper接口代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4.执行方法
        List<User> users = userMapper.selectAll();

        System.out.println(users);
    }
}

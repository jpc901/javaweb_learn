package com.jpc;

import com.jpc.mapper.BrandMapper;
import com.jpc.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatis {
    public static void main(String[] args) throws IOException {


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取代理
        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        Brand a = brandMapper.selectById(1);
        System.out.println(a);
//        System.out.println(brands);

        sqlSession.close();

    }
}

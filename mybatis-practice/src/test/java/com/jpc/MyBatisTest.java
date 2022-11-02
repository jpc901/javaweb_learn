package com.jpc;

import com.jpc.mapper.BrandMapper;
import com.jpc.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectByCondition() throws IOException{

        // 接收的参数
        int status = 1;
        String companyName = "华为";

        // 参数处理,模糊查询
        companyName = "%" + companyName + "%";

        // 封装对象
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);

//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);

        // 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取代理
        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brands = brandMapper.selectByCondition(status, companyName);

//        List<Brand> brands = brandMapper.selectByCondition(brand);

        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        // 释放资源
        sqlSession.close();
    }
}

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

    @Test
    public void testadd() throws IOException{

        // 接收的参数
        int status = 2;
        String companyName = "小米有限公司";
        String brandNmae = "红米";
        String description = "为烧焦而生";
        int ordered = 1;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandNmae);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        // 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取代理
        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        // 提交事务
//        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testupdate() throws IOException{

        // 接收的参数
        int id = 6;
        int status = 2;
        String companyName = "小米有限公司";
        String brandNmae = "红米";
        String description = "为发烧而生";
        int ordered = 100;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandNmae);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setId(id);

        // 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取代理
        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);

        // 提交事务
//        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }
    @Test
    public void testdelete() throws IOException{

        // 接收的参数
        int id = 6;



        // 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取代理
        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);

        // 提交事务
//        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }
}

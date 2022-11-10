package com.jpc.service;

import com.jpc.mapper.BrandMapper;
import com.jpc.pojo.Brand;
import com.jpc.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    // 查询所有
    public List<Brand> selectAll(){
        // 调用BrandMapper.selectAll()


        //获取sqlsession
        SqlSession sqlSession = factory.openSession();

        // 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;

    }

    public void add(Brand brand){
        //获取sqlsession
        SqlSession sqlSession = factory.openSession();

        // 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 调用方法
        brandMapper.add(brand);

        // 增删改一定要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    // 根据id查询
    public Brand selectById(int id){
        // 调用BrandMapper.selectAll()


        //获取sqlsession
        SqlSession sqlSession = factory.openSession();

        // 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);
        sqlSession.close();
        return brand;

    }

    public void update(Brand brand){
        //获取sqlsession
        SqlSession sqlSession = factory.openSession();

        // 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 调用方法
        brandMapper.update(brand);

        // 增删改一定要提交事务
        sqlSession.commit();

        sqlSession.close();
    }
    // 根据id查询
    public void deleteById(int id){
        // 调用BrandMapper.selectAll()


        //获取sqlsession
        SqlSession sqlSession = factory.openSession();

        // 获取brandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}

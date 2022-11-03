package com.jpc.mapper;

import com.jpc.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName);
//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    void add(Brand brand);

    void update(Brand brand);

    void deleteById(int id);
}

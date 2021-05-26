package com.example.emailback.mapper;

import com.example.emailback.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptMapper {
    int addDept(Dept dept);
    int deleteById(Integer id);
    int updateDeptById(Dept dept);
    List<Dept> findAllDept(@Param("userName") String userName, @Param("userId") Integer userId);
}

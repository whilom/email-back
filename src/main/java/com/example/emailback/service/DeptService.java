package com.example.emailback.service;

import com.example.emailback.entity.Dept;

import java.util.List;

public interface DeptService {
    int addDept(Dept dept);
    int deleteById(Integer id);
    int updateDeptById(Dept dept);
    List<Dept> findAllDept(String userName, Integer userId);
}

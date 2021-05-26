package com.example.emailback.service.serviceimpl;

import com.example.emailback.entity.Dept;
import com.example.emailback.mapper.DeptMapper;
import com.example.emailback.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public int deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }

    @Override
    public int updateDeptById(Dept dept) {
        return deptMapper.updateDeptById(dept);
    }

    @Override
    public List<Dept> findAllDept(String userName, Integer userId) {
        return deptMapper.findAllDept(userName, userId);
    }

}

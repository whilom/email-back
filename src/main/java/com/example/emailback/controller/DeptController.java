package com.example.emailback.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.emailback.entity.Dept;
import com.example.emailback.entity.RespBean;
import com.example.emailback.entity.RespPageBean;
import com.example.emailback.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @param userName
     * @param userId
     * @return
     */
    @GetMapping("/query")
    public RespPageBean findAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String userName, Integer userId){
        PageHelper.startPage(page, size);
        List<Dept> list = deptService.findAllDept(userName, userId);
        PageInfo pageInfo = new PageInfo(list);
        RespPageBean bean = new RespPageBean();
        bean.setData(pageInfo.getList());
        bean.setTotal(pageInfo.getTotal());
        return bean;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public RespBean deleteDept(@RequestParam Integer id){

       if(deptService.deleteById(id)==1){
            return RespBean.DELETE_SUCCESS;//删除成功
       }
        return RespBean.DELETE_ERROR;//删除失败
    }

    /**
     * 添加
     * @param dept
     * @return
     */
    @PostMapping("/add")
    public RespBean addDept(@RequestBody Dept dept){
        if(deptService.addDept(dept)==1){
            return RespBean.ADD_SUCCESS;//添加成功
        }
        return RespBean.ADD_ERROR;//添加失败
    }

    /**
     * 更新
     * @param dept
     * @return
     */
    @PutMapping("/update")
    public RespBean updateDept(@RequestBody Dept dept){
         if(deptService.updateDeptById(dept)==1){
              return RespBean.UPDATE_SUCCESS;//更新成功
           }
        return RespBean.UPDATE_ERROR;//更新失败
    }

}

package com.adamu.learning.controller;

import com.adamu.learning.entity.Department;
import com.adamu.learning.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{Id}")
    public Department fetchDepartmentById(@PathVariable("Id") Long departmentId){return departmentService.fetchDepartmentById(departmentId);}

    @DeleteMapping("/departments/{Id}")
    public String deleteDepartmentById(@PathVariable("Id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department successfully deleted!!";
    }

}

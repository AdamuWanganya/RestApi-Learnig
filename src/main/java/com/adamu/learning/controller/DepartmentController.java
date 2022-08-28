package com.adamu.learning.controller;

import com.adamu.learning.entity.Department;
import com.adamu.learning.error.DepartmentNotFoundException;
import com.adamu.learning.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside saveDepartment method is called in DepartmentController. ");
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        logger.info("Inside fetchDepartments method is called in DepartmentController");
        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{Id}")
    public Department fetchDepartmentById(@PathVariable("Id") Long departmentId) throws DepartmentNotFoundException {return departmentService.fetchDepartmentById(departmentId);}

    @DeleteMapping("/departments/{Id}")
    public String deleteDepartmentById(@PathVariable("Id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department successfully deleted!!";
    }

    @PutMapping("/departments/{Id}")
    public Department updateDepartmentById(@PathVariable ("Id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}

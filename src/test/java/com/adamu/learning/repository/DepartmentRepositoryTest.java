package com.adamu.learning.repository;

import com.adamu.learning.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@ComponentScan(basePackages = "learning")
@EnableJpaRepositories(basePackages = "learning")
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Computer Maths")
                        .departmentAddress("Eldoret")
                        .departmentCode("CM/016")
                        .build();
        entityManager.persist(department);
    }

    public void whenFindById_thenReturnDepartment(){
        Department department= departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Computer Maths");
    }
}
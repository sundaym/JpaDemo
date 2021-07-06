package com.demo.service;

import com.demo.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeServiceTest {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EmployeeService service;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();
        service = new EmployeeService(em);
    }

    @After
    public void destory() {
        // close the EM and EMF when done
        em.close();
        emf.close();
    }

    @Test
    public void testCreateEmployee() {
        // create and persist employee
        em.getTransaction().begin();
        service.createEmployee(1, "Tom", 30000L);
        service.createEmployee(2, "John", 40000L);
        service.createEmployee(3, "Ana", 50000L);
        em.getTransaction().commit();
    }

    @Test
    public void testFindEmployee() {
        // find a specific employee
        Employee emp = service.findEmployee(1);
        System.out.println(emp);
    }

    @Test
    public void testFindAllEmployees() {
        // find all employees
        List<Employee> allEmployees = service.findAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testUpdateEmployee() {
        // update the employee
        em.getTransaction().begin();
        Employee employee = service.raiseEmployeeSalary(1, 30000L);
        em.getTransaction().commit();
        System.out.println("Tom:" + employee);
    }

    @Test
    public void testRemoveEmployee() {
        // remove an employee
        em.getTransaction().begin();
        service.removeEmployee(3);
        em.getTransaction().commit();
        System.out.println("Removed Employee 3");
    }
}

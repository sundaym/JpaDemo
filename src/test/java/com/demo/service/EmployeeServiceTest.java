package com.demo.service;

import com.demo.model.Employee;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeServiceTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
    private EntityManager em = emf.createEntityManager();
    private EmployeeService service = new EmployeeService(em);

    @Test
    public void testCreateEmployee() {
        // create and persist employee
        em.getTransaction().begin();
        service.createEmployee(1, "Tom", 30000L);
        service.createEmployee(2, "John", 40000L);
        service.createEmployee(3, "Ana", 50000L);
        em.getTransaction().commit();
        // close the EM and EMF when done
        em.close();
        emf.close();
    }

    @Test
    public void testFindEmployee() {
        // find a specific employee
        Employee emp = service.findEmployee(1);
        System.out.println(emp);
        // close the EM and EMF when done
        em.close();
        emf.close();
    }

    @Test
    public void testFindAllEmployees() {
        // find all employees
        List<Employee> allEmployees = service.findAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(employee);
        }
        // close the EM and EMF when done
        em.close();
        emf.close();
    }

    @Test
    public void testUpdateEmployee() {
        // update the employee
        em.getTransaction().begin();
        Employee employee = service.raiseEmployeeSalary(1, 30000L);
        em.getTransaction().commit();
        System.out.println("Tom:" + employee);
        // close the EM and EMF when done
        em.close();
        emf.close();
    }

    @Test
    public void testRemoveEmployee() {
        // remove an employee
        em.getTransaction().begin();
        service.removeEmployee(3);
        em.getTransaction().commit();
        System.out.println("Removed Employee 3");
        // close the EM and EMF when done
        em.close();
        emf.close();
    }
}

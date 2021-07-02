package com.demo.test;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeServiceTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        EmployeeService service = new EmployeeService(em);

        // create and persist employee
        em.getTransaction().begin();
        service.createEmployee(1, "Tom", 30000L);
        service.createEmployee(2, "John", 40000L);
        service.createEmployee(3, "", 50000L);
        em.getTransaction().commit();

        // find a specific employee
        Employee emp = service.findEmployee(1);
        System.out.println(emp);

        // find all employees
        List<Employee> allEmployees = service.findAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(employee);
        }

        // update the employee
        em.getTransaction().begin();
        Employee employee = service.raiseEmployeeSalary(1, 30000L);
        em.getTransaction().commit();
        System.out.println("Tom:" + employee);

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

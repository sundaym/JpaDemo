package com.demo.service;

import com.demo.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeService {
    protected EntityManager em;

    public EmployeeService(EntityManager em) {
        this.em = em;
    }

    public Employee createEmployee(Integer id, String name, Long salary) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }

    public Employee findEmployee(Integer id) {
        return em.find(Employee.class, id);
    }

    public void removeEmployee(Integer id) {
        Employee emp = findEmployee(id);
        if (emp != null) {
            em.remove(emp);
        }
    }

    public Employee raiseEmployeeSalary(Integer id, Long raise) {
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() + raise);
        }
        return emp;
    }

    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
}

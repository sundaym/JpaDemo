package com.demo.service;

import com.demo.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JpaTest {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;

    /**
     * @Before init() will be invoked before every method
     */
    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();
        // 开启事务
        transaction = em.getTransaction();
        transaction.begin();
    }

    /**
     * 关闭资源顺序和创建资源顺序相反
     */
    @After
    public void destory() {
        // 提交事务
        transaction.commit();
        // 释放资源
        em.close();
        emf.close();
    }

    /**
     * Hibernate get
     */
    @Test
    public void testFind() {
        // 根据id查询，立即查询数据库
        Employee employee = em.find(Employee.class, 1);
        System.out.println("------------------------");
        System.out.println(employee);
    }

    /**
     * Hibernate load
     */
    @Test
    public void testGetReference() {
        // 获取一个动态代理对象，不会立刻发送SQL语句查询数据库，延迟装载
        Employee employee = em.getReference(Employee.class, 1);
        String name = employee.getClass().getName();
        System.out.println("Proxy class name:" + name);
        System.out.println("------------------------");
        System.out.println(employee);
    }

    /**
     * Hibernate save
     */
    @Test
    public void testPersist() {
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("ABC");
        employee.setSalary(100000L);
        em.persist(employee);
    }

    /**
     * delete
     */
    @Test
    public void testRemove() {
        Employee emp = em.find(Employee.class, 100);
        em.remove(emp);
    }

    /**
     * save or update
     */
    @Test
    public void testMerge() {
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("ASD");
        employee.setSalary(21230L);

        em.merge(employee);
    }

    @Test
    public void testFlush() {
        Employee employee = em.find(Employee.class, 1);
        System.out.println(employee);

        employee.setSalary(30000L);
        em.flush();
    }

    @Test
    public void testRefresh() {
        Employee employee = em.find(Employee.class, 2);
        em.flush();
    }

    @Test
    public void testSecondLecelCache() {
        Employee employee = em.find(Employee.class, 1);
        transaction.commit();
        em.close();
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee1 = entityManager.find(Employee.class, 1);
    }

    @Test
    public void testJpql() {
        String jpql = "SELECT e FROM Employee e WHERE e.salary > ?";
        Query query = em.createQuery(jpql);
        query.setParameter(1, 1000000L);
        List<Employee> employees = query.getResultList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testJpql1() {
        String jpql = "SELECT new Employee(a.name, a.salary) FROM Employee a WHERE a.salary > ?";
        Query query = em.createQuery(jpql);
        query.setParameter(1, 10000L);
        List<Employee> employees = query.getResultList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testNamedQuery() {
        Query query = em.createNamedQuery("testNamedQuery").setParameter(1, "Tom");
        Employee employee = (Employee) query.getSingleResult();
        System.out.println(employee);
    }

    /**
     * native sql
     */
    @Test
    public void testNativeQuery() {
        String sql = "select ID, NAME, SALARY from Employee where ID = ?";
        Query query = em.createNativeQuery(sql, Employee.class).setParameter(1, 3L);
        Employee employee = (Employee) query.getSingleResult();
        System.out.println(employee);
    }
}

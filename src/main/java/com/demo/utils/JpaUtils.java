package com.demo.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA工具类
 */
public class JpaUtils {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("EmployeeService");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

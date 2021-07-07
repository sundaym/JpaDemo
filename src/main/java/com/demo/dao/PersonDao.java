package com.demo.dao;

import com.demo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDao {

//    @Autowired
//    private EntityManagerFactory emf;

    // 获取和当前事务关联的EntityManager实例, @PersistenceContext
    @PersistenceContext
    private EntityManager em;

    public void save(Person person) {
        em.persist(person);
    }
}

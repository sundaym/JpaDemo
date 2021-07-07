package com.demo.service;

import com.demo.dao.PersonDao;
import com.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Transactional
    public void savePersons(Person p1, Person p2) {
        personDao.save(p1);
        personDao.save(p2);
    }
}

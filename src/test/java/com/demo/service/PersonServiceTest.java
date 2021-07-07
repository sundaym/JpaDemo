package com.demo.service;

import com.demo.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonServiceTest {

    private ApplicationContext ctx = null;
    private PersonService personService;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        personService = ctx.getBean(PersonService.class);
    }

    @Test
    public void testPersonService() {
        Person p1 = new Person();
        p1.setName("tqqq");
        p1.setAge(25);

        Person p2 = new Person();
        p2.setName("qqq");
        p2.setAge(26);

        personService.savePersons(p1, p2);
    }
}

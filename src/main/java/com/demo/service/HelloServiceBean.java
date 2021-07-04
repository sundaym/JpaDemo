package com.demo.service;

/**
 * You can implement a component as a simple class containing the business logic
 * without an interface, and use this class as if it were an interface.
 */
public class HelloServiceBean implements HelloService {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}

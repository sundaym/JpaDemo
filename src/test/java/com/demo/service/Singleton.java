package com.demo.service;

public class Singleton {
    private Singleton() {
        System.out.println("new a instance");
    }

    private static Singleton instance = new Singleton();
    private static Singleton instance1 = null;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton getInstance1() {
        if (instance1 == null) {
            instance1 = new Singleton();
        }
        return instance1;
    }

    public static void test() {
        System.out.println("create a singleton");
    }
}

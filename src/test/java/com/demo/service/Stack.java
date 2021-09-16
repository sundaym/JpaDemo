package com.demo.service;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 会造成内存泄漏
 */
public class Stack {
    private Object[] elemenets;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elemenets = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elemenets[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return elemenets[--size];
    }

    private void ensureCapacity() {
        if (elemenets.length == size) {
            elemenets = Arrays.copyOf(elemenets, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
    }
}

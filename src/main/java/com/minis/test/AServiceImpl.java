package com.minis.test;

public class AServiceImpl implements AService{
    private String property1;

    private String name;

    private int level;

    @Override
    public void sayHello() {
        System.out.println("a service i say hello");
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public AServiceImpl(String name, int level) {
        this.name = name;
        this.level = level;
    }
}

package com.minis;

public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singleton);

    Object getSingleton(String beanName);

    boolean containSingleton(String beanName);

    String[] getSingletonNames();
}

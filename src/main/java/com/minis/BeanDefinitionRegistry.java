package com.minis;

public interface BeanDefinitionRegistry {
    void registryBeanDefinition(String name, BeanDefinition bd);
    void removeBeanDefinition(String name);
    BeanDefinition getBeanDefinition(String name);
    boolean containBeanDefinition(String name);
}

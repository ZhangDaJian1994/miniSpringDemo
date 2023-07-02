package com.minis;

/**
 * 管理 bean
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    void registerBean(BeanDefinition beanDefinition);

    boolean containBean(String beanName);

    void registryBean(String beanName, Object obj);

    boolean isSingleton(String name);

    boolean isPrototype(String name);

    Class<?> getType(String name);


}

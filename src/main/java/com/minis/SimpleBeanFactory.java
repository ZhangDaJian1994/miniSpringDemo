package com.minis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object object = singletons.get(beanName);
        if (object == null) {
            BeanDefinition beanDefinition = beanDefinitions.get(beanName);
            if (beanDefinition == null) {
                throw new BeansException("No Bean.");
            }
            try {
                object = Class.forName(beanDefinition.getClassName()).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            registerSingleton(beanName, object);
        }
        return object;
    }

    @Override
    public void registerBean(BeanDefinition beanDefinition) {
        this.beanDefinitions.put(beanDefinition.getId(), beanDefinition);
    }

    public boolean containBean(String beanName) {
        return containSingleton(beanName);
    }

    public void registryBean(String beanName, Object obj) {
        registerSingleton(beanName, obj);
    }

    @Override
    public boolean isSingleton(String name) {
        return this.beanDefinitions.get(name).isSingleton();
    }

    @Override
    public boolean isPrototype(String name) {
        return this.beanDefinitions.get(name).isPrototype();
    }

    @Override
    public Class<?> getType(String name) {
        return this.beanDefinitions.get(name).getClass();
    }

    @Override
    public void registryBeanDefinition(String name, BeanDefinition bd) {
        this.beanDefinitions.put(name, bd);
        if (!bd.isLazyInit()) {
            try {
                getBean(name);
            } catch (BeansException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeBeanDefinition(String name) {
        this.beanDefinitions.remove(name);
    }

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return this.beanDefinitions.get(name);
    }

    @Override
    public boolean containBeanDefinition(String name) {
        return this.beanDefinitions.containsKey(name);
    }
}

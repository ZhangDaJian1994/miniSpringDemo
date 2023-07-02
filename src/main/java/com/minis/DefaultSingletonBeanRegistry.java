package com.minis;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    // 存放bean 实例
    protected Map<String, Object> singletons = new ConcurrentHashMap<>(256);

    @Override
    public void registerSingleton(String beanName, Object singleton) {
        singletons.put(beanName, singleton);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletons.get(beanName);
    }

    @Override
    public boolean containSingleton(String beanName) {
        return singletons.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return singletons.keySet().toArray(new String[0]);
    }
}

package com.minis;

import com.apple.eawt.ApplicationEvent;

public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher{
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        ClassPathXmlResource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }
    //
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBean(BeanDefinition beanDefinition) {

    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBean(beanDefinition);
    }

    public boolean containBean(String beanName) {
        return this.beanFactory.containBean(beanName);
    }

    public void registryBean(String beanName, Object obj) {
        this.beanFactory.registryBean(beanName, obj);
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        return false;
    }

    @Override
    public Class<?> getType(String name) {
        return null;
    }

    @Override
    public void publishEvent(ApplicationEvent applicationEvent) {

    }
}

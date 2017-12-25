package com.bhawesh;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanAccessor implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T getSingleton(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    public static <T> T getSingleton(String beanName, Class<T> clazz){
        return applicationContext.getBean(beanName, clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanAccessor.applicationContext = applicationContext;
    }

}
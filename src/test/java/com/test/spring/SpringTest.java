package com.test.spring;

import com.wp.practise.model.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Wangpeng on 2017/9/12.
 */
public class SpringTest {

    public static void main(String[] args) {

        /**
         * spring Ioc简单实现 ：
         * 1、定位资源文件（xml）
         * 2、解析资源文件
         * 3、实现注册（BeanFactory）
         */
        ClassPathResource classPathResource = new ClassPathResource("spring/applicationContext-practise.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
        String[] beanDefinitionNames = defaultListableBeanFactory.getBeanDefinitionNames();
        for (String s : beanDefinitionNames)
            System.out.println(s);
        System.out.println("count:" + defaultListableBeanFactory.getBeanDefinitionCount());
        ((User)defaultListableBeanFactory.getBean("iocTest")).eat();
        springIocTest();
    }

    public static void springIocTest(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring/applicationContext-practise.xml");
        System.out.println(applicationContext.getBeanDefinitionCount());
    }

}

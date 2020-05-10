package com.zhangjie.servlet;

import com.zhangjie.service.HelloService;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;
// 容器启动的时候会将 @HandlesTypes 指定的这个类型下面的子类(实现类，子接口等)传递过来
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * 应用启动的时候会运行 onStartup 方法
     * @param set @HandlesTypes 注解中引入的所有的类型的子类
     * @param servletContext 代表当前 Web 应用的 servletContext ，一个 web 应用对应一个 ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类型：");
        set.forEach(clazz -> System.out.println(clazz.getName()+":"+clazz));

    }
}

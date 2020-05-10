package com.zhangjie.servlet;

import com.zhangjie.service.HelloService;

import javax.servlet.*;
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
     * 使用 ServletContext 注册 Web 组件（Servlet、Filter、Listener）
     *
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类型：");
        set.forEach(clazz -> System.out.println(clazz.getName()+":"+clazz));
        // 注册组件
        ServletRegistration.Dynamic userServlet = servletContext.addServlet("userServlet", new UserServlet());

    }
}

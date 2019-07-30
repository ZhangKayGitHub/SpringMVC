package com.kay.controller.com.kay.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *自定义拦截器
 */
public class MyInterceptor2 implements HandlerInterceptor {//实现接口不用写方法，jdk1.8对接口进行了增强（接口中定义方法，并且把方法都实现了）

    /**
     * 预处理，controller方法执行之前
     * 代码若返回 return true 就表示放行，执行下一个拦截器，如果没有就执行controller中的方法
     * return false表是不放行，通过preHandle()方法中的request或response跳转到相应的提示页面
     * 到springmvc.xml配置文件中配置拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        System.out.println("MyInterceptor1执行了...前2222");
        return true;//继续后续的拦截器

//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
//        return false;
    }

    /**
     * 后处理方法，controller方法执行之后，success.jsp之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("MyInterceptor1执行了...后2222");
    }

    /**
     *success.jsp页面执行之后执行，可以用于释放一些资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("MyInterceptor1执行了...最后2222");
    }
}

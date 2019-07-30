package com.kay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){//该方法（也就是web层，或处理器层）发生异常后通过throws 将异常抛给前端控制器，前端控制器再把异常抛给前端页面

        System.out.println("testInterceptor方法执行了...");

        return "success";

    }


    /**
     * Spring MVC 的拦截器类似于Servlet开发中的过滤器Filter,用于对 处理器进行预处理和后处理。
     * 用户可以自己定义一些拦截器来实现特定的功能。
     * 谈到拦截器，还要向大家提一个词-————拦截器链(Interceptor Chain)，拦截器链就是将拦截器按一定的顺序连接成一条链，
     * 在访问被拦截的方法或字段时，拦截器就会按照之前定义的的顺序被调用。
     * 说到这里可能大家脑海中有一个疑问，者不是我们之前学过的过滤器吗？
     * 是的他和过滤器有几分相似，但是也有区别，接下来我们来说以下他们的区别：
     * 过滤器是Servlet规范中的一部分，任何java web 工程都可以使用
     * 拦截器是SpringMVC框架自己的，值有使用了SpringMVC框架的工程才能用
     * 过滤器在url-pattern中配置 /* 之后，可以对所有的要访问的资源拦截。
     * 拦截器它是只会拦截访问的控制器方法，如果访问的是jsp、html、css、image或者js是不会进行拦截的，
     * 它是AOP思想的具体应用
     * 我们要自定义拦截器，要必须实现：HandlerInterceptor接口。
     *
     */

    /**
     * 编写拦截器类，必须实现HandlerInterceptor接口
     * 配置拦截器类
     */

}

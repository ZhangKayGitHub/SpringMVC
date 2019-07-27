package com.kay.controller;

import com.kay.domain.Account;
import com.kay.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;


/**
 * 请求参数绑定入门
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了.....");
        System.out.println("你的用户名： " + username);
        System.out.println("你的用户密码： " + password);
        return "success";
    }

    /**
     * 把请求参数封装到一个JavaBean当类中，要求是表单中的name必须与JavaBean中的属性一致
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){//此处直接写一个Account就可以自动的将表单中的数据分装到Account中对应的属性中
        System.out.println("执行了.....");
        System.out.println("你的用户名： " +account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){//此处直接写一个Account就可以自动的将表单中的数据分装到Account中对应的属性中
        System.out.println("执行了.....");
        System.out.println(user);
        return "success";
    }

    /**
     * 获取原生的API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request,HttpServletResponse response){//卫生没有提示我也比清楚
        System.out.println("执行了.....");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);

        return "success";
    }
}

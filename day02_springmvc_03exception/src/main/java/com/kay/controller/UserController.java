package com.kay.controller;

import com.kay.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws SysException{//该方法（也就是web层，或处理器层）发生异常后通过throws 将异常抛给前端控制器，前端控制器再把异常抛给前端页面

        System.out.println("testException方法执行了...");

        try {
            //模拟一i个异常
            int a = 1/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义的异常信息
            throw new SysException("查询所以的用户出现错误了...");
        }
        return "success";

    }
    /**
     * 1、编写自定义异常类（做提示信息用的）
     * 2、编写异常处理器
     * 3、配置异常处理器（跳转到提示页面）
     */
}

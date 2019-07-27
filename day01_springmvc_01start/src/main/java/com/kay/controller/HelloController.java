package com.kay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器类
 */
@Controller//添加该注解等于把这个类交给Spring 的IOC 容器进行管理
@RequestMapping(path="/user")//添加了类的亲故其路径，要请求该类中的方法时，需要在要要请求的方法的路径前面加上该路径
public class HelloController {

    /**
     * 上边定义了@Controller注解将HelloController 添加到IOC 容器中，但是怎么执行下面的sayHello方法呢？
     * 因此需要在该方法上面添加一个注解叫@RequestMapping
     *
     *
     * @RequestMapping的作用：
     *      用于建立请求URL和处理请求方法之间的对应关系。
     * @RequestMapping出现的位置：
     *      类上：
         *      请求URL的第一级访问目录，此处不写的话，就相当于应用的根目录，写的话需要以 / 开头，
         *      它出现的目的就是为了使我们的URL可以按照模块化管理：
         *      例如：
         *      账户模块：
         *          /account/add
         *          /account/update
         *          /account/delete
         *      订单模块：
         *          /order/add
         *          /order/update
         *          /order/delete
         *      前边相同的部分就是把RequestMapping 写在类上，使我们的URL更加的精细，
     *
     *      方法上：
     *          请求URL的第二级访问目录
     *
     *
     *      属性:
     *          value:用于指定请求的URL,它和path属性的作用是一样的。
     *          method：作用指定请求的方式
     *          params：用于指定限制i请求参数的条件，它支持简单的表达式，要求要求请求参数的key和value必须和配置的一模一样。
     *          例如：
     *              params = {"accountName"},表示请求参数必须有accountName
     *              params = {"money!100"},表示请求参数中money不能是100.
     *          headers:用于指定限制请求消息头的条件。
     *          注意：
     *              以上四个属性只要出现2个以上时，它们的关系时与的关系
     *
     * @return
     */
    @RequestMapping(path = "/hello")//请求的一个映射，以后/hello就是下边方法的请求路径//path和value时一样的
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
        //mvc框架有一个默认的规则，当你返回一个字符串，这个字符串就默认的当成了要显示的jsp页面的名字，“success”，则就是success.jsp
        //要想找到找到success.jsp 页面，还需要配置一个视图解析器在springmvc.xml配置文件中
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(value = "/testRequestMapping",/*method = {RequestMethod.POST},*/params = {"username=heihei"},headers = {"Accept"})
    //如果在类的上面也用了RequestMapping注解则要还想请求到该方法就需要在该方法的请求路径的前面加上类的请求路径
    //由于上边的注解中定义了method属性,该属性的之时一个方法类的数组，表示允许的请求消息头类型，
    // 因此该方法由于在index.jsp 页面中时通过超链接的方式（也就是get请求），因此会报Request method 'GET' not supported错。
    //该方法的上边的RequestMapping注解的属性中的params 属性，用于要求请求该方法时必须有username这个参数且参数的值必须为heihei
    //否者就会报 Parameter conditions "username=heihei" not met for actual request parameters:
    //当然也可以只定义参数不限制参数的值
    //header属性；用于指定发送的请求头中必须包含Accept，就可以访问成功
    public String testRequestMapping(){
        System.out.println("测试@RequestMapping(path)注解.....");
        return "success";
    }
}

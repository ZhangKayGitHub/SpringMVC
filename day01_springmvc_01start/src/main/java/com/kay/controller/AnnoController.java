package com.kay.controller;

import com.kay.domain.User;
import java.util.Date;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

/**
 * 常用注解
 */
@Controller
@SessionAttributes(value={"msg"})//把msg=美美存放到session域对象中来
@RequestMapping("/anno")
public class AnnoController {

    @RequestMapping("/testRequestParame")
    public String testRequestParame(@RequestParam(name = "name") String username){//RequestParame用于当请求的参数名与处理器中方法参数的名字不一致时使用
        System.out.println("执行了....");
        System.out.println(username);
        return "success";
    }
    /**
    * RequestBody
    * 作用：用于获取请求体内容，直接使用得到的是key=value&key=value...结构的数据。
    * get 请求方式不适用
    * 属性：
    * required：是否必须有请求方法体，默认值是：true，当取值为true时，get 请求方式会报错，如果取值为false，get请求得到的是null；
     * */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){//RequestBody注解就是要获得整个表单提交后的请求体的内容

        System.out.println("执行了....");
        System.out.println(body);//输出的就是整个请求体的字符串
        return "success";
    }
    /**
     * PathVaribale注解
     * 作用：用于绑定url中的占位符，列如：请求url中/delete/（id），这个（id）就是url占位符。
     *      url支持占位符是spring3.0之后加入的。是springmvc支持rest风格URL的一个重要标志
     * 属性：value：用于指定url中占位符名称
     *      requried：是否必须提供占位符。
     */
    @RequestMapping(value = "/testPathVaribale/{sid}")
    public String testPathVaribale(@PathVariable(name = "sid") String id){

        System.out.println("执行了....");
        System.out.println(id);
        return "success";
    }
    /**
     * 基于HiddenHttpMethodFilter的示例
     *
     * 作用：由于浏览器form表单只支持GET与POST请求，而DELETE，PUT等method并不支持，spring3.0添加了一个过滤器，
     * 可以将浏览器请求改为指定的请求方式，发送给我们的控制器方法，使得支持GET、POST、DELETE，PUT等请求。
     * 使用方法：
     *      第一步：在web.xml中配置该过滤器。
     *      第二步：请求方式必须使用post请求。
     *      第三步：按照要求提供method请求参数，该参数的取值就是我们需要的请求方式。
     *
     */

    /**
     *
     * RequestHeader
     * 作用：用于获取请求的消息头。
     * 属性：value：提供消息头名称
     *      required：是否必须有此消息头
     * 注意：在实际开发中一般不怎么用
     *
     *
     * 获取请求头信息
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){

        System.out.println("执行了....");
        System.out.println(header);
        return "success";
    }
    /**
     * CookieValue
     * 作用：用于把指定的cookie名称的值传入控制器方法参数
     * 属性：value：指定cookie的名称
     *      required：是否必须有此cookie。
     *
     * 获取cookie的值
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){

        System.out.println("执行了....");
        System.out.println(cookieValue);
        return "success";
    }
    /**
     * ModelAttribute
     * 作用：该注解是SpringMVC4.3版本之后新加入的，它可以用于修饰方法和参数。
     *      出现在方法上，表示当前方法会在控制器的方法执行之前，先执行，它可以修饰没有返回值的方法，也可以修饰具有返回值得方法。
     *      出现在参数上，获取指定的数据，给参数赋值。
     * 属性：value：用于获取数据的key，key可以是POJO的属性名，也可以是map结构的key
     *      应用场景：当表单提交数据不是完整的实体的数据时，保证没有提交数据的字段使用数据库对象原有的数据。
     * 例如：我们在编辑一个用户时，用户有一个创建信息字段，该字段的值是不允许修改的，在提交表单数据是肯定没有此字段的内容，
     * 一旦更新会把该字段的内容置为努力了，此时就可以使用此注解解决问题了
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了....");
        System.out.println(user);
        return "success";
    }//showUser方法优于testModelAttribute方法先执行

    @ModelAttribute//在方法上添加ModelAttribute注解
    public void showUser(String uname, Map<String,User> map){//由于该方法限制性可以
        System.out.println("showUser这个方法执行了....");
        //通过用户查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }

    /*
     @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了....");
        System.out.println(user);
        return "success";
    }//showUser方法优于testModelAttribute方法先执行


    @ModelAttribute//在方法上添加ModelAttribute注解
    public User showUser(String uname){//由于该方法限制性可以
        System.out.println("showUser这个方法执行了....");
        //通过用户查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
    */

    /**
     * SessionAttributes注解,只能作用在类上
     * 作用：用于多次执行控制器方法间的参数共享
     * 属性：value：用于指定存入属性的名称
     *      type：用于指定存入的数据类型
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行了....");
        //底层会存储到request域对象中
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行了....");
        //底层会存储到request域对象中
        String msg = (String)modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清楚操作
     * @param status
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes执行了....");
        status.setComplete();//删除操作
        return "success";
    }
}

package com.kay.controller;

import com.kay.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller//把类交给容器管理
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值是字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString 方法执行了....");
        //模拟从数据库中查询出User对象

        User user = new User();
        user.setUsername("美美");
        user.setPassword("123456");
        user.setAge(30);
        //model对象
        model.addAttribute("user",user);

        return "success";
    }

    /**
     * 返回值类型是void
     *
     * 请求转发和重定向
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("testVoid 方法执行了....");
        //先了解一下它的默认情况，如果没有返回值，默认的会请求以该方法名字为名的jsp页面，
        // 如果以该路径（/Springmvc_01response/WEB-INF/pages/user/testVoid.jsp）下的testVoid.jsp页面文件不存在，就会报错
        //编写一个请求转发的程序，手动转发的化不会调用视图解析器，因此需要些一个完整的路径
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //一般转发完之后当前代码后边的代码还是会执行的，为了防止代码继续执行，就可以添加一个 return

        //还可以采用重定向的方式（是两次请求）,还有就是重定向不可以直接请求/WEB-INF目录下边的文件的
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //直接会进行响应（也就是直接用输出流将内容打印）
        // 如果想要写中文，就要设置中文响应的
        response.setCharacterEncoding("UTF-8");
        //设置浏览器解析的编码
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");

        return ;

    }

    /**
     * 返回值是ModelAndView对象，也可以通过视图解析器帮我们跳转到某某页面
     * 1.ModelAndView对象是Spring提供的一个对象，可以用来调整具体的JSP视图，该对象也可以用作控制器方法的返回值。该对象中有两个方法
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

        //1.创建一个ModelAndView对象，该对象是Spring对象帮我们提供的，因此可以直接创建
        ModelAndView mv = new ModelAndView();

        System.out.println("testModelAndView 方法执行了....");
        //模拟从数据库中查询出User对象

        User user = new User();
        user.setUsername("小芳");
        user.setPassword("123456");
        user.setAge(30);

        //调用ModelAndView中提供的方法，把user对象存储到mv对象中，也会把user对象存入到request对象当中
        mv.addObject("user",user);
        //想要跳转到哪个页面可以设置一个视图
        mv.setViewName("success");//设置一个视图的名称，可以发现没有指定目录和后缀名，是因为它会调用视图解析器去执行
        //返回字符串的方式其实底层也是调用的ModelAndView的方式
        return mv;
    }
    /**
     * 转发和重定向
     * forward转发
     * controller方法在提供了String类型的返回值之后，默认就是请求转发。
     *
     * 使用关键字的方式进行转发或者重定向
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(Model model){
        System.out.println("testForwardOrRedirect 方法执行了....");

        //请求的转发
        //return "forward:/WEB-INF/pages/success.jsp";//必须要使用forward关键字
        //重定向//重定向是是否要在请求的路径前加项目名呢？此处就没有添加项目的名字，一样可以重定向，因为框架底层已经帮我们添加了
        return "redirect:/index.jsp";
    }
    /**
     * ResponseBody响应json数据
     * 1.DispatcherServlet 会拦截所有的资源，导致一个问题就是静态资源（img，css，js）也会被拦截到，
     * 从而不能使用，解决问题就是需要配置静态支援不进行拦截，在springmvc.xml配置文件添加如下配置：
     *      （1）mvc:resources标签配置不过滤
     *          1）location元素表示webapp目录下的包下的所有文件
     *          2）mapping元素表示以static开头的所有请求路径，如/static/a或者a/b
     *
     * 2。使用@RequestBody获取请求体数据
     *
     *
     * 模拟异步请求和响应
     */

    @RequestMapping("/testAjax")//可能是拦截器的原因该方法不能够执行
    public @ResponseBody User testAjax(@RequestBody User user){//@ResponseBody将返回的user对象封装成json对象
        System.out.println("testAjax 方法执行了....");
        //客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //作响应模拟查询数据库
        user.setUsername("xixi");
        user.setAge(40);
        //作响应
        return user;
    }


}

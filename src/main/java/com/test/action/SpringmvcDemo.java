package com.test.action;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.test.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/spring")
public class SpringmvcDemo {

    @RequestMapping("/returnstring")
    public String returnString(){
        System.out.println("返回字符串。。。。");
        return "success";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        System.out.println("modelAndView。。。。");
        ModelAndView modelAndView1 = new ModelAndView();
        modelAndView1.setViewName("success");
        return modelAndView1;
    }

    @RequestMapping("/forwardvoid")
    public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("转发。。。。");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
    }

    @RequestMapping("/forwardString")
    public String forwardString() throws ServletException, IOException {
        System.out.println("转发。。。。");
        return "forward:/WEB-INF/pages/success.jsp";
    }
    @RequestMapping("/redirectvoid")
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("重定向。。。。");
        response.sendRedirect(request.getContextPath() + "/redirect.jsp");
    }

    @RequestMapping("/redirectString")
    public String redirectString() throws ServletException, IOException {
        System.out.println("重定向。。。。");
        return "redirect:/redirect.jsp";
    }

    @PostMapping(value = "/requestForm")
    public String RequestBean(User  user) throws ServletException, IOException {
        System.out.println("请求实体参数。。。。");
        System.out.println(user);
        return "success";
    }

    @PostMapping(value = "/requestAjax")
    public String requestAjax(@RequestBody User  user) throws ServletException, IOException {
        System.out.println("请求实体参数。。。。");
        System.out.println(user);
        return "success";
    }

    @PostMapping(value = "/fileupload")
    public String fileupload(HttpServletRequest request, MultipartFile upload) throws ServletException, IOException {
        System.out.println("springmvc文件上传。。。。");
        //获取上传夹路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        System.out.println(path);
        //获取文件名称
        String fileName = upload.getOriginalFilename();
        upload.transferTo(new File(path,fileName));
        return "success";
    }

    /**
     * 跨服务器上传文件
     * @param request
     * @param upload
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping(value = "/fileupload2")
    public String fileupload2(MultipartFile upload) throws ServletException, IOException {
        System.out.println("跨服务器文件上传。。。。");
        String path = "http://localhost:9090/uploads/";
        //获取文件名称
        String fileName = upload.getOriginalFilename();
        Client client = Client.create();
        WebResource resource = client.resource(path + fileName);
        //上传
        resource.put(upload.getBytes());
        return "success";
    }
}

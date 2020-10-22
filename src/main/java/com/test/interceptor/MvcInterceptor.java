package com.test.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MvcInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
            return true 表示放行
                    false 表示不放行

            拦截过程中也可使用request response 进行转发或重定向
         */
        System.out.println("mvc 拦截器1.。。。。。。。。。");
        return true;
    }
}

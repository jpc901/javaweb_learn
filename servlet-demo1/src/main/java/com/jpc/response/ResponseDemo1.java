package com.jpc.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

        // 重定向
//        // 设置响应状态码302
//        response.setStatus(302);
//        // 设置响应头
//        response.setHeader("Location", "/servlet_demo1_war/resp2");

        // 简化方式完成重定向
        response.sendRedirect("/servlet_demo1_war/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

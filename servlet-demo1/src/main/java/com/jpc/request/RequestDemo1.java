package com.jpc.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 请求行部分
        // 获取请求方式：GET
        String method = req.getMethod();

        // 获取虚拟目录
        String contextPath = req.getContextPath();

        // 获取URL
        StringBuffer url = req.getRequestURL();

        // 获取URI
        String uri = req.getRequestURI();

        // 获取请求参数
        String queryString = req.getQueryString();


        //--------请求头部分
        // 获取请求头：user-agent:浏览器版本信息
        String header = req.getHeader("user-agent");


        System.out.println(method);
        System.out.println(contextPath);
        System.out.println(url);
        System.out.println(uri);
        System.out.println(queryString);
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求体：
        // 获取字符输入流：
        BufferedReader br = req.getReader();

        // 读取数据
        String line = br.readLine();
        System.out.println(line);
    }
}

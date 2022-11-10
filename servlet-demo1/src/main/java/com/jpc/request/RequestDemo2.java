package com.jpc.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取Map集合
        Map<String, String[]> map = req.getParameterMap();
        for(String key : map.keySet()) {
            System.out.print(key+": ");
            String[] values = map.get(key);
            for(String val : values){
                System.out.print(val + " ");
            }
            System.out.println("");
        }
        System.out.println("===============");

        // 更具key获取参数
        String[] hobbies = req.getParameterValues("hobby");
        for(String hobby : hobbies) {
            System.out.print(hobby + " ");
        }
        System.out.println("===============");


        // 获取单个值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

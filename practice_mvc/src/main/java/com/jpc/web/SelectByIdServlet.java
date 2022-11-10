package com.jpc.web;

import com.jpc.pojo.Brand;
import com.jpc.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收id
        String id = request.getParameter("id");

        // 2.调用service查询
        Brand brand = service.selectById(Integer.parseInt(id));

        // 存到request中
        request.setAttribute("brand", brand);

        // 转发到update.jsp中
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

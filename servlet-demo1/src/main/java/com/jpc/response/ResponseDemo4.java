package com.jpc.response;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.读取文件
        FileInputStream fis = new FileInputStream("C://Users//jpc//Desktop//OldDesktop//5.jpg");

        // 2.获取response字节输出流
        ServletOutputStream os = response.getOutputStream();

        // 3.完成流的copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while((len = fis.read(buff)) != -1) {
//            os.write(buff, 0, len);
//        }
        IOUtils.copy(fis, os);

        fis.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

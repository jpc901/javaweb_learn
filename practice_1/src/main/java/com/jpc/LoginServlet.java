package com.jpc;

import com.jpc.mapper.UserMapper;
import com.jpc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
        // 2.调用Mybatis完成查询
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 调用方法
        User user = userMapper.select(username, password);

        sqlSession.close();

        // 获取对应的字符输出流
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter writer = resp.getWriter();
        // 3.判断user是否存在
        if(user != null){
            //登录成功
            writer.write("登录成功");
        }else{
            //登录失败
            writer.write("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }
}

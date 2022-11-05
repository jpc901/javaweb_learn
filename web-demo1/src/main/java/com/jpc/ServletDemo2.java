package com.jpc;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo2")
public class ServletDemo2 implements Servlet {


    /**
     * 初始化方法
     * 1. 调用时机：默认情况下,Servlet被第一次访问的时候调用
     *          loadOnStartup: 默认是启动时创建，可以设置为1（提前创建）
     * 2. 调用次数：1
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init~~~");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务
     * 1. 调用时机：每次访问时调用
     * 2. 调用次数：多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello ~~");
    }

    /**
     * 销毁方法：
     * 1. 调用时机：内存释放的时候或者服务器关闭的时候，Servlet对象会被销毁
     * 2. 调用次数：1次
     */
    @Override
    public void destroy() {

    }

    @Override
    public String getServletInfo() {
        return null;
    }


}

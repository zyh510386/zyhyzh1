package com.ysd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet",urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String agestr = request.getParameter("age");
        int age = 0;
        try {
            age = Integer.parseInt(agestr);
        } catch (NumberFormatException e) {
           System.out.println("年龄格式转换错误");
        }
        System.out.println("haha hehe");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.printf("hello %s 你的年龄是%d岁",name,age);
        out.append("<table border=1>"+
                "<tr><td>name</td><td>age</td></tr>"+
                "<tr><td>"+name+"</td><td>"+age+"</td>"+
                "</table>");

    }
}

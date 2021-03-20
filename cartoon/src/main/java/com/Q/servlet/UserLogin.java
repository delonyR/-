package com.Q.servlet;

import com.Q.pojo.User;
import com.Q.service.user.UserServiceImpl;
import com.Q.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("");
        String email = req.getParameter("email");
        String psw = (String)req.getAttribute("psw");
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(email, psw);
        if(user == null){
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            System.out.println("2");
        }else {
                req.getSession().setAttribute(Constant.USER_SESSION,user);
                resp.sendRedirect("/Q/jsp/frame.jsp");
                System.out.println("1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

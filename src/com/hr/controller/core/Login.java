package com.hr.controller.core;

import com.hr.entity.Users;
import com.hr.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = new Users().setUsername(req.getParameter("username")).setPassword(req.getParameter("password"));
        try {
            UsersService.getInstance().login(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/" + user.getRole_name() + "/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

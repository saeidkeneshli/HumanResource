package com.hr.controller.core;

import com.hr.common.AccessError;
import com.hr.entity.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {

            String targetURL = request.getRequestURI().split("/")[1];
            if (request.getSession().getAttribute("user") == null)
                response.sendRedirect("/index.jsp");
            else {
                if (((Users) request.getSession().getAttribute("user")).getRole_name().equals(targetURL))
                    filterChain.doFilter(servletRequest, servletResponse);
                else {
                    System.out.println(((Users) request.getSession().getAttribute("user")).getUsername() + " IP " + request.getRemoteAddr() + " TARGET " + targetURL);
                    throw new AccessError();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/index.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}

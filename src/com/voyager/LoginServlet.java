package com.voyager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if (UserDao.isAvailable(username, password)) {
			request.getSession().setAttribute("user", username);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			response.getWriter().write("用户名或密码不正确，登录失败！\n三秒后重新登录");
//			response.sendRedirect(request.getContextPath()+"/login.jsp");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

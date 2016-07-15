package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Administrator;
import com.entity.User;
import com.test.LibConnection;
import com.util.LogInCheck;

/**
 * 检查用户名密码是否正确，并返回用户身份：admin/老师/学生
 * @author unkown (modified by ysj)
 *
 */
public class LogInServlet extends HttpServlet{
HttpSession session = null;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");// 防止中文乱码问题
		session = request.getSession();
		int username = Integer.parseInt(request.getParameter("username"));
		String password = request.getParameter("password");
		
//		String identity = request.getParameter("identity");//这个是用来判断是管理员还是普通会员的
		String loginresult = LogInCheck.isLogin(username, password);//返回admin或者老师/学生，字符串类型
		session.setAttribute("loginresult", loginresult);
		System.out.println(loginresult);
		
		if(loginresult.contains("admin")){
			request.getRequestDispatcher("/admin/index.jsp").forward(request,
					response);
			session.setAttribute("admin", new Administrator(username));
			System.out.println("跳转到Admin界面");
		}
		else if(loginresult.equals("学生")){
			request.getRequestDispatcher("/vip/index.jsp").forward(request,
					response);
			session.setAttribute("user", new User(username));
			session.setAttribute("vip_identity", "stu");
			System.out.println("跳转到User界面");
		}
		else if(loginresult.equals("老师")){
			request.getRequestDispatcher("/vip/index.jsp").forward(request,
					response);
			session.setAttribute("user", new User(username));
			session.setAttribute("vip_identity", "tea");
			System.out.println("跳转到User界面");
		}
		else{
			//用户名或密码错误
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
			session.setAttribute("res", "用户名或密码错误");
		}
		
		
		
		/**
		if (loginresult.equals("VALIDUSER") && identity.equals("admin")) {
			request.getRequestDispatcher("/admin/index.jsp").forward(request,
					response);
			session.setAttribute("admin", new Administrator(username));
			System.out.println("跳转到Admin界面");
		} else if (loginresult.equals("VALIDUSER") && identity.equals("user")) {
			request.getRequestDispatcher("/vip/index.jsp").forward(request,
					response);
			session.setAttribute("user", new User(Integer.parseInt(username)));
			//session.setAttribute("vip_identity", "teacher");
			System.out.println("跳转到User界面");
		} else {
			request.getRequestDispatcher("LogResult.jsp").forward(request,
					response);
		}
		*/
	}

}

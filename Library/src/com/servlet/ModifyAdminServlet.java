package com.servlet;


import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Administrator;
import com.entity.User;

public class ModifyAdminServlet extends HttpServlet{
	HttpSession session = null;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Administrator admin = new Administrator(111);
		
		request.setCharacterEncoding("utf-8");//防止中文乱码问题
		session = request.getSession();
		

		String name=  request.getParameter("username");
		String sex =  request.getParameter("sex");
		int id =  Integer.parseInt(request.getParameter("id"));
		String pwd =  request.getParameter("password");
		
		System.out.println(name);
		
		if(name!=""&&sex!=""&&pwd!=""){
			admin.updateadmin(name, pwd, sex,id);
		}
//		if(name!=null){
//			user.updateUsername(name);
//		}
//		if(sex!=null){
//			user.updateUserSex(sex);
//		}
//		if(tel!=null){
//			user.updateUserTel(tel);
//		}
//		if(stu_ID!=null){
//			user.updateUserStuID(Integer.parseInt(stu_ID));
//		}
		

		request.getRequestDispatcher("/admin/information.jsp").forward(request, response);
	
	}

	
	
}
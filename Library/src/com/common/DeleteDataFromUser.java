package com.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDataFromUser extends  HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        //设置生成文件的类型和编码格式
        response.setContentType("text/json;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");

        //处理接受到的参数
        String str = request.getParameter("cardID");
        int cardID = Integer.valueOf(str).intValue();
        System.out.println(cardID);

        //从User删除相应的记录
        UserDAO u = new UserDAO();

        try {
			u.delete(cardID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

		doPost(request,response);

	}
}

package com.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDataFromCategory extends  HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        //设置生成文件的类型和编码格式
        response.setContentType("text/json;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");

        //处理接受到的参数
        String str = request.getParameter("index");
        int index = Integer.valueOf(str).intValue();
        System.out.println(index);

        //从category删除相应的记录
        CategoryDAO cg = new CategoryDAO();
        
        try {
			cg.delete(index);
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

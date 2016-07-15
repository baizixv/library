package com.common;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateDataFromCategory extends  HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        //设置生成文件的类型和编码格式
        response.setContentType("text/json;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");

        //处理接受到的参数
        Category cg = new Category();
        
        String str = request.getParameter("index");
        int index = Integer.valueOf(str).intValue();
        System.out.println(index);
        cg.setIndex(index);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date pressdate;
        str = request.getParameter("pressdate");
        System.out.println(str);
		try {
			//pressdate = sdf.parse(str.toString());
			pressdate = sdf.parse(str);//两句同样的效果
			System.out.println(pressdate);
	        cg.setPressdate(pressdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        String bookname = request.getParameter("bookname");
        System.out.println(bookname);
        cg.setBookname(bookname);
        
        String author = request.getParameter("author");
        System.out.println(author);
        cg.setAuthor(author);
        
        String press = request.getParameter("press");
        System.out.println(press);
        cg.setPress(press);
        
        str = request.getParameter("price");
        double price = Double.valueOf(str).doubleValue();
        System.out.println(price);
        cg.setPrice(price);
        
        //从category更新相应的记录
        CategoryDAO cgd = new CategoryDAO();
        try {
			cgd.update(cg);
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

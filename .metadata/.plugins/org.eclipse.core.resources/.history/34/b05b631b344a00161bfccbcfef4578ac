package com.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

public class SelectDataFromCategory extends  HttpServlet{



	public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{



        //设置生成文件的类型和编码格式
        response.setContentType("text/json;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
        
        PrintWriter out = response.getWriter();
        JSONArray output = new JSONArray();

        //获得从category表中查询得到的结果集ResultSet
        CategoryDAO cg = new CategoryDAO();
        ResultSet preoutput = null;
        String sql = "SELECT `index`,bookname,author,press,pressdate,price FROM category";
        try {
			preoutput = cg.select(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //将结果集ResultSet转化成JsonArray
        ResultSetToJson rstj = new ResultSetToJson();

        try {
			output = rstj.transJson(preoutput);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        out.println(output);
        out.flush();
        out.close();

        }

	public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

		doPost(request,response);

	}
}

package com.common;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateDataFromUser extends  HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        //设置生成文件的类型和编码格式
        response.setContentType("text/json;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");

        //处理接受到的参数
        User u = new User();

        String str = request.getParameter("cardID");
        int cardID = Integer.valueOf(str).intValue();
        System.out.println(cardID);
        u.setCardID(cardID);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date per_of_val;
        str = request.getParameter("per_of_val");
        System.out.println(str);
		try {
			//per_of_val = sdf.parse(str.toString());
			per_of_val = sdf.parse(str);//两句同样的效果
			System.out.println(per_of_val);
	        u.setPer_of_val(per_of_val);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


        String name = request.getParameter("name");
        System.out.println(name);
        u.setName(name);

        String sex = request.getParameter("sex");
        System.out.println(sex);
        u.setSex(sex);

        String typeOfCard = request.getParameter("typeOfCard");
        System.out.println(typeOfCard);
        u.setTypeOfCard(typeOfCard);

        str = request.getParameter("money_Reserved");
        double money_Reserved = Double.valueOf(str).doubleValue();
        System.out.println(money_Reserved);
        u.setMoney_Reserved(money_Reserved);

        //从user更新相应的记录
        UserDAO ud = new UserDAO();
        try {
			ud.update(u);
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

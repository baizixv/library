package com.util;

import java.sql.*;

import com.test.LibConnection;

public class LogInCheck {

	static Connection connection = LibConnection.getConnection();

	public static String isLogin(int cardID, String password) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (cardID==222) {
			if (password.equals(123)){
				return "admin01";
			}
			else{
				return "用户名或密码错误";
			}
			/*以下是正确的判别步骤
			ResultSet result = null;
			try {
				result = statement.executeQuery("select password from administrator where username ='" + cardID
						+ "' and password ='" + password + "'");
				System.out.println("cardID:" + cardID + "password" + password);
				if (result.next() == false)
					return "用户名或密码错误";
				else
					return "VALIDUSER";
			} catch (SQLException e) {
				return e.getMessage();
			}
			*/
		}
		
		else if(cardID==111){
			if(password.equals("342")){
				return "admin02";
			}
			else{
				return "用户名或密码错误";
			}
		}
		
		else{
			ResultSet result = null;
			try {
				result = statement.executeQuery(
						"select TypeOfCard from user where cardID ='" + cardID + "' and password ='" + password + "'");
				System.out.println("cardID:" + cardID + "password" + password);
				if (result.next() == false)
					return "用户名或密码错误";
				else
					return result.getString(1);//返回的是"老师"或者"学生"
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
		
		
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(isLogin( 123, "123"));
	}

}

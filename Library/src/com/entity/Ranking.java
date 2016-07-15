package com.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.LibConnection;

/**
 * 
 * @author ZM
 *
 */

public class Ranking {

	Statement sta= null;
	public Ranking(){
		try {
			sta= LibConnection.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有评论!!!!!!!!!!
	 * @return rs 结果集
	 */
	public ResultSet OrderRemark(){
		//评论打分排行
		String sql="SELECT com_date,com_index,bookname,`name`,remark,score FROM `comment`,category,`user` WHERE comment_stu=cardID AND `index`=com_index ORDER BY score DESC";
		ResultSet rs=null;
		try {
			rs = sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet OrderBook(){
		//图书借阅次数排行
		String sql="SELECT `index`,bookname,author,press,COUNT(`index`) AS num FROM borrow,book,category WHERE `index`=cateindex AND bo_bookid=bookid GROUP BY `index` ORDER BY num DESC";
		ResultSet rs=null;
		try {
			rs = sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet OrderUser(){
		//用户借阅次数排行
		String sql="SELECT bo_cardID,`name`,COUNT(bo_cardID) AS num FROM borrow,`user` WHERE bo_cardID=cardID GROUP BY bo_cardID ORDER BY num DESC";
		ResultSet rs=null;
		try {
			rs = sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet OrderSearch(){
		//根据搜索次数排行
		ResultSet rs=null;
		return rs;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ranking rank=new Ranking();
		
		ResultSet bookorder=rank.OrderBook();
		System.out.println("根据借阅次数对图书进行排行");
		try {
			while(bookorder.next()){
				String bookname=bookorder.getString("bookname");
				String author=bookorder.getString("author");
				String press=bookorder.getString("press");
				String index=bookorder.getString("index");
				String num=bookorder.getString("num");
				System.out.print(index+" "+bookname+" "+author+" "+press+" "+num);
				System.out.println("");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		ResultSet userorder=rank.OrderBook();
//		System.out.println("根据借阅刺水对会员排行");
//		try {
//			while(userorder.next()){
//				String id=userorder.getString("bookname");
//				String name=userorder.getString("index");
//				String num=userorder.getString("author");
//				
//				System.out.print(id+" "+name+" "+num);
//				System.out.println("");
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}

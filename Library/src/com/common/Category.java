package com.common;

import java.util.Date;

public class Category {

	private int index; //定义索引号

	private String bookname; //定义书名

	private String author; //定义书的作者

	private String press; //定义书的出版社

	private Date pressdate; //定义书的入库日期

	private double price; //定义书的价格

	/**
	 * 定义setter与getter方法
	 */
	public void setIndex(int index){
		this.index = index;
	}

	public int getIndex(){
		return index;
	}

	public void setBookname(String bookname){
		this.bookname = bookname;
	}

	public String getBookname(){
		return bookname;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setPress(String press){
		this.press = press;
	}

	public String getPress(){
		return press;
	}

	public void setPressdate(Date pressdate){
		this.pressdate = pressdate;
	}

	public Date getPressdate(){
		return pressdate;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}




}

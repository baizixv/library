package com.common;

public class Book {

	private String bookid;

    private int cateindex;

    public void setBookid(String bookid){
        this.bookid = bookid;
    }

    public String getBookid(){
        return bookid;
    }

    public void setCateindex(int cateindex){
        this.cateindex = cateindex;
    }

    public int getCateindex(){
        return cateindex;
    }
}

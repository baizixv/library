package com.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.LibConnection;

public class CategoryDAO {

    /**
    * 取得一个数据库的连接
    */
    public Connection getConnection(){
            Connection conn = null;
            conn =  LibConnection.getConnection();
            return conn ;
    }
    
	private void extracted(Statement stmt) throws SQLException {
		{
        	stmt.close();
        }
	}
    /**
     * 根据传入的对象向数据库插入一条记录
     * @throws SQLException
     */
    public void update(Category category)throws Exception {
        Statement stmt = null;
        System.out.println("开始更新记录！！！");
//        String sql0 = "SELECT pressdate FROM category WHERE `index` = 121352632";
//        ResultSet rs=this.select(sql0);
//        String str = rs.toString();
//        System.out.println(str);
       
        String sql = "UPDATE category SET `index`= '"+ category.getIndex() 
        		     +" ' ,bookname = ' " + category.getBookname() 
        		     +" ' ,author = '" + category.getAuthor()
        		     +" ' ,press = '" + category.getPress()
        		     +" ' ,pressdate = '2016-05-27 00.01.20" //+ category.getPressdate()
        		     +" ' ,price = '" + category.getPrice() 
        		     +"' WHERE `index` = '" + category.getIndex()+"'";
        
        stmt = LibConnection.getConnection().createStatement();
        stmt.executeUpdate(sql);
        System.out.println("成功更新一条记录！");

    }


    /**
     * 根据传入的对象向数据库插入一条记录
     * @throws SQLException
     */
    public void insert(Category category)throws Exception {
        Statement stmt = null;
        System.out.println("开始插入记录！！！");

        String sql = "INSERT INTO category(`index`,pressdate,bookname,author,press,price,booktype,edition,presstime,pages) VALUES('"
        			+ category.getIndex() +"','2016-05-27 00.01.20','"
        			//+ category.getPressdate()
        			+category.getBookname() +"','"
        			+ category.getAuthor() +"','" 
        			+ category.getPress() +"','"
        			+ category.getPrice() +"','science','2','2','100"
        			+"')";
        
        stmt = LibConnection.getConnection().createStatement();
        stmt.executeUpdate(sql);
        System.out.println("成功插入一条记录！");

    }

    /**
     * 根据传入的对象删除数据库中对应的这条记录
     * @throws SQLException
     */
    public void delete(int index)throws Exception {
        // Connection conn = null ;
        Statement stmt = null;
        
        String sql = "DELETE FROM category WHERE `index` =" + index;
        
        System.out.println("开始删除记录！！！");
        
//        stmt = LibConnection.getConnection().createStatement();
//        stmt.executeUpdate(sql);
//        System.out.println("删除成功！");
        System.out.println("不可删除记录！！！因为有外键关联！！！");
        if (stmt != null)
			extracted(stmt);  

    }


    
    /**
     * 根据传入的SQL语句返回ResultSet
     * @throws SQLException
     */

    public ResultSet select(String sql) throws SQLException {
        // Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        System.out.println("开始查询记录！！！");

        // conn = getConnection();

        stmt = LibConnection.getConnection().createStatement();
        rs = stmt.executeQuery(sql);       
        return rs;
    }

}

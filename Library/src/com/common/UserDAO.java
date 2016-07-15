package com.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.LibConnection;

public class UserDAO {

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
    public void update(User u)throws Exception {
        Statement stmt = null;
        System.out.println("开始更新记录！！！");
//        String sql0 = "SELECT per_of_val FROM user WHERE `cardID` = 121352632";
//        ResultSet rs=this.select(sql0);
//        String str = rs.toString();
//        System.out.println(str);

        String sql = "UPDATE user SET `cardID`= '"+ u.getCardID()
        		     +" ' ,name = ' " + u.getName()
        		     +" ' ,sex = '" + u.getSex()
        		     +" ' ,typeOfCard = '" + u.getTypeOfCard()
        		     +" ' ,per_of_val = '2016-05-27 00.01.20" //+ user.getper_of_val()
        		     +" ' ,money_Reserved = '" + u.getMoney_Reserved()
        		     +"' WHERE `cardID` = '" + u.getCardID()+"'";

        stmt = LibConnection.getConnection().createStatement();
        stmt.executeUpdate(sql);
        System.out.println("成功更新一条记录！");

    }


    /**
     * 根据传入的对象向数据库插入一条记录
     * @throws SQLException
     */
    public void insert(User user)throws Exception {
        Statement stmt = null;
        System.out.println("开始插入记录！！！");

        String sql = "INSERT INTO user(`cardID`,per_of_val,name,sex,TypeOfCard,money_Reserved,ID) VALUES('"
        			+ user.getCardID() +"','2016-05-27 00.01.20','"
        			//+ user.getper_of_val()
        			+user.getName() +"','"
        			+ user.getSex() +"','"
        			+ user.getTypeOfCard() +"','"
        			+ user.getMoney_Reserved() +"','454545"
        			+"')";

        stmt = LibConnection.getConnection().createStatement();
        stmt.executeUpdate(sql);
        System.out.println("成功插入一条记录！");

    }

    /**
     * 根据传入的对象删除数据库中对应的这条记录
     * @throws SQLException
     */
    public void delete(int cardID)throws Exception {
        // Connection conn = null ;
        Statement stmt = null;

        String sql = "DELETE FROM user WHERE `cardID` =" + cardID;

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

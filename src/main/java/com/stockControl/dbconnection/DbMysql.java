package com.stockControl.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbMysql {
    private String password="mysql";
    private String url="jdbc:mysql://localhost/test";
    private String user= "root";

    
    public Connection initConnection() throws SQLException,RuntimeException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,this.user,this.password);
    }

    public void setPassword(String password){
        this.password= password;
    }
    public void setUrlConnection(String url){
        this.url=url;
    }
    public void setUser(String user){
        this.user=user;
    }
}

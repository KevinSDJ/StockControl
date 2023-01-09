package com.stockControl.dbconnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DbMysql {
    private String password="mysql";
    private String url="jdbc:mysql://localhost/test";
    private String user= "root";
    private DataSource dataSource;
    private static DbMysql instance= new DbMysql();
    
    private DbMysql(){
        ComboPooledDataSource poolDataSource= new ComboPooledDataSource();
        poolDataSource.setJdbcUrl(url);
        poolDataSource.setUser(user);
        poolDataSource.setPassword(password);
        this.dataSource= poolDataSource;
    }
    public static Connection getConnection() throws SQLException{
        return instance.exposeConnection();
    }
    public Connection exposeConnection() throws SQLException{
        return this.dataSource.getConnection();
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

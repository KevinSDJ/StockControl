package com.stockControl.dbconnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class DbMysql {
    // Datasource , conjunto de configuracion de conexiones a jdbc
    // c3p0 permite la administracion optima de conexiones a la base de datos sin
    // desperdiciar muchos recursos.
    // en esta clase e aplicado el patron singleton para evitar la replicacion de instancias
    // por cada vez que se solicita esta clase ahorrando espacio en memoria.
    private String password="mysql";
    private String url="jdbc:mysql://localhost/test";
    private String user= "root";
    private final DataSource dataSource;
    private static final DbMysql instance= new DbMysql();
    
    private DbMysql(){
        ComboPooledDataSource poolDataSource= new ComboPooledDataSource();
        try {
            poolDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        } catch (PropertyVetoException ex) {
            Logger.getLogger(DbMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        poolDataSource.setMaxPoolSize(10); // establece la cantidad maxima de conexiones
                                                     // en caso de llegar a el maximo espera que se libere alguna conexion
                                                     //para realizar la siguiente conexion en espera.
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

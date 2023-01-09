package com.stockControl.controller;

import com.stockControl.dbconnection.DbMysql;
import java.io.Serializable;
import java.util.List;
import com.stockControl.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductsController implements Serializable{
    private static final long serialVersionUID= 1L;
    private static DbMysql dbconnInst= new DbMysql();

    public static List<Product> listAllProducts(){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rst=null;
        List<Product> result= new ArrayList<>();
        try {
            conn=dbconnInst.initConnection();
            st= conn.prepareStatement("select * from Products");
            st.execute();
            rst=st.getResultSet();
            while(rst.next()){
                Product item= new Product();
                item.setCode(rst.getString("code"));
                item.setName(rst.getString("name"));
                item.setDescription(rst.getString("description"));
                item.setStock(rst.getInt("stock"));
                
                result.add(item);
            }
            return result;
        } catch (SQLException | RuntimeException | ClassNotFoundException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    public static void deleteOneProduct(String code)throws ClassNotFoundException, SQLException,Exception{
        Connection conn=null;
        PreparedStatement st=null;
        try{
            conn= dbconnInst.initConnection();
            st= conn.prepareStatement("DELETE FROM Products WHERE code = ?");
            st.setString(1,code);
            st.execute();
            st.close();
            conn.close();
        } catch (SQLException ex ) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex);
        } catch( RuntimeException ex ){
            throw new RuntimeException(ex);
        }

    }

    public static void saveOneProduct(Product product) throws ClassNotFoundException, SQLException,Exception{
        Connection conn=null;
        PreparedStatement st=null;
        try {
            conn=dbconnInst.initConnection();
            st= conn.prepareStatement("INSERT INTO Products (name,description,stock)"
            +"VALUES ( ?,?,? )");
            st.setString(1,product.getName());
            st.setString(2,product.getDescription());
            st.setInt(3, product.getStock());
            st.execute();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex);
        }catch(RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    public static void editOneProduct(Product product) throws ClassNotFoundException, SQLException,Exception{
        Connection conn=null;
        PreparedStatement st=null;
        try {
            conn=dbconnInst.initConnection();
            st= conn.prepareStatement("UPDATE Products SET name = ?,description= ?,stock =? "
            +"WHERE code = ?");
            st.setString(1,product.getName());
            st.setString(2,product.getDescription());
            st.setInt(3, product.getStock());
            st.setString(4,product.getCode());
            st.execute();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex);
        }catch(RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    public static Product findOneProduct(String code){
        return null;
    }
    
}

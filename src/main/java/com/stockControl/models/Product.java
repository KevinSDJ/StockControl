package com.stockControl.models;

import java.io.Serializable;

public class Product implements Serializable {
    
    /* id is UUID code */
    private String code;
    private String name;
    private String description;
    private int stock;

    public Product(){}
    
    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getStock(){
        return stock;
    }
    /* setters */
    public void setCode(String code){
        this.code=code;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDescription(String description){
        this.description= description;
    }
    public void setStock(int stock){
        this.stock=stock;
    }

    @Override
    public String toString() {
        return "Product [code=" + code + ", name=" + name + ", description=" + description + ", stock=" + stock + "]";
    }
}

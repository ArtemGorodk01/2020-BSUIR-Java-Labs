/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gorod
 */
public class Car {
    private Long id;
    private String model;
    private int price;  
    
    public Car(Long id, String model, Integer price)
    {
        this.id = id;
        this.model = model;
        this.price = price;
    }
    
    public Long getId()
    { 
        return id;
    }  
    
    public void setId(Long id)
    {  
        this.id = id; 
    } 
    
    public String getModel()
    {  
        return model; 
    } 
    
    public void setModel(String model)
    { 
        this.model = model;
    } 
    
    public int getPrice()
    {  
        return price; 
    }  
    
    public void setPrice(int price)
    {  
        this.price = price; 
    }
}

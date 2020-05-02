/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perst;

import org.hibernate.annotations.GenericGenerator;
import java.util.*;
import java.io.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.List; 
import org.hibernate.Session;

/**
 *
 * @author gorod
 */
public class Stud implements Serializable{
    private String fio;
    private int age;
    
    public Stud() {}   
    
    public Stud(String name, int g) 
    {   
        this.fio = name;  
        this.age = g;  
    }    
    
    public void setFio(String name)
    {      
        this.fio = name;  
    }
    
    public int getAge()
    {  
        return age;  
    }   

    public String getFio() 
    {      
        return fio;   
    }  
    
    public void setAge(int g) 
    {    
        this.age = g;  
    }
}

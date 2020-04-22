package com; 
public class Employee
{   
    private String name;
    private String department; 
    private String address;  
    private double wage;
 
    public Employee (String name, String department,String address,double wage)
    {    
        this.name = name; 
        this.department = department;  
        this.address = address;
        this.wage = wage;  
    } 
    
    public String getName() 
    {     
        return name; 
    } 
 
    public void setName(String name)
    {    
        this.name = name;  
    } 
 
    public String getDepartment()
    {    
        return department; 
    } 
 
    public void setDepartment(String department)
    {      
        this.department = department; 
    } 
 
    public String getAddress()
    {   
        return address;  
    } 
 
    public void setAge(String address)
    {     
        this.address = address; 
    } 
 
    public double getWage()
    {    
        return wage; 
    } 
 
    public void setWage(double wage) 
    {      
        this.wage = wage; 
    } 
}
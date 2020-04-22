package com; 
 
import javax.ejb.Stateless;
import java.util.*; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean
@RequestScoped 
public class mancomp 
{
   private String name;
   private String department; 
   private String address;    
   private Double wage;
   
   private String searchName;
   private ArrayList<Employee> searchedEmployees = new ArrayList<Employee>();
   
   private static ArrayList<Employee> employees = new ArrayList<Employee>(Arrays.asList(      
           new Employee("ivanov", "Marketing", "Minsk", 10), 
           new Employee("petrov", "Marketing", "Moscow", 12),   
           new Employee("sidorov", "Professor", "Berlin", 10),   
           new Employee("mishin", "Smith", "Minsk", 11),   
           new Employee("vasin", "Programmer", "Drezden", 14)  
        )); ;  
   
   public mancomp()
   {
   };
   
   public ArrayList<Employee> getEmployees()
   {
       return employees;
   }
   
    public void setSearchedEmployees() 
    {
        for(Employee employee : employees)
        {
            if(employee.getName().equalsIgnoreCase(searchName))
            {
                searchedEmployees.add(employee);
            }
        }
    } 
 
    public ArrayList<Employee> getSearchedEmployees()
    {
        return searchedEmployees;
    }
    
    public String addEmployee() 
    {     
        Employee std = new Employee(name,department,address,wage);   
        employees.add(std);    
        return null; 
    } 
 
    public String deleteEmployee(Employee em)
    {    
        employees.remove(em);  
        return null;  
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
 
    public void setAddress(String address)
    {    
        this.address = address;  
    } 
    
    public Double getWage()
    {
        return wage;
    }
    
    public void setWage(Double wage)
    {
        this.wage = wage;
    }
    
    public String getSearchName()
    {
        return searchName;
    }
    
    public void setSearchName(String searchName)
    {
        this.searchName = searchName;
    }
} 
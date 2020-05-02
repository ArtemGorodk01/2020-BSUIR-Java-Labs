/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author gorod
 */
public class Student {
     private String fio; 
     private String department; 
     private String group;    
     
     public Student (String fio, String department,String group){ 
         this.fio = fio;
         this.department = department; 
         this.group = group;  
     } 
     
     public String getFio() {  
         return fio;  
     } 
     
     public void setFio(String name) {  
         this.fio = fio;  
     } 
     
     public String getDepartment() {  
         return department; 
     } 
     
     public void setDepartment(String department) {
         this.department = department;  
     } 
    
     public String getGroup() {   
         return group;  
     } 
     
     public void setGroup(String group) {   
         this.group = group;  
     }
}

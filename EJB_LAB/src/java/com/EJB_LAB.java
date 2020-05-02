/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import javax.ejb.Stateless;
import java.util.*; 
import java.io.Serializable;

/**
 *
 * @author gorod
 */
@Stateless
public class EJB_LAB implements EJB_LABRemote, Serializable {
    private static final long serialVersionUID = 1L; 
    
    private static final ArrayList<Student> students  
            = new ArrayList<Student>(Arrays.asList( 
                    new Student("ivanov", "Marketing", "10"), 
                    new Student("petrov", "Marketing", "10"),   
                    new Student("sidorov", "Professor", "12"), 
                    new Student("mishin", "Smith", "12"),  
                    new Student("vasin", "Programmer", "14")  
            ));
    
    @Override
    public String getStudInfo(String fio) {
        String rez="???";  
        for (Iterator<Student> it = students.iterator(); it.hasNext();) {   
            Student st=it.next();    
            String name=st.getFio();  
            if(name.equals(fio))  
            {         
                rez=st.getDepartment()+"  "+st.getGroup();    
                break;    
            }     
        } 
 
        return rez; 
    }

    @Override
    public Boolean addStudent(String fio, String departament, String group) {
        if(fio == null ||
           departament == null ||
           group == null)
        {
            return false;
        }
        
        Student newStudent = new Student(fio, departament, group);
        students.add(newStudent);
        return true;
    }

    @Override
    public Boolean deleteStudent(String fio) {
        if(fio == null)
        {
            return false;
        }
        
        Student st = null;
        Boolean hasFound = false;
         for (Student student : students) {
            String name=student.getFio();  
            if(name.equals(fio))  
            {         
                hasFound = true;
                st = student;
                break;  
            }     
        }
        
        if(hasFound)
        {
            students.remove(st);
            return true;
        }
        
        return false;
    }

    @Override
    public ArrayList<String> getStudentsNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (Iterator<Student> it = students.iterator(); it.hasNext();) {   
            names.add(it.next().getFio());
        }
        
        return names; 
    }

    @Override
    public ArrayList<String> getStudentsNamesByDepartament(String departament) {
        ArrayList<String> names = new ArrayList<String>();
        for (Student student : students) {   
            if(student.getDepartment().equalsIgnoreCase(departament))
            {
                names.add(student.getFio());
            }
        }
        
        return names; 
    }

    @Override
    public Integer getStudentsCountByGroup(String group) {
        Integer studentsCount = 0;
         for (Student student : students) {   
            if(student.getGroup().equalsIgnoreCase(group))
            {
                studentsCount++;
            }
        }
        
        return studentsCount;
    }
}

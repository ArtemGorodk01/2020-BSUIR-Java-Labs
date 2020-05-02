/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author gorod
 */
@Remote
public interface EJB_LABRemote {

    String getStudInfo(String fio);

    Boolean addStudent(String fio, String departament, String group);

    Boolean deleteStudent(String fio);

    ArrayList<String> getStudentsNames();

    ArrayList<String> getStudentsNamesByDepartament(String departament);

    Integer getStudentsCountByGroup(String group);
    
}

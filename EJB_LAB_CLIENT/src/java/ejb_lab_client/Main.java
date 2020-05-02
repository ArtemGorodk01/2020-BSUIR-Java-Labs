/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb_lab_client;

import com.EJB_LABRemote;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.EJB;

/**
 *
 * @author gorod
 */
public class Main extends Frame implements ActionListener {

    @EJB
    private static EJB_LABRemote eJB_LAB;

    private Button addStudentButton = new Button("Add student");
    private TextField newFioTextField = new TextField();
    private TextField newDepartamentTextField = new TextField();
    private TextField newGroupTextField = new TextField();
    private List studentsList = new List();
    private Button deleteStudentButton = new Button("Delete selected");
    private TextField searchGroupTextField = new TextField();
    private TextField studentsCountTextField = new TextField();
    private Button showStudentsCountButton = new Button("Show students count");
    private TextField searchDepartamentTextField = new TextField();
    private Button showDepartamentStudentsButton = new Button("Show students");
    private List departamentStudentsList = new List();
    private Button exitButton = new Button("Exit");
    private Label fioLabel = new Label("FIO");
    private Label newDepartamentLabel = new Label("Departament");
    private Label newGroupLabel = new Label("Group");
    private Label statisticLabel = new Label("Statistics");
    private Label searchGroupLabel = new Label("Group");
    private Label searchDepartamentLabel = new Label("Departament");
    
    public Main()
    {
        super("lab6");
        setLayout(null);
        setSize(1000, 1000);
        add(addStudentButton);
        add(newFioTextField);
        add(newDepartamentTextField);
        add(newGroupTextField);
        add(studentsList);
        add(deleteStudentButton);
        add(searchGroupTextField);
        add(studentsCountTextField);
        add(showStudentsCountButton);
        add(searchDepartamentTextField);
        add(showDepartamentStudentsButton);
        add(departamentStudentsList);
        add(exitButton);
        add(fioLabel);
        add(newDepartamentLabel);
        add(newGroupLabel);
        add(statisticLabel);
        add(searchGroupLabel);
        add(searchDepartamentLabel);
        
        studentsList.setBounds(50, 50, 200, 500);
        fioLabel.setBounds(50, 580, 50, 20);
        newFioTextField.setBounds(50, 600, 200, 20);
        newDepartamentLabel.setBounds(50, 630, 200, 20);
        newDepartamentTextField.setBounds(50, 650, 200, 20);
        newGroupLabel.setBounds(50, 680, 50, 20);
        newGroupTextField.setBounds(50, 700, 200, 20);
        addStudentButton.setBounds(50, 750, 100, 50);
        exitButton.setBounds(50, 900, 100, 50);
        deleteStudentButton.setBounds(270, 50, 100, 50);
        statisticLabel.setBounds(500,50,200,20);
        searchGroupLabel.setBounds(500, 80, 200, 20);
        searchGroupTextField.setBounds(500, 100, 200, 20);
        showStudentsCountButton.setBounds(500, 130, 130, 50);
        studentsCountTextField.setBounds(650, 130, 50, 50);
        searchDepartamentTextField.setBounds(500, 300, 100, 30);
        showDepartamentStudentsButton.setBounds(605, 300, 95, 30);
        departamentStudentsList.setBounds(500, 350, 200, 500);
        searchDepartamentLabel.setBounds(500, 280, 200, 20);
        
        exitButton.addActionListener(this);
        addStudentButton.addActionListener(this);
        deleteStudentButton.addActionListener(this);
        showStudentsCountButton.addActionListener(this);
        showDepartamentStudentsButton.addActionListener(this);
        
        LoadStudents();
        
        this.show();
        this.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exitButton)
        {
             System.exit(0);
        }
        
        if(ae.getSource() == addStudentButton)
        {
            String fio = newFioTextField.getText();
            String departament = newDepartamentTextField.getText();
            String group = newGroupTextField.getText();
            eJB_LAB.addStudent(fio, departament, group);
            LoadStudents();
        }
        
        if(ae.getSource() == deleteStudentButton)
        {
            String selectedName = studentsList.getSelectedItem();
            if(selectedName != null)
            {
                eJB_LAB.deleteStudent(selectedName);
                LoadStudents();
            }
        }
        
        if(ae.getSource() == showStudentsCountButton)
        {
            String group = searchGroupTextField.getText();
            Integer count = eJB_LAB.getStudentsCountByGroup(group);
            studentsCountTextField.setText(count.toString());
        }
        
        if(ae.getSource() == showDepartamentStudentsButton)
        {
            String departament = searchDepartamentTextField.getText();
            ArrayList<String> students = eJB_LAB.getStudentsNamesByDepartament(departament);
            departamentStudentsList.removeAll();
            for (Iterator<String> it = students.iterator(); it.hasNext();) {   
                departamentStudentsList.add(it.next());
            } 
        }
    }
    
    private void LoadStudents()
    {
        ArrayList<String> students = eJB_LAB.getStudentsNames();
        studentsList.removeAll();
        for (Iterator<String> it = students.iterator(); it.hasNext();) {   
            studentsList.add(it.next());
        } 
    }
}

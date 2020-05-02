/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberlabvis;

import org.hibernate.annotations.GenericGenerator;
import java.util.*;
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
import perst.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author gorod
 */
public class HiberLabVis extends Frame implements ActionListener 
{
    private static SessionFactory sessionFactory; 
    static Session session = null;   
    static  Connection connection = null; 
    static  Statement statement = null;  
    static  ResultSet rs = null;   
    private static String dbURL = "jdbc:derby://localhost:1527/Lab8;user=artem;password=artem";  
    private static Connection conn = null;  
    static boolean bcon=false;    
    Button bex=new Button("Выход"); 
    Button connect=new Button("Соединить");
    Label lfio=new Label("Имя");        
    Label lage=new Label("Возраст");
    static TextField tfio = new TextField();  
    static TextField tage = new TextField(); 
    Label lstat=new Label("Статус"); 
    static TextField tstat = new TextField(); 
    static Button addNewButton = new Button("Добавить");
    static java.awt.List studentsList = new java.awt.List();
    static Button deleteButton = new Button("Удалить");
    static Button searchButton = new Button("Найти");
    static TextField searchTextField = new TextField();
    static java.awt.Label searchResult = new java.awt.Label();
    
    public  HiberLabVis() 
    {  
        super("my window"); 
        setLayout(null); 
        setBackground(new Color(150,200,100)); 
        setSize(350,550);
        add(bex);  
        bex.setBounds(120,480,100,20);   
        bex.addActionListener(this); 
        add(connect); 
        connect.setBounds(120,455,100,20);
        connect.addActionListener(this);   
        add(lfio);  
        lfio.setBounds(30,30,80,20);
        add(lage);
        lage.setBounds(30,60,80,20); 
        add(tfio); 
        tfio.setBounds(120,30,100,20);
        add(tage);
        tage.setBounds(120,60,100,20); 
        add(lstat); 
        lstat.setBounds(30,520,40,20);  
        add(tstat);
        tstat.setBounds(80,520,200,20); 
        tstat.setText("База отсоединена"); 
        add(addNewButton);
        addNewButton.setBounds(230, 40, 70, 30);
        addNewButton.addActionListener(this);
        add(studentsList);
        studentsList.setBounds(100, 100, 150, 240);
        add(deleteButton);
        deleteButton.setBounds(260, 100, 70, 30);
        deleteButton.addActionListener(this);
        add(searchTextField);
        searchTextField.setBounds(10, 380, 200, 20);
        add(searchButton);
        searchButton.setBounds(220, 380, 100, 20);
        searchButton.addActionListener(this);
        add(searchResult);
        searchResult.setBounds(10, 410, 300, 20);
        this.show(); 
        this.setLocationRelativeTo(null); 
    } 

    public void actionPerformed(ActionEvent ae)
    { 
        if(ae.getSource() == bex)
        {
            System.exit(0);
            return;
        }
        if(ae.getSource() == connect) 
        {
            ConnectBase();
            return;
        }
        if(ae.getSource() == addNewButton)
        {
            String fio = tfio.getText();
            Integer age = Integer.parseInt(tage.getText());
            AddStudent(fio, age);
            LoadStudents();
        }
        if(ae.getSource() == deleteButton)
        {
            String fio = studentsList.getSelectedItem();
            DeleteStudent(fio);
            LoadStudents();
        }
        if(ae.getSource() == searchButton)
        {
            String fio = searchTextField.getText();
            Stud student = FindStudent(fio);
            if(student == null)
            {
                searchResult.setText("No students found.");
                return;
            }
            
            String age = Integer.toString(student.getAge());
            searchResult.setText("Result - fio: " + fio + " age: " + age);
        }
    } 
 
    public static void ConnectBase()
    {       
        if(bcon==false) 
        {     
            tstat.setText("Строим Factory");
            sessionFactory =  new Configuration().configure().buildSessionFactory();
            tstat.setText("Session Factory построена");  
            tstat.setText("Соединяемся с базой");   
            try      
            {     
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                conn = DriverManager.getConnection(dbURL); 
            }     
            catch (Exception except)  
            {    
                tstat.setText("Ошибка соединения:"+except.getMessage());
            } 
            tstat.setText("Соединение установлено с Derby database"); 
            bcon=true; 
            session = sessionFactory.openSession(); 
            LoadStudents();
        }         
        else     
        {       
            tstat.setText("База уже подсоединена");  
        }           
    }
    
    public static void main(String[] args)
    {    
        new HiberLabVis();
    }
    
    private static void LoadStudents()
    { 
        studentsList.clear();
        
        session = sessionFactory.openSession();
        session.beginTransaction();  
        List<Stud> result=session.createQuery("from Stud").list(); 
        for(Stud x:result)    
        {      
            studentsList.add(x.getFio());
        }     
        session.getTransaction().commit();
        session.close();
    }
    
    private static void AddStudent(String fio, Integer age)
    {
        Stud student = new Stud(fio, age);
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
    
    private static void DeleteStudent(String fio)
    {
        session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("delete from STUD where FIO = "+"'"+fio+"'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    
    private static Stud FindStudent(String fio)
    {
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Stud> result=session.createQuery("from Stud where FIO = '"+fio+"'").list(); 
        session.getTransaction().commit();
        session.close();
        if(result.isEmpty())
        {
            return null;
        }
        
        return result.get(0);
    }
}

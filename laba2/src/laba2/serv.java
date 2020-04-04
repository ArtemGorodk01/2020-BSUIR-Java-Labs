/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gorod
 */
public class serv extends Frame implements ActionListener{  
    private Button createClient1 = new Button("Create client #1");
    private Button createClient2 = new Button("Create client #2");
    private TextArea textArea = new TextArea();
    private Account account = new Account();
    
    public serv(){
        super("Laba 2");
        setLayout(null);
        setBackground(new Color(150,200,100));
        setSize(450,250);
        add(createClient1);
        add(createClient2);
        add(textArea);
        createClient1.setBounds(110,190,100,20);
        createClient1.addActionListener(this); 
        createClient2.setBounds(110,165,100,20);
        createClient2.addActionListener(this);
        textArea.setBounds(20,50,300,100); 
        this.show();
        this.setLocationRelativeTo(null);
        this.startAccount();
    }
    
    public boolean handleEvent(Event evt){//Используется обработчик
        //событий ранних версий Java
        if (evt.id==Event.WINDOW_DESTROY){//Закрыть приложение
            System.exit(0);
        }
        return super.handleEvent(evt);
    }
    
    public boolean mouseDown(Event evt,int x,int y){//Обработчик события от мыши
        new clientThread().start();//Запуск потока клиента
        return true;
    }
    
    //there was main
    public void startAccount(){
        this.account.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if(ae.getSource()==createClient1){  
                new clientThread().start();
                sleep(100);
                textArea.append("\n" + "1: " + this.account.GetAccountAmount());
            }
            else if (ae.getSource()==createClient2){
                new clientThread2().start();
                sleep(100);
                textArea.append("\n" + "2: " + this.account.GetAccountAmount());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(serv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


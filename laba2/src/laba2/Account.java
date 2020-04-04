/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba2;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author gorod
 */
class Account extends Thread{
    ServerSocket server;
    String amountstring;
    static int amount=200;
    
    public int GetAccountAmount(){
        return amount;
    }
    
    public void run(){
        try
        {
            server= new ServerSocket(3001); //Номер сокета
        }
        catch(Exception e)
        { 
            System.out.println("Ошибка соединения+"+e);
        }
        while(true)
        { 
            Socket s=null;
            try{
                s=server.accept(); //ожидание соединения с клиентом
            }
            catch(Exception e){
                System.out.println("Ошибка"+e);
                System.out.println("error is here");
            }
            try{
                PrintStream ps=new PrintStream(s.getOutputStream());
                //PrintStream предназначен для текстового вывода
                int amountcur=((int)(Math.random()*1000));
                //отрицательный вклад 	снятие части денег со счета
                if (Math.random()>0.5)
                    amount-=amountcur; 
                else
                    amount+=amountcur;
                Integer x=new Integer(amount);
                amountstring=x.toString();
                ps.println("Account:"+amountstring);
                //передача строки клиенту 
                ps.flush();
                s.close();//Сокетное соединение закрывается
            }
            catch(Exception e){
                System.out.println("Ошибка	"+e);
            }
        }
    }
}




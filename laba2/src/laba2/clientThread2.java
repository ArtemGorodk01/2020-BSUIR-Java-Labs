/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba2;

import java.io.DataInputStream;
import static java.lang.Thread.sleep;
import java.net.Socket;

/**
 *
 * @author gorod
 */
class clientThread2 extends Thread{ 
    DataInputStream dis=null;
    Socket  s=null; 
    
    public clientThread2()
    {
        try{
            s=new Socket("127.0.0.1",3001);
            dis= new DataInputStream(s.getInputStream());
        }  
        catch(Exception e){
            System.out.println("Ошибка:	"+e);
        }
    }

    public void run(){
        while (true){
            try{
                sleep(100);
            }
            catch(Exception er){
                System.out.println("Ошибка	"+er);
            }
            try{
                String msg=dis.readLine();
                if(msg==null)
                    break;
                System.out.println("From client 2");
                System.out.println(msg);
            }
            catch(Exception e){
                System.out.println("ERRORR+"+e);
            }
        }
    }
}
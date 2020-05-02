package com;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path; 
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
 
@WebService(serviceName = "FileUpload") 
public class FileUpload
{  
    private Map<String,String> fileNamePath = new HashMap<String, String>();
    
    public FileUpload()
    {
        fileNamePath.put("book1", "C:\\Users\\gorod\\Documents\\javaSend\\lab5\\documents\\doc1.txt");
        fileNamePath.put("book2", "C:\\Users\\gorod\\Documents\\javaSend\\lab5\\documents\\doc2.txt");
        fileNamePath.put("book3", "C:\\Users\\gorod\\Documents\\javaSend\\lab5\\documents\\doc3.txt");
        fileNamePath.put("book4", "C:\\Users\\gorod\\Documents\\javaSend\\lab5\\documents\\doc4.txt");
        fileNamePath.put("book5", "C:\\Users\\gorod\\Documents\\javaSend\\lab5\\documents\\doc5.txt");
    }
    
    @WebMethod(operationName = "getBooks")  
    public String[] getBooks()
    {
        String[] bookNames = new String[fileNamePath.size()];
        Set set = fileNamePath.entrySet();
        Iterator iterator = set.iterator();
        Integer i = 0;
        while(iterator.hasNext()) {
          Map.Entry mentry = (Map.Entry)iterator.next();
          bookNames[i] = mentry.getKey().toString();
          i++;
       }
        
       return bookNames;
    }
    
    @WebMethod(operationName = "hello")  
    public String hello(@WebParam(name = "name") String txt)
    {    
        return "Hello " + txt + " !";
    }
 
    @WebMethod(operationName = "getFile")  
    public byte [] getFile(@WebParam(name = "bookName") String bookName) 
    {
        byte [] buf=null;  
        java.awt.FileDialog fd=null;     
        java.awt.Dialog di=null;        
        try   
        {  
            Path path = Paths.get(fileNamePath.get(bookName));   
            buf = Files.readAllBytes(path);
        }              
        catch(Exception ex)     
        {        
        }      
        return buf;  
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gorod
 */
public class DatabaseWorker 
{
    private static Connection conn = null; 
    private static  CallableStatement stmt = null;
    
    public String GetTranslation(String word)
    {
        String sqlStatement = "Select * from dictionary where RussionWord='"+word.toLowerCase()+"' or EnglishWord='"+word.toLowerCase()+"'";
        try {
            OpenConnection();
            if(conn == null)
            {
                System.out.println("conection failed");
                return "jopa";
            }
            stmt = conn.prepareCall(sqlStatement);
            if(stmt !=null)
            {
                System.out.println("stmt created");
            }
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            stmt.execute();
            String russionWord = stmt.getString(1);
            String englishWord = stmt.getString(2);
            if(word.equalsIgnoreCase(russionWord))
            {
                return englishWord;
            }
            else if(word.equalsIgnoreCase(russionWord))
            {
                return russionWord;
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Nothing has been found.";
    }
    
    private void OpenConnection()
    {
        try
        {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab3", "root ", "d0n1pm00"); 
        }
        catch(Exception ex)
        {
        }
    }
}

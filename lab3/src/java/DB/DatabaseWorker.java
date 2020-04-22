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
    private static  Statement stmt = null;
    
    public String GetTranslation(String word)
    {
        String sqlStatement = "Select * from dictionary where RussionWord='"+word.toLowerCase()+"' or EnglishWord='"+word.toLowerCase()+"'";
        try {
            OpenConnection();
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sqlStatement);
            resultSet.next();
            String russionWord = resultSet.getString(1);
            String englishWord = resultSet.getString(2);
            if(word.equalsIgnoreCase(russionWord)) 
            {
                return englishWord;
            }
            else if(word.equalsIgnoreCase(englishWord))
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
         Class.forName("org.apache.derby.jdbc.ClientDriver"). newInstance();
         conn = DriverManager.getConnection("jdbc:derby://localhost:1527/laba3", "artem", "artem"); 
        }
        catch(Exception ex)
        {
            conn = null;
        }
    }
}

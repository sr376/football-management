
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    Connection connection = null;
    private String userName = "root";
    private String password = "";
    String DATABASE_URL = "jdbc:mysql://localhost/footballmanagement2";
   // public DatabaseConnection(String DATABASE_URL){
      //  this.DATABASE_URL = DATABASE_URL; 
  //  }
    
   
    public Connection startConnection(){
           try {
            //        String DATABASE_URL = "jdbc:mysql://localhost:3306/mynewdatabase";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection =  DriverManager.getConnection(DATABASE_URL,userName,password);
            
            System.out.println("connected");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        return  connection;
    }
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

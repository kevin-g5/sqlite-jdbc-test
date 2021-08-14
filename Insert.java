import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class InsertRecords {  
   
    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C:/databases/notes.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void insert(String alias, Integer label, Integer hands) {  
        String sql = "INSERT INTO players(alias, label, hands) VALUES(?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, alias);  
            pstmt.setInteger(2, label);
            pstmt.setInteger(3, hands);
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        InsertRecords app = new InsertRecords();  
        // insert five new rows
        // label 1 = yellow
        // label 2 = green
        // label 3 = cyan
        // label 4 = light blue
        // label 5 = dark blue
        // label 6 = magenta
        // label 7 = red
        // label 8 = orange
        app.insert("jovanni60", 3, 10);  
        app.insert("Lesley6", 5, 10);  
        app.insert("GottheNuts", 1, 10);
        app.insert("KapitanKox3", 8, 10);
        app.insert("flashy882244", 7, 10);
    }  
   
}  

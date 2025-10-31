// JDBC Connectivity
package tripmanagementsystem1;
import java.sql.*;

public class Connector {
    Connection c;
    Statement s;

    Connector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tripmanagementsystem1", "root", "root");
            s = c.createStatement(); // ✅ Correct usage
            System.out.println("Connected Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//mysql is an external entity then there are chances for exception at runtime so put it in try and catch block

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;  // we need to create an obj for Connection interface this is 2nd step
    Statement s; // with the help of Statement we can execute mysql queries  or this Executes the given SQL statement, which returns a single ResultSet object.  3rd step creating statement

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //Class is java class and forName() is a static method   // load the driver this is 1st step
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","Admin@12345");    //hotelmanagementsystem is the db name in mysql    2nd step creating a connection string

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

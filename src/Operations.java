import java.sql.*;
import java.util.Scanner;

public class Operations {
    //    Function to create new record
    public static void createRecord(String name, String email, String dateOfBirth) {
        try {
            Conn con = new Conn();
            String query = "INSERT INTO Registration (Name, Email, DateOfBirth) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = con.c.prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, dateOfBirth);
                preparedStatement.executeUpdate();
                System.out.println("Record created successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error creating record: " + e.getMessage());
        }
    }

    // function to retrieve records
    public static void readRecords() {
        try {
            Conn con = new Conn();
            String selectQuery = "SELECT * FROM Registration";
            try (Statement statement = con.c.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("ID") + " | " +
                            resultSet.getString("Name") + " | " +
                            resultSet.getString("Email") + " | " +
                            resultSet.getDate("DateOfBirth"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error retrieving records: " + e.getMessage());
        }
    }

    // Function to update an existing record
    public static void updateRecord(int recordId, String newName) {
        try{
            Conn con = new Conn();
            String updateQuery = "UPDATE Registration SET Name = ? WHERE ID = ?";
            try (PreparedStatement preparedStatement = con.c.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, newName);
                preparedStatement.setInt(2, recordId);
                preparedStatement.executeUpdate();
                System.out.println("Record updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error updating record: " + e.getMessage());
        }
    }

    // Function to delete a record
    public static void deleteRecord(int recordId) {
        try  {
            Conn con = new Conn();
            String deleteQuery = "DELETE FROM Registration WHERE ID = ?";
            try (PreparedStatement preparedStatement = con.c.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, recordId);
                preparedStatement.executeUpdate();
                System.out.println("Record deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error deleting record: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
//        createRecord("John Doe", "john.doe@example.com", "1990-01-15");
//        readRecords();
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("1.For Adding New Data\n 2.For retrieve records\n 3.For update an existing data\n 4.For delete a record\n 5.For exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    System.out.println("Enter email: ");
                    String email = sc.next();
                    System.out.println("Enter DOB in format(yy-mm-dd): ");
                    String dob = sc.next();
                    createRecord(name, email, dob);
                    break;
                case 2:
                    readRecords();
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    int rec = sc.nextInt();
                    System.out.println("Enter name: ");
                    String name1 = sc.next();
                    updateRecord(rec, name1);
                    break;
                case 4:
                    System.out.println("Enter id: ");
                    int del = sc.nextInt();
                    deleteRecord(del);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}

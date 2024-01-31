# Registration System - Java JDBC with MySQL
This is a simple Java application using JDBC to interact with a MySQL database for performing CRUD operations on user registration records.

## Prerequisites
- Java Development Kit (JDK) installed on your machine
- MySQL Database Server installed locally
- MySQL Workbench (optional but recommended for database management)

## Setup
1. **Clone the Repository:**
2. **Set Up the Database:**
    - Open MySQL Workbench and execute the SQL script from `database.sql` to create the 'Registration' table:

3. **Configure Database Connection:**
    - Open `Conn.java` in the `src` directory.
    - Modify the `JDBC_URL`, `JDBC_USER`, and `JDBC_PASSWORD` with your MySQL database details.

4. **Compile and Run the Application:**

5. **Interact with the Application:**

    - Follow the menu options in the console to perform CRUD operations on user registration records.

## Additional Notes
- Ensure that the MySQL JDBC driver (`mysql-connector-java-8.0.23.jar`) is in the project's classpath.


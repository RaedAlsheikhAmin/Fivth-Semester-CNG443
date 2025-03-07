import java.sql.*;

/**
 * This is a simple class that explains how a java application can be connected
 * to a Mysql database
 **/
public class Main {
    // This is the JDBC driver class
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // STEP 2 -- Establish a connection
            System.out.println("Establishing a connection");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test", "cng443user", "1234");//update according to the url
            System.out.println("Database connected");

            // STEP 3 -- Create a statement
            statement = connection.createStatement();

            // STEP 4 -- Execute a statement
            ResultSet resultSet = statement.executeQuery("select * from Exam");

            ResultSetMetaData meta = resultSet.getMetaData();
            // Return the column count
            int iColumnCount = meta.getColumnCount();

            System.out.println("\nThere are " + iColumnCount + " columns:");
            for (int i = 1; i <= iColumnCount; i++) {
                System.out.println("Column Name: " + meta.getColumnName(i));
                System.out.println("Column Type" + meta.getColumnTypeName(i));
                System.out.println("Display Size: " + meta.getColumnDisplaySize(i));
                System.out.println("Precision: " + meta.getPrecision(i));
                System.out.println("Scale: " + meta.getScale(i) + "\n");
            }

            // Iterate through the result and print the student names
            while (resultSet.next()) {
                for (int i = 1; i <= meta.getColumnCount(); i++)//u can iterate thro the size of the columns for each row.a
                    System.out.printf("%-12s\t", resultSet.getObject(i));
                System.out.println();
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}

/*
 * SQL Queries:
 *
 * create table exam ( eno integer, etitle varchar(50), timeAllowed integer,
 * numberOfQuestionsPerPage integer, primary key (eno) );
 *
 * insert into exam values (3,'Elementary History',10,3);
 *
 * GRANT ALL PRIVILEGES ON *.* TO 'username'@'localhost' IDENTIFIED BY
 * 'password';
 */

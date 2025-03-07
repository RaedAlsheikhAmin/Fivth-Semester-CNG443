import java.sql.*;

/**
 * This is a simple class that explains how a java application can be connected
 * to a Mysql database
 **/
public class ASimpleJdbc {
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/javaexam", "test", "test");
			System.out.println("Database connected");

			// STEP 3 -- Create a statement
			statement = connection.createStatement();

			// STEP 4 -- Execute a statement
			ResultSet resultSet = statement.executeQuery("select * from Exam");

			// Iterate through the result and print the student names
			while (resultSet.next())
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t"
						+ resultSet.getString(4));


			  //System.out.println("\n Uptading the database!");
			  //statement.executeUpdate("update exam set etitle = \"Hello World\" where eno = 3");


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

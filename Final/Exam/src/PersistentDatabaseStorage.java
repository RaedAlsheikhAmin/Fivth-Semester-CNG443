import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * a class that read and writes the User and internship into External Database.
 *
 * @author Raed Alsheikh Amin
 * @version 17.0.8
 */
public class PersistentDatabaseStorage implements PersistenData{

    @Override
    public  void readStudent(Exam bnb) {
        Connection connection = null;
        Statement statement = null;
        Student user = null;
        Internship intern = null;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // STEP 2 -- Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "cng443user", "1234");
            // STEP 3 -- Create a statement
            statement = connection.createStatement();

            // STEP 4 -- Execute a statement
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String firstName = resultSet.getString("name");
                user=new Student(userId,firstName);
                bnb.students.add(user);
                if (user != null) {
                    System.out.println("student has been added");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeStudent(Exam bnb) {

    }

    @Override
    public void readInternship(Exam bnb) {
        Connection connection = null;
        Statement statement = null;
        Student user = null;
        Internship intern = null;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // STEP 2 -- Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "cng443user", "1234");
            // STEP 3 -- Create a statement
            statement = connection.createStatement();

            // STEP 4 -- Execute a statement
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String hasInternship = resultSet.getString("hasInternship");
                String status = resultSet.getString("status");
                intern=new Internship(userId,hasInternship);
               // bnb.students..add(intern);
                if (user != null) {
                    System.out.println("internship has been added");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeInternship(Exam bnb) {

    }

}

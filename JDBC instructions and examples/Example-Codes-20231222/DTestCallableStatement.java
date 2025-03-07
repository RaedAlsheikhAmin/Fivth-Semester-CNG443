import java.sql.*;

public class Main {
    /** Creates new form TestTableEditor */
    public static void main(String[] args) throws Exception {

        // STEP1 -- Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        // STEP 2 -- Establish a connection
        System.out.println("Establishing a connection");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test", "cng443user", "1234");
        System.out.println("Database connected");

        // Create a callable statement
        PreparedStatement preparedStatement = connection.prepareStatement("select * from exam where etitile=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);// question mark means parameter, and the more we have the more parameters we should provide, before i run the statement i have to customize it.

        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter exam's name: ");
        String examName = input.nextLine();


        preparedStatement.setString(1, examName);
        ResultSet rs = preparedStatement.executeQuery();
        rs.last();
        if (rs.getRow() == 0)
            System.out.println(examName + " is NOT in the database");
        else
            System.out.println(examName + " is in the database");

        input.close();
    }
}

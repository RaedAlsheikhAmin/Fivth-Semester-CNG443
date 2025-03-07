package Bed_And_Breakfast;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * a class that read and writes the User and Property into External Database.
 * @author Raed Alsheikh Amin
 * @version 17.0.8
 *
 */
public class DataStorage {
    /**
     * it will take BASIC class as a parameter that it reads the properties after creating a connection
     * the date in database is in format of YYYY-MM-dd, so we use simpledateformate to change the formate of the date.
     *
     * @param bnb
     */
    public static void readUsersandProperties(BASIC bnb) {
        Connection connection = null;
        Statement statement = null;
        User user=null;
        Property property=null;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // STEP 2 -- Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BasicDB", "cng443user", "1234");
            // STEP 3 -- Create a statement
            statement = connection.createStatement();

            // STEP 4 -- Execute a statement
            ResultSet resultSet = statement.executeQuery("select * from User");
            while (resultSet.next()) {
                int userId = resultSet.getInt("userID");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String formattedDateOfBirth = outputDateFormat.format(inputDateFormat.parse(dateOfBirth.toString()));//to change the formate of the date
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                Date registrationDate = resultSet.getDate("registrationDate");
                String formattedregisteration = outputDateFormat.format(inputDateFormat.parse(registrationDate.toString()));//to change the formate of the date
                String type = resultSet.getString("type");
                String preferredPaymentMethod = resultSet.getString("preferredPaymentMethod");
                double taxNumber = resultSet.getDouble("taxNumber");
                int goldLevel = resultSet.getInt("goldLevel");


                if(type.charAt(0)=='g') {
                     user=new Gold(userId, formattedDateOfBirth, firstName, lastName, formattedregisteration, preferredPaymentMethod, goldLevel);
                }
                else if(type.charAt(0)=='s')
                {
                     user = new Standard(userId, formattedDateOfBirth, firstName, lastName, formattedregisteration, preferredPaymentMethod);
                }
                else if(type.charAt(0)=='h')
                {
                     user = new Host(userId, formattedDateOfBirth, firstName, lastName, formattedregisteration, taxNumber);
                }
                bnb.users.add(user);
                if(user!=null)
                {
                    System.out.println("user has been added");
                }
            }
            // STEP 4 -- Execute a statement
             resultSet = statement.executeQuery("select * from Property");
            while (resultSet.next()) {
                int propertyID = resultSet.getInt("propertyID");
                int noBedRooms = resultSet.getInt("noBedRooms");
                int noRooms = resultSet.getInt("noRooms");
                String city = resultSet.getString("city");
                float pricePerDay = (float)resultSet.getDouble("pricePerDay");
                String type = resultSet.getString("type");
                double propertySize = resultSet.getDouble("propertySize");

                if(type.charAt(0)=='s') {
                    property = new SharedProperty(propertyID, noBedRooms, noRooms, city, pricePerDay);
                }
                else if(type.charAt(0)=='f')
                {
                    property = new FullProperty(propertyID, noBedRooms, noRooms, city, pricePerDay, propertySize);
                }
                bnb.properties.add(property);
                if(property!=null)
                {
                    System.out.println("property has been added");
                }
            }

            // Iterate through the result and print the user names


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

        //close the connection.

    }

    /**
     * it will take BASIC parameter that it writes the data to the database, and to avoid duplication or error of primary key integrity
     * we delete the data before writing the new ones.
     * some helper methods are used instead of using overriding.
     * @param bnb
     */
    public static void writeUsersAndProperties(BASIC bnb) {
        Connection connection = null;
        Statement statement = null;
//to delete the database rows before inserting new data that we avoid duplication
        String clearUsersTable = "DELETE FROM User";
        String clearPropertiesTable = "DELETE FROM Property";



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BasicDB", "cng443user", "1234");
            statement = connection.createStatement();
            //emptying the tables
            statement.executeUpdate(clearUsersTable);
            statement.executeUpdate(clearPropertiesTable);
            //
            // Write Users to the database
            for (User user : bnb.users) {
                String sqlUser = "INSERT INTO User VALUES (" +
                        user.getUserId() + ", '" +
                        user.getDateOfBirthAsString() + "', '" +
                        user.getFirstName() + "', '" +
                        user.getLastName() + "', '" +
                        user.getregistrationdateAsString()+ "', '" +
                        getTypeuser(user) + "', '" +
                        user.getPreferredPaymentMethod() + "', " +
                        user.getTaxNumber() + ", " +
                        user.getGoldlevel() + ")";

                statement.executeUpdate(sqlUser);
            }

            // Write Properties to the database
            for (Property property : bnb.properties) {
                String sqlProperty = "INSERT INTO Property VALUES (" +
                        property.getPropertyId() + ", " +
                        property.getNumberOfBedrooms() + ", " +
                        property.getNumberOfRooms() + ", '" +
                        property.getCity() + "', " +
                        property.getPricePerDay() + ", '" +
                        getTypeproperty(property) + "', " +
                        getPropertySize(property)+ ")";

                statement.executeUpdate(sqlProperty);
            }

            System.out.println("\nData has been written to the database.");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    private static char getTypeuser(User user)
    {
        if(user instanceof Gold)
            return 'g';
        else if (user instanceof Standard)
            return 's';
        return 'h';
    }
    private static char getTypeproperty(Property property)
    {
        if(property instanceof SharedProperty)
            return 's';

        return 'f';
    }
    private static double getPropertySize(Property property)
    {
        if(property instanceof FullProperty)
            return ((FullProperty) property).getPropertysize();

        return 0.0;
    }
}


package Bed_And_Breakfast;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * The BASIC class represents a simplified booking application that will have an arraylist of properties and arraylist of users.
 *
 * @version  17.0.8
 * @author Raed Alsheikh Amin
 */
public class BASIC{
    public ArrayList<User> users= new ArrayList<>();
    public ArrayList<Property> properties= new ArrayList<>();
    private int UserID = 4;
    private int PropertyID = 4;
    private int HostID=4;
    /**
     * Main method to run the booking application.
     * The main will create and object of BASIC, then the program will start accordingly.
     * PopulateData is Static class that is why we could use it without making an object of it.
     * switch statement is going to handle our menu.
     * while loop is fed in true because it is not important to control it since choice:12 is going to exit the app.
     *
     * @param args Command-line arguments (not used).
     *
     */

    public static void main(String [] args){

    BASIC bnb=new BASIC();
    PopulateData.initializeData(bnb);
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            bnb.menu();
            try {
                choice = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    // Add User
                    bnb.addUser();
                    break;
                case 2:
                    // Delete User
                    System.out.print("Enter User ID to delete: ");
                    int userId = input.nextInt();//reading the user ID.
                    bnb.deleteUser(userId);
                    break;
                case 3:
                    // Get User Details
                    System.out.print("Enter User ID to get details: ");
                     userId = input.nextInt();
                     bnb.getUserDetails(userId);
                    break;
                case 4:
                    // Add Property
                    bnb.addProperty();
                    break;
                case 5:
                    // Delete Property

                    System.out.print("Enter Property ID to delete: ");
                    int propertyId = input.nextInt();
                    bnb.deleteProperty(propertyId);
                    break;
                case 6:
                    // Get Property Details

                    System.out.print("Enter Property ID to get details: ");
                     propertyId = input.nextInt();
                     bnb.getPropertyDetails(propertyId);
                    break;
                case 7:
                    // Add Booking
                    System.out.print("Enter User ID: ");
                    userId=input.nextInt();
                    System.out.print("Enter Property ID: ");
                    propertyId=input.nextInt();
                    bnb.addBooking(userId,propertyId);
                    break;
                case 8:
                    // Get User Bookings
                    System.out.print("Enter User ID to get the bookings of that user: ");
                    userId=input.nextInt();
                    bnb.getUserBooking(userId);
                    break;
                case 9:
                    // Get Booking Cost
                    System.out.print("Enter User ID: ");
                    userId=input.nextInt();
                    System.out.print("Enter Property ID: ");
                    propertyId=input.nextInt();
                    bnb.getBookingCost(userId,propertyId);
                    break;
                case 10:
                    // List Users
                    bnb.listUsers();
                    break;
                case 11:
                    // List Properties
                    bnb.listProperties();
                    break;
                case 12:
                    // Exit
                    bnb.exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }


    }
    /**
     * Default constructor for the BASIC class.
     */
    public BASIC(){}
    /**
     * Overloaded constructor for the BASIC class.
     *
     * @param user User object.
     * @param property Property object.
     * @param userID User ID.
     * @param propertyID Property ID.
     * @param hostID Host ID.
     */
    public BASIC(User user, Property property, int userID, int propertyID, int hostID) {
        users.add(user);
        properties.add(property);
        UserID = userID;
        PropertyID = propertyID;
        HostID = hostID;
    }
    /**
     * Overloaded constructor for the BASIC class.
     *
     * @param userID User ID.
     * @param propertyID Property ID.
     * @param hostID Host ID.
     */
    public BASIC(int userID, int propertyID, int hostID) {
        UserID = userID;
        PropertyID = propertyID;
        HostID = hostID;
    }


    /**
     * this method will be called in the first case of switch statement.
     * Adds a new user to the list of users maintained.
     * The userID keeps each user unique.
     * input.nextLine is used to consume the next line character.(otherwise it will skip the next input)
     * for the Last name I assumed that it may have a composite Last Name.
     *at the end the user will be added to the users list after the constructor is called.
     * @return void
     */
    public void addUser() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        String dateOfBirth = input.next();
        System.out.print("Enter First Name: ");
        String firstName = input.next();
        System.out.print("Enter Last Name: ");
        input.nextLine();
        String lastName = input.nextLine();

        User user = new User(UserID++, dateOfBirth, firstName, lastName);
        users.add(user);//to add user to my arraylist in basic
        System.out.print("User info: "+firstName+" "+ lastName+" "+ dateOfBirth+" ");
        System.out.println("has been added successfully with the following User ID: " + (UserID- 1));

    }

    /**
     * this method will be called in the second case of switch statement.
     * it will take the userId to check if that user exists or not before doing any operation.
     * it will make an User oject that goes throw all the users while getting their ids and checking it with the given id.
     * if it is found, it will be deleted from the ArrayList.
     * if it not found, it prints that user with given ID doesn't exists.
     * @param userId
     */
    public void deleteUser(int userId) {

        for (User user : users) {
            if (user.getUserId() == userId) {
                users.remove(user);
                System.out.println("User with ID " + userId + " deleted successfully.");
                return;
            }
        }

        System.out.println("User with ID " + userId + " does not exist.");
    }

    /**
     * this method will be called in the third case of switch statement.
     * it will take the user id as an input that it can display the info of the specific user.
     * it will create an Obect of User class that loops all the users until it finds the given ID.
     * if it is found, the info of the user will be displayed, otherwise "doesn't exist " will be the output.
     * @param userId
     */
    public void getUserDetails(int userId) {

        for (User user : users) {
            if (user.getUserId() == userId) {
                System.out.println("User ID: "+user.getUserId()+"\nUser first name: "+user.getFirstName()+"\nUser last name: "+user.getLastName()+"\nUser date of Birth: "+user.getDateOfBirth());//the getdateofbirth is not fully correct
                return;
            }
        }

        System.out.println("User with ID " + userId + " does not exist.");
    }

    /**
     * this method will be called in the fourth case in switch statement.
     * this method adds a property to the arraylist of properties.
     * it asks the user to give the required info to initiate a constructor that it can add it to the arraylist.
     * in the same times, this method asks the user to have a unique host, that is why it asks for the info of the host.
     * we can not have a property unless we have a host.
     */
    public void addProperty() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Number of Bedrooms: ");
        int numberOfBedrooms = input.nextInt();
        System.out.print("Enter Number of Rooms: ");
        int numberOfRooms = input.nextInt();
        System.out.print("Enter City: ");
        String city = input.next();
        System.out.print("Enter Price Per Day: ");
        float pricePerDay = input.nextFloat();
        System.out.print("Enter Host first Name: ");
        String Hostfirstname=input.next();
        System.out.print("Enter Host Last Name: ");
        input.next();
        String Hostlastname=input.nextLine();
        System.out.print("Enter Host Registration Date: ");
        String registrationdate= input.next();


        Host h=new Host(HostID++,Hostfirstname,Hostlastname,registrationdate);

        Property property = new Property(PropertyID++, numberOfBedrooms, numberOfRooms, city, pricePerDay,h );
        properties.add(property);
        
        System.out.println("Property added successfully. Property ID: " + (PropertyID - 1));
    }

    /**
     * this method will be called in the fifth case in the switch statement.
     * the method takes a propertyId from the user that it can check for it in the properties list.
     * and then deletes it if it is there, otherwise displays doesn't exist.
     *
     *
     * @param propertyId
     */
    public void deleteProperty(int propertyId) {

        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                properties.remove(property);
                System.out.println("Property with ID " + propertyId + " deleted successfully.");
                return;
            }
        }

        System.out.println("Property with ID " + propertyId + " does not exist.");
    }

    /**
     * this method will be called in the sixth case in the switch statement.
     * it will get the propertyId and then loop it to find the target, and will display the target info, if the
     * target is not there, it will display doesn't exist.
     * @param propertyId
     */
    public void getPropertyDetails(int propertyId) {

        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                System.out.println("Property Id: "+property.getPropertyId()+"\nNumber of Bedrooms: "+property.getNumberOfBedrooms()+"\nNumber of Rooms: "+property.getNumberOfRooms()+"\nPrice Per Day: "+property.getPricePerDay()+"$");
                return;
            }
        }

        System.out.println("Property with ID " + propertyId + " does not exist.");
    }

    /**
     * this method will be called in the seventh case in the switch statement.
     * it will add a booking according to the userId and propertyId given, which is the case for real life scenario.
     * we can not add a booking for a dummy user, so the user should exist.
     * we can not add a booking in a dummy property, so the property should exist.
     * otherwise, error message will be displayed.
     * @param userId
     * @param propertyId
     */
    public void addBooking(int userId, int propertyId) {
        Scanner input = new Scanner(System.in);

        // Check if the user with the given ID exists
        User userToAddBooking = null;
        for (User user : users) {
            if (user.getUserId() == userId) {
                userToAddBooking = user;
                break;
            }
        }

        if (userToAddBooking == null) {
            System.out.println("User with ID " + userId + " does not exist. Booking cannot be added.");
            return;
        }

        // Check if the property with the given ID exists
        Property propertyToAddBooking = null;
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                propertyToAddBooking = property;
                break;
            }
        }

        if (propertyToAddBooking == null) {
            System.out.println("Property with ID " + propertyId + " does not exist. Booking cannot be added.");
            return;
        }

        // Ask for start date
        System.out.print("Enter Start Date (dd/MM/yyyy): ");
        String startDateString = input.next();

        // Ask for end date
        System.out.print("Enter End Date (dd/MM/yyyy): ");
        String endDateString = input.next();

        // Record the booking
        Booking booking = new Booking(userId, propertyId, startDateString, endDateString);
        userToAddBooking.addBooking(booking);

        System.out.println("Booking added successfully.");
    }

    /**
     * this method will be called in the eighth case in the switch statement.
     * it will get the user booking details based on the userId given.
     * when ever it finds the target user, it will user a method called ListBookings that gives the user booking info
     * @param userId
     */
    public void getUserBooking(int userId) {
        boolean hasBookings = false;

        for (User user : users) {
            if (user.getUserId() == userId) {
                user.listBookings();//to list the info of the bookings.
                hasBookings = true;
            }
        }

        if (!hasBookings) {
            System.out.println("No bookings found for User ID " + userId);
        }
    }

    /**
     * this method will be called in the ninth case in the switch statement.
     * it will take both userId, and propertyId and check for the booking for each user in each property.
     * it will display the booking cost for each booking that the user made.
     * @param userId
     * @param propertyId
     */
    public void getBookingCost(int userId, int propertyId) {
        boolean userFound = false;
        boolean propertyFound = false;

        System.out.println("Booking Costs for User ID " + userId + " and Property ID " + propertyId + ":");

        for (User user : users) {
            if (user.getUserId() == userId) {
                userFound = true;

                for (Booking booking : user.getBooking()) {
                    if (booking.getPropertyId() == propertyId) {
                        propertyFound = true;

                        Property property = getPropertyById(propertyId);

                        if (property != null) {
                            double cost = booking.totalCost(property);
                            System.out.println("Booking Cost: $" + cost);
                        }
                    }
                }

                if (!propertyFound) {
                    System.out.println("No bookings found for Property ID " + propertyId);
                }
            }
        }

        if (!userFound) {
            System.out.println("User with ID " + userId + " does not exist.");
        }
    }

    /**
     * this is a private helper method to get the Property from a given propertyId
     * @param propertyId
     * @return property
     */
    private Property getPropertyById(int propertyId) {//
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                return property;
            }
        }
        return null;
    }

    /**
     * this method will be called in the 10th case in the switch statement.
     * it will loop all the users and print their info , with the booking info for each user.
     */
    public void listUsers() {
        System.out.println("List of Users:");

        for (User user : users) {
            System.out.println("User ID: "+user.getUserId()+"\nUser first name: "+user.getFirstName()+"\nUser last name: "+user.getLastName()+"\nUser date of Birth: "+user.getDateOfBirth());
            user.listBookings();
            System.out.println("----------------------------");
        }
    }

    /**
     * this method will be called in the 11th case in the switch statement.
     * it will loop all the existed properties and print their info, with the host info for each property.
     */
    public void listProperties() {
        System.out.println("List of Properties:");

        for (Property property : properties) {
            System.out.println("Property ID: "+property.getPropertyId()+"\nNumber of BedRooms: "+property.getNumberOfBedrooms()+"\nNumber of Rooms: "+property.getNumberOfRooms()+"\nPrice per Day: "+property.getPricePerDay()+"$");
            System.out.println("Host Details: ");
            System.out.println("Host Name: "+property.getHost().getFirstName()+"\nHost Last Name: "+property.getHost().getLastName()+"\nHost ID: "+property.getHost().getHostId()+"\nHost Registration Date: "+property.getHost().getRegistrationDate());
            System.out.println("----------------------------");
        }
    }

    /**
     * this method will be called in the 12th case in the switch statement.
     * it will exist the program after it is called.
     */
    public void exit() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }
    /**
     * Displays the interaction menu to the user.
     * that he can choose which operation he wants to do in the main method.
     *
     *
     * @return void
     */
    public void menu() {
        System.out.println("Main Menu:\n======================");
        System.out.println("1: Add User");
        System.out.println("2: Delete User");
        System.out.println("3: Get User Details");
        System.out.println("4: Add Property");
        System.out.println("5: Delete Property");
        System.out.println("6: Get Property Details");
        System.out.println("7: Add Booking");
        System.out.println("8: Get User Bookings");
        System.out.println("9: Get Booking Cost");
        System.out.println("10: List Users");
        System.out.println("11: List Properties");
        System.out.println("12: Exit");
        System.out.print("Enter your choice: ");
    }
}

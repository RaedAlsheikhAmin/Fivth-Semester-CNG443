package Bed_And_Breakfast;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * The BASIC class represents a simplified booking application that will have an arraylist of properties and arraylist of users.
 * it will handle the entire program.
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
     * while loop is fed in true because it is not important to control it since choice:14 is going to exit the app.
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
                    //add feedback
                    System.out.print("Enter Property ID: ");
                    propertyId=input.nextInt();
                    System.out.println("Please write your report about this property: "+propertyId);
                    System.out.print("Your Feedback: ");
                    input.nextLine();
                    String feedback=input.nextLine();
                    bnb.addInspectionToProperty( propertyId, feedback);
                    break;
                case 13:
                    //compare prices.
                    System.out.print("Enter the first Property ID: ");
                    propertyId=input.nextInt();
                    System.out.print("Enter the second Property ID: ");
                    int propertyId2=input.nextInt();

                    bnb.comparePropertyPricesPerDay(propertyId, propertyId2);

                    break;
                case 14:
                    //exit the program
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

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(int propertyID) {
        PropertyID = propertyID;
    }

    public int getHostID() {
        return HostID;
    }

    public void setHostID(int hostID) {
        HostID = hostID;
    }

    /**
     * Adds a new user to the list of users maintained.
     * The userID keeps each user unique.
     * input.nextLine is used to consume the next line character.(otherwise it will skip the next input)
     * for the Last name I assumed that it may have a composite Last Name.
     * we will have multiple type of Users, either host, or customer which is either standard or gold
     * depending on the requirements the constructor will be called to add the specified user.
     *at the end the user will be added to the users list after the constructor is called.
     * @return void
     */
    public void addUser() {
        Scanner input = new Scanner(System.in);
        User user;

        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        String dateOfBirth = input.next();
        System.out.print("Enter First Name: ");
        String firstName = input.next();
        System.out.print("Enter Last Name: ");
        input.nextLine();
        String lastName = input.nextLine();
        System.out.print("Enter the registration Date (dd/MM/yyyy): ");
        String registrationdate= input.next();
        System.out.print("What is the User Type:\n1. Gold Customer\n2. Standard Customer\n3. Host\nPlease enter the type of the User: ");
        int usertype=input.nextInt();
        while(usertype<1 || usertype>3)//to check the user type validity.
        {
            System.out.println("User Type is not valid, Please Enter the type again: ");
            usertype=input.nextInt();
        }

        if(usertype==1 ) {
            System.out.print("Please enter the preferred payment method: ");
            String preferredpaymentmethod=input.next();
            System.out.print("Enter the Level(1-3): ");
            int level=input.nextInt();
            while(level>3 || level<1)
            {
                System.out.print("Please enter a valid level between (1-3): ");
                level=input.nextInt();
            }
             user = new Gold(UserID++, dateOfBirth, firstName, lastName,registrationdate,preferredpaymentmethod, level);
        }
        else if(usertype==2)
        {
            System.out.print("Please enter the preferred payment method: ");
            String preferredpaymentmethod=input.next();
             user = new Standard(UserID++, dateOfBirth, firstName, lastName,registrationdate,preferredpaymentmethod);
        }
        else
        {
            System.out.print("Please enter the tax number: ");
            double TaxNum=input.nextDouble();
             user=new Host(UserID++,dateOfBirth, firstName, lastName,registrationdate,TaxNum);
        }

        users.add(user);//to add user to my arraylist in basic
        System.out.print("User info: "+firstName+" "+ lastName+" "+ dateOfBirth+" ");
        System.out.println("has been added successfully with the following User ID: " + (UserID- 1));

    }

    /**
     * it will take the userId to check if that user exists or not before doing any operation.
     * it will make a User object that goes throw all the users while getting their ids and checking it with the given id.
     * if it is found, it will be deleted from the ArrayList.
     * if it not found, it prints that user with given ID doesn't exist.
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
     * it will take the user id as an input that it can display the info of the specific user.
     * it will create an Obect of User class that loops all the users until it finds the given ID.
     * if it is found, the info of the user will be displayed according to toString overriden method in all the users., otherwise "doesn't exist " will be the output.
     * @param userId
     */
    public void getUserDetails(int userId) {

        boolean userFound = false;

        for (User user : users) {
            if (user.getUserId() == userId) {
                userFound = true;
                System.out.println(user); // Utilize the overridden toString method
                break; // No need to continue searching after finding the user
            }
        }


        if (!userFound) {
            System.out.println("User with ID " + userId + " does not exist.");
        }
    }

    /**
     * this method adds a property to the arraylist of properties.
     * it asks the user to give the required info to initiate a constructor that it can add it to the arraylist.
     * the property will be divided into two parts, either full property or shared one.
     * for the full property it will ask for the size of the property in m^2.
     * if the given hostid doesn't exist, the method offer the option to create a host at that moment with the same info.
     * in the same times, this method asks the user to have a unique host, that is why it asks for the info of the host.
     * we can not have a property unless we have a host.
     */
    public void addProperty() {
        Scanner input = new Scanner(System.in);
        Property property;
        int option=0;

        System.out.print("Enter Number of Bedrooms: ");
        int numberOfBedrooms = input.nextInt();
        System.out.print("Enter Number of Rooms: ");
        int numberOfRooms = input.nextInt();
        System.out.print("Enter City: ");
        String city = input.next();
        System.out.print("Enter Price Per Day: ");
        float pricePerDay = input.nextFloat();
        System.out.print("Is it \n1. shared room\n2. full house:\nyour option: ");
        int propertytype=input.nextInt();
        while(propertytype>2 || propertytype<1)
        {
            System.out.println("You entered invalid option!!");
            System.out.print("Is it \n1. shared room\n2. full house\nyour option: ");
            propertytype=input.nextInt();
        }
        System.out.print("Enter Host ID: "); //check the host later.
        int hostid=input.nextInt();
        Host hostToAdd = null;
        for (User user : users) {
            if (user.getUserId() == hostid && user instanceof Host) {
                hostToAdd = (Host) user;
                break;
            }
        }

        if (hostToAdd == null) {
            System.out.println("Host with ID " + hostid + " does not exist. First create a host then assign the property!");
            System.out.print("do you want to add the host details and then assign it to the property?\n1.Yes\n2.NO\nyour choice: ");
            option=input.nextInt();
            if(option==2)
                return;

        }
        if(option==1) {
            System.out.print("enter the date of birth: ");
            String dob = input.next();
            System.out.print("enter the first name: ");
            String firstname = input.next();
            System.out.print("enter the last name: ");
            input.nextLine();//to consume the next line
            String lastname = input.nextLine();
            System.out.print("enter the registration date: ");
            String regdate = input.next();
            System.out.print("enter the Tax number: ");
            double taxnum = input.nextDouble();

            hostToAdd = new Host(hostid, dob, firstname, lastname, regdate, taxnum);//creating a new host to add to property.

            users.add(hostToAdd);//that we avoid duplication since host is a user.
        }


        if(propertytype==1)
        {
             property=new SharedProperty(PropertyID++, numberOfBedrooms, numberOfRooms, city, pricePerDay,hostToAdd);
        }
        else
        {
            System.out.print("Please enter the size of the house in terms of square meters: ");
            double propertysize=input.nextDouble();
             property=new FullProperty(PropertyID++,numberOfBedrooms,numberOfRooms,city,pricePerDay,hostToAdd,propertysize);
        }
        properties.add(property);
        System.out.println("Property added successfully. Property ID: " + (PropertyID - 1));
    }

    /**
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
     * it will get the propertyId and then loop it to find the target, and will display the target info using the overriden toString method, if the
     * target is not there, it will display doesn't exist.
     * @param propertyId
     */
    public void getPropertyDetails(int propertyId) {

        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                System.out.print(property);
                return;
            }
        }

        System.out.println("Property with ID " + propertyId + " does not exist.");
    }

    /**
     * it will add a booking according to the userId and propertyId given, which is the case for real life scenario.
     * we can not add a booking for a dummy user, so the user should exist.
     * we can not add a booking in a dummy property, so the property should exist.
     * the user should be specialized to be a Customer, that is why we use instanceof to check the validity
     * otherwise, error message will be displayed.
     * starting and ending date for the booking will be recorded.
     * @param userId
     * @param propertyId
     */
    public void addBooking(int userId, int propertyId) {
        Scanner input = new Scanner(System.in);

        // Check if the user with the given ID exists
        Customer userToAddBooking = null;
        for (User user : users) {
            if (user.getUserId() == userId && user instanceof Customer customer) {
                userToAddBooking=(Customer)user;
                break;
            }
            else if(user.getUserId()==userId && user instanceof Host)
                System.out.println("Host can not make reservation unless he is a customer!");
        }

        if (userToAddBooking == null) {
            System.out.println("Customer with ID " + userId + " does not exist. Booking cannot be added.");
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
        userToAddBooking.addbooking(booking);

        System.out.println("Booking added successfully.");
    }

    /**
     * it will get the user booking details based on the userId given.
     * when ever it finds the target user, it will use a method called ListBookings that gives the user(customer) booking info
     * @param userId
     */
    public void getUserBooking(int userId) {
        boolean userexists=false;

        for (User user : users) {
            if (user.getUserId() == userId && user instanceof Customer customer) {
                customer.listBookings();//to list the info of the bookings.
                userexists = true;
            }
        }

        if (!userexists) {
            System.out.println("No Customer found with User ID " + userId);
        }
    }

    /**
     * it will take both userId, and propertyId and check for the booking for each user in each property.
     * it will display the booking cost for each booking that the user made.
     * the bookingcost now is calculated using calculatePricePerDay() method in property class.
     * some discounts will be applied if the user meets the specified requirements .
     * @param userId
     * @param propertyId
     */
    public void getBookingCost(int userId, int propertyId) {
        boolean userFound = false;
        boolean propertyFound = false;

        System.out.println("Booking Costs for User ID " + userId + " and Property ID " + propertyId + ":");

        for (User user : users) {
            if (user.getUserId() == userId && user instanceof Customer) {
                userFound = true;
                Customer customer=(Customer) user;

                for (Booking booking : customer.getBookings()) {
                    if (booking.getPropertyId() == propertyId) {
                        propertyFound = true;

                        Property property = getPropertyById(propertyId);

                        if (property != null) {
                            double cost = booking.totalCost(property);
                            double discount=getDiscountForUser(userId);
                            double costafterdiscount=cost-(discount*cost);
                            System.out.println("Booking Cost: $" + cost);
                            System.out.println("applicable discount:  " + discount);
                            System.out.println("Booking Cost after applying the discount for Gold Customers and 10 years loyal Standard Customer: $"+costafterdiscount);
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
     * otherwise it returns null
     * @param propertyId
     * @return Property
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
     * it will loop all the users and print their info , with the booking info for each user.
     */
    public void listUsers() {
        System.out.println("List of Users:");

        for (User user : users) {
            System.out.println(user);
            user.listBookings();
            System.out.println("----------------------------");
        }
    }

    /**
     * it will loop all the existed properties and print their info, with the host info for each property.
     * it will give the option to list the hosts for each property or not.
     */
    public void listProperties() {
        Scanner input=new Scanner(System.in);
        System.out.println("List of Properties:");
        System.out.print("do you want to list the host of the properties?\n1.Yes\n2.No\nYour option: ");
        int option=input.nextInt();

        for (Property property : properties) {
            System.out.println(property);
            if(option==1)
                System.out.println(property.getHost());
            System.out.println("----------------------------");
        }
    }

    /**
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
        System.out.println("12: Add feedback to a property");
        System.out.println("13: Compare two properties according to the price");
        System.out.println("14: Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * it will check the type of the user using instanceof, then it will implement the calculations based on the type of User.
     * if gold user, it will return the level/100% as a discount.
     * if standard user,it will check for the time that the user has been registered in the system using the current date.
     * more than 10 years, 2% discount will be guaranteed.
     * the method is using zoneID and Instand to convert the Date object into LocalDate, to use period to calculate the duration.
     * @param userID
     * @return double
     */
    public double getDiscountForUser(int userID) {
        boolean userFound = false;

        for (User user : users) {
            if (user.getUserId() == userID) {
                userFound = true;
                if(user instanceof Gold)
                {
                    return ((Gold) user).getGoldlevel()/100.0;
                }
                else if(user instanceof Standard)
                {
                    Instant instant = user.getRegisterationdate().toInstant();
                    ZoneId zoneId = ZoneId.systemDefault();
                    LocalDate localRegistrationDate = instant.atZone(zoneId).toLocalDate();

                    // Get the current date
                    LocalDate currentDate = LocalDate.now();

                    // Calculate the duration between the registration date and the current date
                    Period period = Period.between(localRegistrationDate, currentDate);

                    // Check if the registration is more than 10 years
                    if (period.getYears() >= 10) {
                        System.out.println("The user has been registered for more than 10 years.");
                        return 2.0/100.0;
                    } else {
                        System.out.println("The user has been registered for less than 10 years.");
                        // No discount for the standard customer
                    }
                }

                break;
            }

        }
        return 1.0;
    }

    /**
     * it will add feedback to a given propertyid, which will be registered in a hashmap, cosidering the current date as a key which can not be repeated.
     * @param propertyId
     * @param report
     */
    public void addInspectionToProperty(int propertyId, String report) {
        Property property = getPropertyById(propertyId);
        LocalDate currentDate = LocalDate.now();
        if (property != null && !property.inspection.containsKey(currentDate)) {
            property.inspection.put(currentDate, report);
            System.out.println("Inspection has been added: "+report+ ", on Date: "+currentDate);
        }
        else if(property != null && property.inspection.containsKey(currentDate))
        {
            System.out.println("You can not give feedback more than once a day!");
        }

    }

    /**
     * this method will take 2 property id from the user and it will return a statement that confirm which one is cheaper.
     * it will be calculated using calculatepriceperday() which is in propertyclass
     *
     * @param propertyId1
     * @param propertyId2
     */
    public void comparePropertyPricesPerDay(int propertyId1, int propertyId2)
    {
        Property property1=getPropertyById(propertyId1);
        Property property2=getPropertyById(propertyId2);

        if(property1==null)
        {
            System.out.println("the first property doesn't exist!");
            return;
        }
        if(property2==null)
        {
            System.out.println("the second property doesn't exist!");
            return;
        }
        if(property1.compareTo(property2) > 0)
            System.out.println("Property with ID: "+propertyId2+" is cheaper");
        else if(property1.compareTo(property2)==0)
            System.out.println("“they have the same price!");
        else
            System.out.println("Property with ID: "+propertyId1+" is cheaper");


    }


}

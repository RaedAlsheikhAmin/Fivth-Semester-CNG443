package Bed_And_Breakfast;

import java.util.ArrayList;
import java.util.Date;

/**
 * PopulateData class which will have a static method to populate 3 objects of each class for the program to start working.
 * @version  17.0.8
 * @author Raed Alsheikh Amin
 */
public class PopulateData {
    /**
     * static function will be called to initialize the data for 3 objects of each, and add them to the Arraylists that we have in BASIC class.
     * @param bnbApp
     */
    public  static void initializeData(BASIC bnbApp) {
        // Create and add user objects
        User user1 = new User(1, "25/05/2001", "Raed", "Alsheikh Amin");
        User user2 = new User(2, "12/02/2003", "Farnaz", "Rezaei Noey");
        User user3 = new User(3, "11/04/2001", "Ahmad", "Salamah");

        // Create hosts and add property objects
        Host host1 = new Host(1, "Host1FirstName", "Host1LastName", "09/05/2007");
        Host host2 = new Host(2, "Host2FirstName", "Host2LastName", "02/01/2019");
        Host host3 = new Host(3, "Host3FirstName", "Host3LastName", "05/29/2023");

        Property property1 = new Property(1, 20, 100, "Paris", 50, host1);
        Property property2 = new Property(2, 30, 200, "London", 60, host2);
        Property property3 = new Property(3, 40, 300, "Ankara", 70, host3);


        // Create and add booking objects
        Booking booking1 = new Booking(1,1,"20/12/2020","23/12/2020"); // 3 days
        Booking booking2 = new Booking(2,2,"15/08/2019","19/09/2019"); // 34 days
        Booking booking3 = new Booking(3,3,"12/04/2023","12/06/2023"); // 60 days

        user1.addBooking(booking1);
        user2.addBooking(booking2);
        user3.addBooking(booking3);


        //adding the properties to the arraylist of Property Object of BASIC object .
        bnbApp.properties.add(property1);
        bnbApp.properties.add(property2);
        bnbApp.properties.add(property3);
        ////adding the users to the arraylist of User Object of BASIC object .
        bnbApp.users.add(user1);
        bnbApp.users.add(user2);
        bnbApp.users.add(user3);
    }

}

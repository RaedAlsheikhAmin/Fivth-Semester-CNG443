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
        User user1 = new Host(1, "25/05/2001", "Raed", "Alsheikh Amin","20/20/2001",521);
        User user2 = new Gold(2, "12/02/2003", "Farnaz", "Rezaei Noey","20/20/2002","cash",2);
        User user3 = new Standard(3, "11/04/2001", "Ahmad", "Salamah","20/21/2003","credit");

        // Create hosts and add property objects
        Host host1 = new Host(4, "09/05/2007","Host1FirstName", "Host1LastName", "09/05/2007",5002);
        Host host2 = new Host(5, "09/05/2008","Host2FirstName", "Host2LastName", "09/05/2008",5003);
        Host host3 = new Host(6, "09/05/2009","Host3FirstName", "Host3LastName", "09/05/2009",5004);

        Property property1 = new SharedProperty(1, 20, 100, "Paris", 1000, host1);
        Property property2 = new FullProperty(2, 10, 200, "London",1000,host1,400);
        Property property3 = new FullProperty(3, 40, 300, "Ankara", 1001,host2, 400);


        // Create and add booking objects
        Booking booking1 = new Booking(2,1,"20/12/2020","23/12/2020"); // 3 days
        Booking booking2 = new Booking(2,2,"15/09/2019","19/09/2019"); // 4 days
        Booking booking3 = new Booking(3,3,"12/06/2023","13/06/2023"); // 1 day

        user2.addbooking(booking1);
        user2.addbooking(booking2);
        user3.addbooking(booking3);


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

package Bed_And_Breakfast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A User class that we can make use of it in the BASIC class
 * it will have booking arraylist because each user can have multiple booking.
 * @version  17.0.8
 * @author Raed ALsheikh Amin
 */
public class User {
    private int userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private ArrayList<Booking> bookings;

    /**
     * a method to convert a string to a specified Date object.
     * @param dateStr
     * @return dateFormat.parse(dateStr)
     * @throws ParseException
     */
    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }

    /**
     * overloaded constructor to initialize the date with the given parameter.
     * @param userId
     * @param dateOfBirth
     * @param firstName
     * @param lastName
     */
    public User(int userId, String dateOfBirth, String firstName, String lastName)  {
        this.userId = userId;
        try {
            this.dateOfBirth = parseDate(dateOfBirth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookings = new ArrayList<>(); // Initialize the bookings list
    }

    /**
     * overloaded constructor to initialize the data with the given parameter.
     * @param userId
     * @param firstName
     * @param lastName
     */

    public User(int userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookings = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    /**
     * this method is going to display the user all bookings.
     */

    public void listBookings() {//extra helper method
        // List all the bookings for this user
        System.out.println("Bookings for User ID " + userId + ":");
        for (Booking booking : bookings) {
            System.out.println("Start Date: " + booking.getStartDate());
            System.out.println("End Date: " + booking.getEndDate());
            System.out.println("The booking is in Property ID: " + booking.getPropertyId());
            System.out.println("----------------------------");
        }
    }
    public ArrayList<Booking> getBooking() {
        return bookings;//to return the list of bookings that each user has.
    }
}

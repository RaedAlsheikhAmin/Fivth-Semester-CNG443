package Bed_And_Breakfast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A User class that we can make use of it in the BASIC class
 * it is abstract class and both host and customer are inherited from User.
 * @version  17.0.8
 * @author Raed ALsheikh Amin
 */
public abstract class User {
    private int userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;

    private Date registerationdate;

    public User() {

    }

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
     * @param registerationdate
     */
    public User(int userId, String dateOfBirth, String firstName, String lastName,String registerationdate)  {
        this.userId = userId;
        try {
            this.dateOfBirth = parseDate(dateOfBirth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            this.registerationdate = parseDate(registerationdate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
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

    public Date getRegisterationdate() {
        return registerationdate;
    }

    public void setRegisterationdate(Date registerationdate) {
        this.registerationdate = registerationdate;
    }

    /**
     * this method is abstract and going to display the user all bookings in Customer class,
     */

    public abstract void listBookings() ;//extra helper method

    /**
     * overriden method to show each user's info.
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", dateOfBirth=" + dateOfBirth +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    /**
     * it will add booking in Customer class, that is why it is abstract in User class.
     * @param booking
     */
    public abstract void addbooking(Booking booking);

    /**
     * abstract method for returning booking
     * @return
     */
    public abstract Booking[] getbooking();

    /**
     * abstract method to get list of bookings, it will be overriden in customer.
     * @return
     */
    public abstract ArrayList<Booking> getBookings();

}

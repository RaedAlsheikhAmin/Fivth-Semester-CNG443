package Bed_And_Breakfast;

import java.util.ArrayList;

/**
 * abstract class which will extend User class
 * it will maintain the bookings arraylist for each customer.
 *
 * @version 17.0.8
 * @author Raed Alseikh Amin
 */

public abstract class Customer extends User{
    private String preferredPaymentMethod;
    private ArrayList<Booking> bookings;

    public Customer() {

    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    /**
     * overloaded constructor to initialize the properties.
     * @param userId
     * @param dateOfBirth
     * @param firstName
     * @param lastName
     * @param registrationdate
     * @param preferredPaymentMethod
     */
    public Customer(int userId, String dateOfBirth, String firstName, String lastName, String registrationdate,String preferredPaymentMethod) {
        super(userId, dateOfBirth, firstName, lastName,registrationdate);
        this.preferredPaymentMethod=preferredPaymentMethod;
        this.bookings=new ArrayList<>(1);
    }

    /**
     * overloaded constructor but different parameters
     * @param userId
     * @param firstName
     * @param lastName
     * @param preferredPaymentMethod
     */
    public Customer(int userId, String firstName, String lastName,String preferredPaymentMethod) {
        super(userId, firstName, lastName);
        this.preferredPaymentMethod=preferredPaymentMethod;
        this.bookings=new ArrayList<>(1);
    }

    public double discountPercentage(){//need to be completed later.
        return 0;
    }
    public int getUserId(){
        return super.getUserId();
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    public void addbooking(Booking booking)
    {
        if(bookings==null)
        {
            bookings=new ArrayList<Booking>();
        }
        bookings.add(booking);
    }

    /**
     * overriden method to display the Customer info.
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + getUserId() +
                ", dateOfBirth=" + getDateOfBirth() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                '}'+"Customer{" +
                "preferredPaymentMethod='" + preferredPaymentMethod + '\'' +
                '}';
    }

    // List all the bookings for this user

    /**
     * overridden method to display the bookings that each customer has.
     */
    public  void listBookings() {//extra helper method
        if(bookings.isEmpty())
        {
            System.out.println("This Customer has no bookings");
        }
        else {
            System.out.println("Bookings for User ID " + getUserId() + ":");
            for (Booking booking : bookings) {
                System.out.println("Start Date: " + booking.getStartDate());
                System.out.println("End Date: " + booking.getEndDate());
                System.out.println("The booking is in Property ID: " + booking.getPropertyId());
                System.out.println("----------------------------");
            }
        }
    }

}

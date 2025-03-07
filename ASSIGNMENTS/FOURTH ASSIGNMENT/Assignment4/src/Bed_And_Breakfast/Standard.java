package Bed_And_Breakfast;

import java.io.Serializable;

/**
 * Standard class which extends customer.
 * @version 17.0.8
 * @author Raed Alsheikh Amin
 */
public class Standard extends Customer implements Serializable {
    /**
     * overloaded constructor to initialize the data.
     * @param userId
     * @param dateOfBirth
     * @param firstName
     * @param lastName
     * @param registrationdate
     * @param preferredPaymentMethod
     */
    public Standard(int userId, String dateOfBirth, String firstName, String lastName, String registrationdate, String preferredPaymentMethod) {
        super(userId, dateOfBirth, firstName, lastName, registrationdate,preferredPaymentMethod);
    }

    /**
     * different parameters for overloaded costructor
     * @param userId
     * @param firstName
     * @param lastName
     * @param preferredPaymentMethod
     */
    public Standard(int userId, String firstName, String lastName, String preferredPaymentMethod) {
        super(userId, firstName, lastName, preferredPaymentMethod);
    }

    public Standard() {
        super();
    }

    /**
     * it will return the userid which is overloaded in the User and customer classes.
     * @return
     */
    public int getUserId(){
        return super.getUserId();
    }

    /**
     * overridden method, it will print out the Standard customer info.
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
                "preferredPaymentMethod='" + getPreferredPaymentMethod() + '\'' +
                '}'+"Standard{}";
    }

    @Override
    public Booking[] getbooking() {
        return new Booking[0];
    }

    @Override
    public double getTaxNumber() {
        return 0;
    }

    @Override
    public int getGoldlevel() {
        return 0;
    }

}


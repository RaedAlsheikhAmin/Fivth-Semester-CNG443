package Bed_And_Breakfast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/**
 * The host class will own the property, and will be recorded everytime we create a new property.
 * @version  17.0.8
 * @author Raed Alsheikh Amin
 */
public class Host extends User {
    private double TaxNumber;

    /**
     * A method to covert String to Date object in a specified format.
     * @param dateStr
     * @return dateFormat.parse(dateStr)
     * @throws ParseException
     */
    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }

    /**
     * default constructor
     */
    public Host(){
        super();
    }

    /**
     * overloaded constructor to initialize the data.
     * @param userId
     * @param dateOfBirth
     * @param firstName
     * @param lastName
     * @param registrationdate
     * @param TaxNumber
     */

    public Host(int userId, String dateOfBirth, String firstName, String lastName,String registrationdate,double TaxNumber)  {
        super( userId,  dateOfBirth,  firstName,  lastName,registrationdate);
        this.TaxNumber=TaxNumber;

    }


    /**
     * overloaded constructor but different parameters
     * @param userId
     * @param firstName
     * @param lastName
     * @param TaxNumber
     */
    public Host(int userId, String firstName, String lastName,double TaxNumber) {
        super( userId,  firstName,  lastName);
        this.TaxNumber=TaxNumber;


    }

    public double getTaxNumber() {
        return TaxNumber;
    }

    public void setTaxNumber(double taxNumber) {
        TaxNumber = taxNumber;
    }

    /**
     * it overrides the same method in User to get the userID.
     * @return
     */
    public int getUserId(){
        return super.getUserId();
    }

    /**
     * no implementation is needed because host can not have booking, but it has to be here.
     */
    @Override
    public void listBookings() {

    }

    /**
     * it overrides the same method in user to display the info of this class.
     * @return
     */
    @Override
    public String toString() {

        return "User{" +
                "userId=" + getUserId() +
                ", dateOfBirth=" + getDateOfBirth() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                '}'+"Host{" +
                "TaxNumber=" + TaxNumber +
                '}';
    }

    /**
     * override but no need to implement, it was for customer
     * @param booking
     */
    @Override
    public void addbooking(Booking booking) {

    }

    /**
     * for customer only.
     * @return
     */
    @Override
    public Booking[] getbooking() {
        return new Booking[0];
    }

    /**
     * for customer.
     * @return
     */
    public  ArrayList<Booking> getBookings()
    {
        return new ArrayList<>();
    }
}

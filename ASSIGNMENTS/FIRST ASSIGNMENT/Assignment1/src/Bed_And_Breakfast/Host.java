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
public class Host {
    private int hostId;
    private String firstName;
    private String lastName;
    private Date registrationDate;

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
    public Host(){}

    /**
     * overloaded costructor with the specified parameter to initialize the object.
     * @param hostId
     * @param firstName
     * @param lastName
     * @param registrationDate
     */
    public Host(int hostId, String firstName, String lastName, String registrationDate)  {
        this.hostId = hostId;
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            this.registrationDate = parseDate(registrationDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * overloaded constructor with different parameters.
     * @param hostId
     * @param firstName
     * @param lastName
     */

    public Host(int hostId, String firstName, String lastName) {
        this.hostId = hostId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


    public int getHostId() {
        return hostId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

}

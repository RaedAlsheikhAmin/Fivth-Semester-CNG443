package Bed_And_Breakfast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Booking class which is used to maintain the bookings in User.
 * @version  17.0.8
 * @author Raed Alsheikh Amin
 */
public class Booking {
    private int userId;
    private int propertyId;
    private Date startDate;
    private Date endDate;
    private boolean ispaid;

    /**
     * it takes a string and turns it to an object of Date in dd/mm/yyyy format, using SimpleDateFormat.
     * @param dateStr
     * @return dateFormat.parse(dateStr)
     * @throws ParseException
     */
    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }

    /**
     * Default constructor of Booking.
     */
    public Booking(){}

    /**
     * overloaded constructor that takes the provided parameter to initialize the data.
     * @param userId
     * @param propertyId
     * @param startDate
     * @param endDate
     */

    public Booking(int userId, int propertyId, String startDate, String endDate) {
        this.userId = userId;
        this.propertyId = propertyId;
        try {
            this.startDate = parseDate(startDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            this.endDate = parseDate(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * overloaded constructor that takes the provided parameter to initialize the data.
     * @param userId
     * @param startDate
     * @param endDate
     * @param ispaid
     */
    public Booking(int userId, String startDate, String endDate,boolean ispaid) {
        this.userId = userId;
        try {
            this.startDate = parseDate(startDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            this.endDate = parseDate(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.ispaid=ispaid;
    }

    public int getUserId() {
        return userId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * this method will calculate the total cost of the booking for a user.
     * it will use getTime method that   return the time in milliesecond which will be returned in Long data type.
     * then it will calculate the days according to the equation, which we will have 24 hours, 60 minutes, 60 seconds, and 1000 for canceling the millieseconds.
     * @param property
     * @return days * property.getPricePerDay()
     */
    public float totalCost(Property property) {
        long diffInMillies = endDate.getTime() - startDate.getTime();
        long days = diffInMillies / (24 * 60 * 60 * 1000);
        return days * property.getPricePerDay();
    }
}

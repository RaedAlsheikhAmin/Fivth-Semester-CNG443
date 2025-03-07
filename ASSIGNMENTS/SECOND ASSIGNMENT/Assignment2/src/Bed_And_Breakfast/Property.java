package Bed_And_Breakfast;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Property abstract class that will hold properties in the BASIC class according to the UML diagram.
 * it will store the host because each property will have one host.
 * it will implement both PropertyPrice and comparable interfaces.
 * @version  17.0.8
 * @author Raed Alsheikh Amin
 */
public abstract class Property implements PropertyPrice,Comparable<Property> {
    private int propertyId;
    private int numberOfBedrooms;
    private int numberOfRooms;
    private String city;
    private float pricePerDay;
    private Host host;
    HashMap<LocalDate,String> inspection;

    /**
     * default constructor
     */
    public Property(){}

    /**
     * overloaded constructor, it will allocate memory for the inspection in a hashmap.
     * @param propertyId
     * @param numberOfBedrooms
     * @param numberOfRooms
     * @param city
     * @param pricePerDay
     * @param host
     */
    public Property(int propertyId, int numberOfBedrooms, int numberOfRooms, String city, float pricePerDay,Host host) {
        this.propertyId = propertyId;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfRooms = numberOfRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.host=host;
        this.inspection=new HashMap<LocalDate,String>();

    }

    /**
     * a method to add a host to a property.
     * @param h
     */
    public void addHost(Host h){
        this.host=h;
    }

    /**
     * overloaded constructor with different parameters.
     * @param propertyId
     * @param numberOfBedrooms
     * @param numberOfRooms
     * @param city
     * @param host
     */

    public Property(int propertyId, int numberOfBedrooms, int numberOfRooms, String city,Host host) {
        this.propertyId = propertyId;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfRooms = numberOfRooms;
        this.city = city;
        this.host=host;
        this.inspection=new HashMap<LocalDate,String>();
    }

    public int getPropertyId() {
        return propertyId;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getCity() {
        return city;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    /**
     * overridden toString method to print out the info of the property and to check if it is full or shared one.
     * @return
     */
    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfRooms=" + numberOfRooms +
                ", city='" + city + '\'' +
                ", pricePerDay=" + pricePerDay +"$"+
                ", inspection=" + inspection +
                '}'+"\n";
    }

    /**
     *implemented method from propertypice interface, this method will check the price for each property and it will be called in the Booking class totalcost().
     * it will check the price for each property and check the taxes applied depending on the type of the property.
     * if it is shared, it will divide the price/#of rooms
     * if it is full, it will calculate based on the size of the property.
     * @param property
     * @return
     */
    public double calculatePricePerDay(Property property){
    if(property instanceof SharedProperty)
    {
        return property.getPricePerDay()/property.getNumberOfBedrooms();
    }
    else if(property instanceof FullProperty)
    {
        if(((FullProperty) property).getPropertysize()<200)
        {
            return (property.getPricePerDay()+getPricePerDay()/100);
        }
        else if(((FullProperty) property).getPropertysize()>=200 && ((FullProperty) property).getPropertysize()<=300)
        {
            return (property.getPricePerDay()+((3*getPricePerDay())/100));
        }
        return (property.getPricePerDay()+((4*getPricePerDay())/100));
    }


    return 0.0;
    }

    /**
     * this is implemented from comparable interface, it will take a Property object and compare it with another one.
     * depending on the result it will return integer value that will be calculated further in the Basic class to display a message to the user.
     * @param otherProperty the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Property otherProperty) {
        double priceThisProperty = this.calculatePricePerDay(this);//it means this object.
        double priceOtherProperty = otherProperty.calculatePricePerDay(otherProperty);
        if(priceThisProperty>priceOtherProperty)
            return 1;
        else if(priceThisProperty<priceOtherProperty)
            return -1;
        else
            return 0;
    }
}

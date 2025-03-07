package Bed_And_Breakfast;

/**
 * Property class that will hold properties in the BASIC class according to the UML diagram.
 * it will store the host because each property will have one host.
 * @version  17.0.8
 * @author Raed Alsheikh Amin
 */
public class Property {
    private int propertyId;
    private int numberOfBedrooms;
    private int numberOfRooms;
    private String city;
    private float pricePerDay;
    private Host host;

    /**
     * default constructor
     */
    public Property(){}

    /**
     * overloaded constructor
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
}

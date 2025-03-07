package Bed_And_Breakfast;

/**
 * SharedProperty will extend property to inherit all the fields.
 * @version 17.0.8
 * @author Raed Alsheikh Amin
 */
public class SharedProperty extends Property{
    /**
     * default constructor
     */
    public SharedProperty() {
    }

    /**
     * overloaded constructor to initialize the data.
     * @param propertyId
     * @param numberOfBedrooms
     * @param numberOfRooms
     * @param city
     * @param pricePerDay
     * @param host
     */
    public SharedProperty(int propertyId, int numberOfBedrooms, int numberOfRooms, String city, float pricePerDay, Host host) {
        super(propertyId, numberOfBedrooms, numberOfRooms, city, pricePerDay, host);
    }

    /**
     * different parameters to be initialized
     * @param propertyId
     * @param numberOfBedrooms
     * @param numberOfRooms
     * @param city
     * @param host
     */
    public SharedProperty(int propertyId, int numberOfBedrooms, int numberOfRooms, String city, Host host) {
        super(propertyId, numberOfBedrooms, numberOfRooms, city, host);
    }

    /**
     * overridden toString() method that will print out the info of sharedProperty.
     * @return
     */
    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + getPropertyId() +
                ", numberOfBedrooms=" + getNumberOfBedrooms() +
                ", numberOfRooms=" + getNumberOfRooms() +
                ", city='" + getCity() + '\'' +
                ", pricePerDay=" + getPricePerDay() +"$"+
                ", inspection=" + inspection +
                '}'+"SharedProperty{}"+"\n";
    }
}

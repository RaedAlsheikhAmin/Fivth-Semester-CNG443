package Bed_And_Breakfast;

/**
 * Fullproperty which extends property class, and it will have an extra field (propertysize)
 *
 */
public class FullProperty extends Property{
    private double Propertysize;

    /**
     *  constructor to initialize the propertysize.
     * @param propertysize
     */
    public FullProperty(double propertysize) {
        Propertysize = propertysize;
    }

    /**
     * overloaded constructor to initialize the data.
     * @param propertyId
     * @param numberOfBedrooms
     * @param numberOfRooms
     * @param city
     * @param pricePerDay
     * @param host
     * @param propertysize
     */
    public FullProperty(int propertyId, int numberOfBedrooms, int numberOfRooms, String city, float pricePerDay, Host host, double propertysize) {
        super(propertyId, numberOfBedrooms, numberOfRooms, city, pricePerDay, host);
        Propertysize = propertysize;
    }

    /**
     * different parameters to initialize the data
     * @param propertyId
     * @param numberOfBedrooms
     * @param numberOfRooms
     * @param city
     * @param host
     * @param propertysize
     */
    public FullProperty(int propertyId, int numberOfBedrooms, int numberOfRooms, String city, Host host, double propertysize) {
        super(propertyId, numberOfBedrooms, numberOfRooms, city, host);
        Propertysize = propertysize;
    }

    public FullProperty() {

    }

    public double getPropertysize() {
        return Propertysize;
    }

    public void setPropertysize(double propertysize) {
        Propertysize = propertysize;
    }

    /**
     * overridden method to print out the info of the full property.
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
                '}'+"FullProperty{" +
                "Propertysize=" + Propertysize +"m^2"+
                '}'+"\n";
    }
}

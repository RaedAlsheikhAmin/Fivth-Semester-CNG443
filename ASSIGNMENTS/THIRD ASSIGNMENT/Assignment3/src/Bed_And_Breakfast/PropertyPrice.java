package Bed_And_Breakfast;

/**
 * an interface which will be implemented inside Property to calculate the price per day for each property.
 * @version 17.0.8
 * @author Raed Alsehikh Amin
 *
 */

public interface PropertyPrice {
     double calculatePricePerDay(Property property);
}

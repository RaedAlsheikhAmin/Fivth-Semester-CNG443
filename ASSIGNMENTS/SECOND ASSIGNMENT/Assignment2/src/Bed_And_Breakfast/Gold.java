package Bed_And_Breakfast;

/**
 * Gold class which extends customer class.
 * it will be more specialized since it has the gold level for each customer.
 * @version 17.0.8
 * @author Raed Alsheikh Amin
 *
 */
public class Gold extends Customer{
    private int goldlevel;

    /**
     * overloaded constructor to initialize the data
     * @param userId
     * @param dateOfBirth
     * @param firstName
     * @param lastName
     * @param registrationdate
     * @param preferredPaymentMethod
     * @param goldlevel
     */
    public Gold(int userId, String dateOfBirth, String firstName, String lastName,String registrationdate, String preferredPaymentMethod,int goldlevel) {
        super(userId, dateOfBirth, firstName, lastName, registrationdate,preferredPaymentMethod);
        this.goldlevel=goldlevel;
    }

    /**
     * overloaded constructor, different parameters.
     * @param userId
     * @param firstName
     * @param lastName
     * @param preferredPaymentMethod
     * @param goldlevel
     */
    public Gold(int userId, String firstName, String lastName, String preferredPaymentMethod,int goldlevel) {
        super(userId, firstName, lastName, preferredPaymentMethod);
        this.goldlevel=goldlevel;
    }

    public int getGoldlevel() {
        return goldlevel;
    }

    public void setGoldlevel(int goldlevel) {
        this.goldlevel = goldlevel;
    }

    /**
     * overriden method in User to get the userid.
     * @return
     */
    public int getUserId(){
        return super.getUserId();
    }

    /**
     * toString method which is overriden in customer and User,to print out the info of gold customer.
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
                '}'+"Gold{" +
                "goldlevel=" + goldlevel +
                '}';
    }

    /**
     *
     * @return
     */
    @Override
    public Booking[] getbooking() {
        return new Booking[0];
    }

}

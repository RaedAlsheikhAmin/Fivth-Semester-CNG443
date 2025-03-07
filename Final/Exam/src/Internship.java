/**
 * The type Internship.
 * @author Raed Alsheikh Amin
 * @version 17.0.8
 */
public class Internship {
    private int ID;
    private String status;

    /**
     * Instantiates a new Internship.
     *
     * @param ID the id
     */
    public Internship(int ID) {
        this.ID = ID;
    }

    /**
     * Instantiates a new Internship.
     *
     * @param ID     the id
     * @param status the status
     */
    public Internship(int ID, String status) {
        this.ID = ID;
        this.status = status;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getID() {
        return ID;
    }

    /**
     * Sets id.
     *
     * @param ID the id
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}

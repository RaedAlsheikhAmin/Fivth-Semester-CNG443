import java.util.ArrayList;

/**
 * The type Student.\
 *  @author Raed Alsheikh Amin
 *   @version 17.0.8
 */
public class Student {
    /**
     * The Internships.
     */
    public ArrayList<Internship>internships=new ArrayList<>();
    private int ID;
    private String name;

    /**
     * Instantiates a new Student.
     *
     * @param ID the id
     */
    public Student(int ID) {
        this.ID = ID;
    }

    /**
     * Instantiates a new Student.
     *
     * @param ID   the id
     * @param name the name
     */
    public Student(int ID, String name) {
        this.ID = ID;
        this.name = name;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}

import java.util.ArrayList;


/**
 * The type Exam.
 * @author Raed Alsheikh Amin
 * @version 17.0.8
 */
public class Exam {
    /**
     * The Students.
     */
    public ArrayList<Student> students=new ArrayList<>();


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Exam main=new Exam();
        new Desgin(main);

    }
}

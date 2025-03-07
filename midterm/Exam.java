import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Exam.
 */
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Exam {

    /**
     * Population.
     */
    public static void population()
    {
        ArrayList<Ride> rides=new ArrayList<>();
        Ride ride1=new SharedRide(1,5,100,10);
        Ride ride2=new SharedRide(2,20,100,10);
        Ride ride3=new SharedRide(3,10,100,10);
        Ride ride4=new BusRide(4,5,100,100);
        Ride ride5=new BusRide(5,5,100,20);
        Ride ride6=new BusRide(6,5,100,50);
        rides.add(ride1);
        rides.add(ride2);
        rides.add(ride3);
        rides.add(ride4);
        rides.add(ride5);
        rides.add(ride6);

    }
    //private Ride getRidebyID(int id){

    /**
     * Book passanger.
     */
// }
    public void BookPassanger()
    {
        Scanner input= new Scanner(System.in);
        System.out.print("Please enter the ride ID: ");
        int ID= input.nextInt();
        System.out.print("Please enter your name: ");
        String name= input.next();
        System.out.print("Please enter your surname: ");
        input.nextLine();
        String surname= input.nextLine();
       // Ride ride=getRidebyID(ID);


    }

    /**
     * Compareoverall income.
     *
     * @param ride1 the ride 1
     * @param ride2 the ride 2
     */
    public void CompareoverallIncome(Ride ride1,Ride ride2)
    {
        double income1= ride1.calculateNetIncome()-ride1.caculateTax();
        double income2=ride2.calculateNetIncome()-ride2.caculateTax();
        if(Double.compare(income1,income2)>=0)
            System.out.println("The highest income is for Ride 1" );
        else if(Double.compare(income1,income2)<=0)
            System.out.println("The highest income is for Ride 2" );
        else
            System.out.println("they have the same net Income" );


        System.out.println("The maximum income is in Ride" );
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
    System.out.println("Wlcome to Ride booking System");

     }
    }

/**
 * The type Ride.
 */
abstract class Ride{
    private int ID;
    private int capacity;
    private double pricePerPerson;
    /**
     * The Passangers.
     */
    ArrayList<Passanger> passangers;

    /**
     * Instantiates a new Ride.
     *
     * @param ID             the id
     * @param capacity       the capacity
     * @param pricePerPerson the price per person
     */
    public Ride(int ID, int capacity, double pricePerPerson) {
            this.ID = ID;
            this.capacity = capacity;
            this.pricePerPerson = pricePerPerson;
            passangers=new ArrayList<>();
        }

    /**
     * Instantiates a new Ride.
     *
     * @param ID       the id
     * @param capacity the capacity
     */
    public Ride(int ID, int capacity) {
            this.ID = ID;
            this.capacity = capacity;
            passangers=new ArrayList<>();
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
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
            return capacity;
        }

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

    /**
     * Gets price per person.
     *
     * @return the price per person
     */
    public double getPricePerPerson() {
            return pricePerPerson;
        }

    /**
     * Sets price per person.
     *
     * @param pricePerPerson the price per person
     */
    public void setPricePerPerson(double pricePerPerson) {
            this.pricePerPerson = pricePerPerson;
        }

    /**
     * Book ride.
     *
     * @param name    the name
     * @param surname the surname
     */
    public void bookRide(String name, String surname){
            Scanner input=new Scanner(System.in);
            System.out.print("Please enter your name: ");
             name=input.next();
            System.out.print("Please enter your surname: ");
             input.nextLine();
             surname=input.nextLine();

             Passanger passanger=new Passanger(name,surname);
             passangers.add(passanger);

        }

    /**
     * Calculate income double.
     *
     * @return the double
     */
    public double calculateIncome(){
            return passangers.size()*pricePerPerson;
        }

    /**
     * Calculate net income double.
     *
     * @return the double
     */
    public abstract double calculateNetIncome();

    /**
     * Caculate tax double.
     *
     * @return the double
     */
    public abstract double caculateTax();
    }

/**
 * The type Shared ride.
 */
class SharedRide extends Ride{
    private double driverPercentage;

    /**
     * Instantiates a new Shared ride.
     *
     * @param ID               the id
     * @param capacity         the capacity
     * @param pricePerPerson   the price per person
     * @param driverPercentage the driver percentage
     */
    public SharedRide(int ID, int capacity, double pricePerPerson, double driverPercentage) {
            super(ID, capacity, pricePerPerson);
            this.driverPercentage = driverPercentage;
        }

    /**
     * Instantiates a new Shared ride.
     *
     * @param ID               the id
     * @param capacity         the capacity
     * @param driverPercentage the driver percentage
     */
    public SharedRide(int ID, int capacity, double driverPercentage) {
            super(ID, capacity);
            this.driverPercentage = driverPercentage;
        }

    /**
     * Gets driver percentage.
     *
     * @return the driver percentage
     */
    public double getDriverPercentage() {
            return driverPercentage;
        }

    /**
     * Sets driver percentage.
     *
     * @param driverPercentage the driver percentage
     */
    public void setDriverPercentage(double driverPercentage) {
            this.driverPercentage = driverPercentage;
        }
        public double calculateNetIncome()
        {
            return this.calculateIncome()-(this.calculateIncome()*(this.driverPercentage/100.0));
        }
        public double caculateTax(){
           return  (0.05*this.calculateNetIncome());
        }
    }

/**
 * The type Bus ride.
 */
class BusRide extends Ride{
    private double driverCost;

    /**
     * Instantiates a new Bus ride.
     *
     * @param ID             the id
     * @param capacity       the capacity
     * @param pricePerPerson the price per person
     * @param driverCost     the driver cost
     */
    public BusRide(int ID, int capacity, double pricePerPerson,double driverCost) {
            super(ID, capacity, pricePerPerson);
            this.driverCost=driverCost;
        }

    /**
     * Instantiates a new Bus ride.
     *
     * @param ID       the id
     * @param capacity the capacity
     */
    public BusRide(int ID, int capacity) {
            super(ID, capacity);
        }

    /**
     * Gets driver cost.
     *
     * @return the driver cost
     */
    public double getDriverCost() {
            return driverCost;
        }

    /**
     * Sets driver cost.
     *
     * @param driverCost the driver cost
     */
    public void setDriverCost(double driverCost) {
            this.driverCost = driverCost;
        }
        public double calculateNetIncome()
        {
            return (this.calculateIncome()-(this.driverCost));
        }
        public double caculateTax(){
            return this.calculateNetIncome()/100.0;
        }
    }

/**
 * The interface Texable.
 */
interface Texable{
    /**
     * Caculate tax double.
     *
     * @return the double
     */
    double caculateTax();
    }

/**
 * The type Passanger.
 */
class Passanger{
    private String name;
    private String surname;

    /**
     * Instantiates a new Passanger.
     *
     * @param name    the name
     * @param surname the surname
     */
    public Passanger(String name, String surname) {
            this.name = name;
            this.surname = surname;
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

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
            return surname;
        }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
            this.surname = surname;
        }
    }

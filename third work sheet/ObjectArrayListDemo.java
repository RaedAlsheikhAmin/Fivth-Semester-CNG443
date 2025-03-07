import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public Loan() {
        // Default constructor
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount, Date loanDate) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
    }

    // Getters and setters for Loan fields


    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "annualInterestRate=" + annualInterestRate +
                ", numberOfYears=" + numberOfYears +
                ", loanAmount=" + loanAmount +
                ", loanDate=" + loanDate +
                '}';
    }
}

class GraphObject {
    private String color;
    private int xCoordinate;
    private int yCoordinate;
    private String caption;

    public GraphObject() {
        // Default constructor
    }

    public GraphObject(String color, int xCoordinate, int yCoordinate, String caption) {
        this.color = color;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "GraphObject{" +
                "color='" + color + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", caption='" + caption + '\'' +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getColor() {
        return color;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public String getCaption() {
        return caption;
    }
    // Getters and setters for GraphObject fields



}

public class ObjectArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();//creating an arraylist of object class that we can add whatever belongs to it.

        objects.add(new Loan(4.5, 5, 10000.0, new Date()));
        objects.add(new Date());
        objects.add("Hello, World!");
        objects.add(new Random());
        objects.add(new GraphObject("Red", 10, 20, "Sample Caption"));

        for (Object object : objects) {
            System.out.println(object.toString());
        }
    }
}

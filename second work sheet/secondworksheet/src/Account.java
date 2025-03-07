import java.util.Date;
public class Account {
    private int id;
    private double balance;
    private double annualinterestRate;
    private Date dataCreated;
    Account(){
        this.id=0;
        this.balance=0;
        this.annualinterestRate=0;
        dataCreated=new Date();//we deal with this as an object
    }
    Account(int id,double balance)
    {
        this.id=id;
        this.balance=balance;
        annualinterestRate=0;
        dataCreated= new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualinterestRate(double annualinterestRate) {
        this.annualinterestRate = annualinterestRate;
    }

    public void setDataCreated(Date dataCreated) {
        this.dataCreated = dataCreated;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualinterestRate() {
        return annualinterestRate;
    }

    public Date getDataCreated() {
        return dataCreated;
    }
    public double getMonthlyInterestRate(){
        return annualinterestRate/12;
    }
    public double getMonthlyInterest(){//idk why
        return balance*(getMonthlyInterestRate()/100);

    }
    public void withdraw(double withdraw)
    {
        if(withdraw>0 && withdraw<=this.balance)
            this.balance-=withdraw;
    }
    public void deposit(double deposite){
        if(deposite>0)
         this.balance+=deposite;
    }
}
//worksheet 4 question 1;
class CheckingAccount extends Account{
    private double overdraftLimit;

    public CheckingAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (amount <= getBalance() || amount <= overdraftLimit)) {
            setBalance(getBalance() - amount);
        }
    }

}
class SavingsAccount extends Account {
    private double overdraftLimit;

    public SavingsAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() && amount <= overdraftLimit) {
            setBalance(getBalance() - amount);
        }
    }

}
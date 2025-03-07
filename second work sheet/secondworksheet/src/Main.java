import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //first question worksheet 2 (anagram)
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the two words that you want to check if they are anagrams or not:");
        System.out.print("first word: ");
        String str1 = input.next();
        System.out.print("Second word: ");
        String str2 = input.next();
        System.out.print(isAnagram(str1, str2));
        System.out.println("");
//second question with another stock class.
        Stock sto = new Stock("ORCL", "ORACLE CORPORATION");
        sto.previousClosingPrice = 34.5;
        sto.currentPrice = 34.35;
        System.out.println(sto.getChangepercent());

        //third question with quadratic class.
        int a, b, c;
        System.out.print("Give me the values for a b c consecutively: ");
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        QuadraticEquation qua = new QuadraticEquation(a, b, c);
        if (qua.getDiscriminant() > 0) {
            System.out.println("these are the roots of the equation: " + qua.getRoot1() + qua.getRoot2());
        }
        if (qua.getDiscriminant() == 0)
            System.out.println("there is one root only for the equation: " + qua.getRoot1());
        else if (qua.getDiscriminant() < 0)
            System.out.println("there are no roots for this equation");
        //fourth question Account class
        Account aco = new Account(1122, 20000);
        aco.setAnnualinterestRate(4.5);
        aco.withdraw(2500);
        aco.deposit(3000);
        System.out.println("This is the balance of your account: $" + aco.getBalance());
        System.out.println("The monthly interest rate: $" + aco.getMonthlyInterestRate() + " the date when the accunt was created: " + aco.getDataCreated());
        //question 5 ATM machine
        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 50);
        }
        System.out.print("Enter an account id: ");
        int id = input.nextInt();
        while (id < 0 || id > 9) {
            System.out.print("\nthe id you entered is not correct, Please try with another id: ");
            id = input.nextInt();
        }
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n===================\nMain menu:\n" +
                    "1: check balance\n" +
                    "2: withdraw\n" +
                    "3: deposit\n" +
                    "4: exit\n" +
                    "Enter a choice: "
            );
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(accounts[id].getBalance() + "$");
                    break;
                case 2:
                    double amount;
                    System.out.print("Enter an amount to withdraw: ");
                    amount = input.nextDouble();
                    accounts[id].withdraw(amount);
                    break;
                case 3:
                    System.out.print("Enter an amount to deposit: ");
                    amount = input.nextDouble();
                    accounts[id].deposit(amount);
                    break;
                case 4:
                    System.out.println("bye bye!! ");
                    break;
                default:
                    System.out.println("this is not an option, please Enter another choice!!");
            }
        }
        //worksheet 4 question 1 last part
        SavingsAccount sa1 = new SavingsAccount(4, 2, 1);
        CheckingAccount ch1 = new CheckingAccount(4, 2, 1);

        System.out.println(sa1 + "\n" + ch1);//or u can use toString function

        // question 2 it is repeated but using array list.
        ArrayList<Account> arr = new ArrayList<Account>(10);//don't forget the initial capacity for the array list
        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 1 || i == 2)
                arr.add(i, new SavingsAccount(i, 50, 50));
            else if (i == 3 || i == 4 || i == 5)
                arr.add(i, new CheckingAccount(i, 50, 50));
            else
                arr.add(i, new Account(i, 50));


        }
        System.out.print("Enter an account id: ");
        id = input.nextInt();
        while (id < 0 || id > 9) {
            System.out.print("\nthe id you entered is not correct, Please try with another id: ");
            id = input.nextInt();
        }
        choice = 0;
        while (choice != 4) {
            System.out.println("\n===================\nMain menu:\n" +
                    "1: check balance\n" +
                    "2: withdraw\n" +
                    "3: deposit\n" +
                    "4: exit\n" +
                    "Enter a choice: "
            );
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(arr.get(id).getBalance() + "$");// to get the index of array list
                    break;
                case 2:
                    double amount;
                    System.out.print("Enter an amount to withdraw: ");
                    amount = input.nextDouble();
                    arr.get(id).withdraw(amount);
                    break;
                case 3:
                    System.out.print("Enter an amount to deposit: ");
                    amount = input.nextDouble();
                    arr.get(id).deposit(amount);
                    break;
                case 4:
                    System.out.println("bye bye!! ");
                    break;
                default:
                    System.out.println("this is not an option, please Enter another choice!!");
            }
        }
    }



    public static boolean isAnagram(String s1, String s2) {
        int count=0;
        //changing the letter to lower case that we can compare better.
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        char[] tempstr =new char[s2.length()];//convert the string to char array that we can modify it later on.
        if(s1.length()!=s2.length())
            return false;
        for(int i=0;i<s2.length();i++)//we populate the array of the second string
        {
            tempstr[i]=s2.charAt(i);
        }
        for(int i=0;i<s1.length();i++) {

            for(int j=0;j<s1.length();j++)
            {
                if( s1.charAt(i)==tempstr[j]) {
                    tempstr[j]= '/';
                    count++;//what if the letter is repeated in the word.
                    break;//to make sure that i will not check the same letter twice

                }
            }
        }
        if(count==s1.length())
            return true;
        return false;
    }
}


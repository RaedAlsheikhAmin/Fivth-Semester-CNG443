import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class FIRSTWORKSHEET {
    public static void main(String[] args) {
        //first question;
        System.out.print("s “Welcome to Java”," +
                "“Programming is fine”, “Need to learn mutliple languages”, “Turkish proverb says \n" +
                "“One language one person”");


        //second quesiton;
        /*final double change=0.3937;
        double inches;
        //Double.parseDouble() to change the type to double since we took it as string
        inches = change*Double.parseDouble(args[0]);//Double.parseDouble() is to convert string to double.
        System.out.println(args[0]+" centimetres is " +inches+"inches" );*/

        //third question not fully completed fully
      /*Scanner input= new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        double InvestmentAmount= input.nextDouble();
        System.out.print("Enter monthly interest rate: ");
        double MonthlyInterestRate= input.nextDouble();
        System.out.print("Enter number of years: ");
        int NumOfYears=input.nextInt();

        double FutureInvestmentValue;
        FutureInvestmentValue = InvestmentAmount * Math.pow(1+(MonthlyInterestRate),NumOfYears*12);
        System.out.print("Accumulated value is "+ FutureInvestmentValue );
*/
        //forth question
       /* Scanner input=new Scanner(System.in);
        System.out.print("Enter v and a: ");
        double v=input.nextDouble();
        double a=input.nextDouble();

        double length= Math.pow(v,2)/(2*a);
        System.out.println("The minimum runway length fort his airplane is "+length);
*/
        //fifth question
       /* Scanner input = new Scanner(System.in);

        System.out.print("Enter 9-digit ISBN: ");
        String inputISBN = input.next();

        // Check if the input is a 9-digit number
        while (inputISBN.length() != 9 || !inputISBN.matches("\\d+")) {
            System.out.print("Invalid input. Please enter a 9-digit number: ");
            inputISBN= input.next();
        }
            // Calculate the checksum
            int checksum = calculateISBNChecksum(inputISBN);

            // Display the full 10-digit ISBN
            String fullISBN = inputISBN + (checksum == 10 ? "X" : checksum);
            System.out.println("Full ISBN = " + fullISBN);

        input.close();
    }

    public static int calculateISBNChecksum(String isbn) {
        int checksum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            checksum += digit * (i + 1);
        }
        return checksum % 11;
    }*/

        //sixth question
/*
       Scanner input = new Scanner(System.in);
        int limit;

        do {
            System.out.print("Enter a limit (between 2 and 20): ");
            limit = input.nextInt();

            if (limit < 2 || limit > 20) {
                System.out.println("You have to enter a number between 2 and 20.");
            }
        } while (limit < 2 || limit > 20);

        // Display the pyramid
        for (int i = 1; i <= limit; i++) {
            // Print spaces before numbers
            for (int j = 1; j <= limit - i; j++) {
                System.out.print("  ");
            }

            // Print numbers in decreasing order
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            // Print numbers in increasing order, excluding 1 for the top row
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println(); // Move to the next line
        }*/
        //seventh question

/*
                System.out.println("p     2^p-1");

                for (int p = 2; p < 25; p++) {
                    int mersenneNumber = (int) (Math.pow(2, p) - 1);
                    if (isPrime(mersenneNumber)) {
                        System.out.println(p + "     " + mersenneNumber);
                    }
                }
            }

            public static boolean isPrime(int n) {
                if (n <= 1) {
                    return false;
                }
                if (n <= 3) {
                    return true;
                }
                if (n % 2 == 0 || n % 3 == 0) {
                    return false;
                }

                for (int i = 5; i * i <= n; i += 6) {
                    if (n % i == 0 || n % (i + 2) == 0) {
                        return false;
                    }
                }

                return true;

*/
        //eighth question

               /* Scanner input = new Scanner(System.in);

                System.out.print("Enter the number of students: ");
                int numStudents = input.nextInt();

                String[] studentNames = new String[numStudents];
                int[] studentScores = new int[numStudents];

                // Input student names and scores
                for (int i = 0; i < numStudents; i++) {
                    input.nextLine(); // Consume the newline character
                    System.out.print("Enter the name of student " + (i + 1) + ": ");
                    studentNames[i] = input.nextLine();
                    System.out.print("Enter the score of " + studentNames[i] + ": ");
                    studentScores[i] = input.nextInt();
                }

                // Sort students by scores in increasing order
                for (int i = 0; i < numStudents - 1; i++) {
                    for (int j = i + 1; j < numStudents; j++) {
                        if (studentScores[i] > studentScores[j]) {
                            // Swap scores
                            int tempScore = studentScores[i];
                            studentScores[i] = studentScores[j];
                            studentScores[j] = tempScore;

                            // Swap names
                            String tempName = studentNames[i];
                            studentNames[i] = studentNames[j];
                            studentNames[j] = tempName;
                        }
                    }
                }

                // Print students in increasing order of their scores
                System.out.println("Student names in increasing order of scores:");
                for (int i = 0; i < numStudents; i++) {
                    System.out.println(studentNames[i] + "==   " + studentScores[i]);
                }

                input.close();
                */

        //ninth question
             /*   int[][] board = new int[3][3];//define the size of the array
                Random random = new Random();//random object

                // Fill the TicTacToe board with random 0s and 1s
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        board[i][j] = random.nextInt(2); // 0 or 1
                    }
                }

                // Print the TicTacToe board
                System.out.println("Board is created which is as follows:");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }

                // Find rows, columns, and diagonals with all 0s or all 1s
            System.out.println("Statistics: ");
                checkRows(board);
                checkColumns(board);
                checkDiagonals(board);
            }

            public static void checkRows(int[][] board) {
                for (int i = 0; i < 3; i++) {
                    if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                        if (board[i][0] == 0) {
                            System.out.println("All 0s on row " + (i + 1));
                        } else if (board[i][0] == 1) {
                            System.out.println("All 1s on row " + (i + 1));
                        }
                    }
                }
            }

            public static void checkColumns(int[][] board) {
                for (int j = 0; j < 3; j++) {
                    if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                        if (board[0][j] == 0) {
                            System.out.println("All 0s on column " + (j + 1));
                        } else if (board[0][j] == 1) {
                            System.out.println("All 1s on column " + (j + 1));
                        }
                    }
                }
            }

            public static void checkDiagonals(int[][] board) {
                if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                    if (board[0][0] == 0) {
                        System.out.println("All 0s on the main diagonal");
                    } else if (board[0][0] == 1) {
                        System.out.println("All 1s on the main diagonal");
                    }
                }

                if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                    if (board[0][2] == 0) {
                        System.out.println("All 0s on the other diagonal");
                    } else if (board[0][2] == 1) {
                        System.out.println("All 1s on the other diagonal");
                    }
                }

              */


        //tenth question

        /*Scanner input = new Scanner(System.in);
        System.out.print("please wrtie whatever u want to calculate the lowercase letters: ");
        String word= input.nextLine();//nextline is to read the entire sentence, but next it will read token by token and it will end when it counters a space or tap or newline.
        int lowercase=0;


        for(int i=0; i<word.length();i++)
        {
            char c=word.charAt(i);//to divide the string into characters that we can use character library.
            if(Character.isLowerCase(c))
                lowercase++;
        }
        System.out.print("The sentence you entered has "+lowercase+" lowercase characters");
        */
    }
}





/**
 * Problem Set 4.
 * 
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 * 
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 * 
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();
        
        // comment out or uncomment as needed
        
        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();
                
        in.close();
    }
    
    /*
     * Exercise 1.
     * 
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     * 
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     * 
     * Issues seemingly arise with end results. Solved?
     */
    
    public void sum() {

        boolean initialPrompt = true;
        int lowerBound;
        int upperBound;
        long sum = 0;

        do { 
            if (initialPrompt == true) {
                initialPrompt = false;
                System.out.print("\nLower bound: ");
            } else {
                System.out.print("Lower bound: ");
            }
            lowerBound = in.nextInt();
            in.nextLine();
            System.out.print("Upper bound: ");
            upperBound = in.nextInt();
        } while (lowerBound > upperBound); //asks again if invalid

        while (lowerBound <= upperBound) {
            if (lowerBound % 2 == 1) { //correcting for odd numbers
                lowerBound++;
            }
            sum += lowerBound;
            lowerBound += 2;
        }

        System.out.printf("\n%,d.\n", sum);
    }
    
    /*
     * Exercise 2.
     * S
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     * 
     * Solved!
     * 
     */
    
    public void reverse() {

        boolean initialPrompt = true;
        int userInt;
        String reversedInt = "";


        do {
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nPositive integer: ");
            } else {
                System.out.print("Positive integer: ");
            }
            userInt = in.nextInt();
        } while (userInt <= 0);

        String intString = Integer.toString(userInt);
        int i = intString.length() - 1;

        do {    
            reversedInt += (intString.substring(i) + ", ");
            intString = intString.substring(0, i);
            i--;
        } while (i >= 0);

        reversedInt += "\b\b."; //properly ends output

        System.out.println("\n" + reversedInt);
    }
    
    /*
     * Exercise 3.
     * 
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     * 
     * Solved!
     * 
     */
    
    public void digits() {

        boolean initialPrompt = true;
        int userInt;

        do {
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nPositive integer: ");
            } else {
                System.out.print("Positive integer: ");
            }
            userInt = in.nextInt();
        } while (userInt <= 0);

        int storageInt = userInt;
        long sum = 0;

        do {  
            storageInt = userInt % 10;
            if (storageInt % 2 != 0) { //test for odd number
                sum += storageInt;
            }
            userInt /= 10;
        } while (userInt > 0);

        System.out.println("\n" + sum + ".");

    }
    
    /*
     * Exercise 4.
     * 
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     * 
     * Solved!
     * 
     */
    
    public void average() {

        boolean initialPrompt = true;
        boolean stopCode = false;
        int userInt;
        double intSum = 0;
        int count = 0;

        do {
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nNon-negative integer: ");
            } else {
                System.out.print("Non-negative integer: ");
            }
            userInt = in.nextInt();
            if (userInt < 0) {
                stopCode = true;
            } else {
            intSum += userInt;
            count++;
            }
        } while (!stopCode);

        double average = intSum / count;

        System.out.printf("\n%,.2f.\n", average);
    }
    
    /*
     * Exercise 5.
     * 
     * Prompt the user to enter a non-negative integer. Is this number prime
     * 
     * Zero is NOT prime.
     * 
     * Solved?
     */
    
    public void prime() {

        boolean initialPrompt = true;
        int userInt;
        boolean prime = true;

        do { //non-negative integer prompt
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nNon-negative integer: ");
            } else {
                System.out.print("Non-negative integer: ");
            }
            userInt = in.nextInt();
        } while (userInt < 0);

        for (int i = (userInt - 1); i > 1; i--) { //possible divisible numbers are between userint-1 and 1, exclusive 
            if ((userInt % i) == 0) { //prime check
                prime = false;
            } 
        }

        if (userInt == 0) {
            prime = false;
        }


        if (prime) {
            System.out.println("\nPrime.");
        } else {
            System.out.println("\nNot prime.");
        }

    }
    
    /*
     * Exercise 6.
     * 
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */
    
    public void fibonacci() {

        boolean initialPrompt = true;
        int userInt;

        do {
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nPositive integer: ");
            } else {
                System.out.print("Positive integer: ");
            }
            userInt = in.nextInt();
        } while (userInt < 1 || userInt > 92);

        int sum = 0;

        int firstAdded = 0;
        int secondAdded = 1;

        for (int i = 1; i < userInt; i++) { //offset due to declaration of initial numbers
            sum = firstAdded + secondAdded;
            firstAdded = secondAdded;
            secondAdded = sum;
        }

        if (userInt == 1) {
            sum = secondAdded;
        }

        System.out.println("\n" + sum + ".");
    }
    
    /*
     * Exercise 7.
     * 
     * Prompt the user to enter a positive integer. What are its factors?
     */
    
    public void factors() {

        boolean initialPrompt = true;
        int userInt;
        
        do {
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nPositive integer: ");
            } else {
                System.out.print("Positive integer: ");
            }
            userInt = in.nextInt();
        } while (userInt <= 0);    

        int lowestFactor = 0;
        int highestFactor = 1;
        String factorString = "";

        for (int i = 1; lowestFactor < highestFactor; i++) {
            if (userInt % i == 0) {
                lowestFactor = i;
                highestFactor = userInt / i;
                if (lowestFactor < highestFactor) { //displays integers if they are not already shown
                    factorString += lowestFactor + ", " + highestFactor + ", "; 
                }           
            } 
        }

        if (lowestFactor == highestFactor) { //edge case in case of square number
            factorString += lowestFactor + ".";
        } else { //corrects end formatting
            factorString += "\b\b.";
        }

        System.out.println("\n" + factorString);
    }
    
    /*
     * Exercise 8.
     * 
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */
    
    public void mario() {
        
        boolean initialPrompt = true;
        int height;

        do {
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nHeight: ");
            } else {
                System.out.print("Height: ");
            }
            height = in.nextInt();
        } while (height < 1 || height > 24);

        String pyramid = "";
        int blockCount = 2;
        height += 1;

        while (height >= blockCount) { //checks height while also preserving structure
            pyramid += "\n"; //creates new line
            for (int i = height; i > blockCount; i--) {
                pyramid += " ";
            }
            for (int j = 0; j < blockCount; j++) {
                pyramid += "#";
            }
            blockCount++;
        }

        System.out.println(pyramid);
    }
    
    /*
     * Exercise 9.
     * 
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */
    
    public void luigi() {

        boolean initialPrompt = true;
        int height;

        do {
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nHeight: ");
            } else {
                System.out.print("Height: ");
            }
            height = in.nextInt();
        } while (height < 1 || height > 24);

        String pyramid = "";
        int blockCount = 2;
        height += 1;

        while (height >= blockCount) { //checks height while also preserving structure
            pyramid += "\n"; //creates new line
            for (int i = height; i > blockCount; i--) {
                pyramid += " ";
            }
            for (int j = 0; j < blockCount; j++) {
                pyramid += "#";
            }
            pyramid += "  ";
            for (int j = 0; j < blockCount; j++) {
                pyramid += "#";
            }
            blockCount++;
        }

        System.out.println(pyramid);
    }
    
    /*
     * Exercise 10.
     * 
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */
    
    public void credit() {

        //Initialization / declaration of neccesary variables.
        boolean initialPrompt = true;
        long creditCard;
        int secondDigitsSum = 0;
        int remainingDigitsSum = 0;
        int selectedDigit;
        String cardType = "Invalid."; //Less code to have as default instead of at end of each piece.

        //Prompting user for credit card number.
        do { 
            if (initialPrompt) {
                initialPrompt = false;
                System.out.print("\nNumber: ");
            } else {
                System.out.print("Number: ");
            }
            creditCard = in.nextLong();
        } while (creditCard < 0); //Continuously prompt until positive integer.

        String cardString = Long.toString(creditCard); //String easiest to work with. 

        //Step 1 + 2
        for (int i = cardString.length() - 1; i > 0; i -= 2) {
            selectedDigit = Integer.parseInt(cardString.substring(i - 1, i)) * 2; //Step 1
            if (selectedDigit > 9) { //Check for two-digit number.
                secondDigitsSum += selectedDigit % 10; //Ones digit in two-digit number summation.
                selectedDigit /= 10; //Taking out ones digit.
            }
            secondDigitsSum += selectedDigit; //Summation for digits in Step 2.
        }

        //Step 3
        for (int j = cardString.length(); j > 0; j -= 2) {
            remainingDigitsSum += Integer.parseInt(cardString.substring(j - 1, j));
        }

        int totalSum = secondDigitsSum + remainingDigitsSum; //Step 4

        //Created for final verification.
        String firstTwoDigits = cardString.substring(0, 2);
        int secondDigit = Integer.parseInt(firstTwoDigits.substring(1));

        if (totalSum % 10 == 0) { //Step 5 Verification
            if (firstTwoDigits.equals("34") || firstTwoDigits.equals("37")) { //Amex two digit check
                if (cardString.length() == 15) { 
                    cardType = "Amex.";
                } 
            } else if (firstTwoDigits.startsWith("5") && (1 <= secondDigit && secondDigit <= 5)) {
                if (cardString.length() == 16) {
                    cardType = "Mastercard.";
                } 
            } else if (firstTwoDigits.startsWith("4")) { //Visa two digit check
                if (cardString.length() == 13 || cardString.length() == 16) {
                    cardType = "Visa.";
                } 
            } //All cards passed this point are invalid even with correct Luhn's.
        }

        System.out.println("\n" + cardType); //Display result.
        
    }
}
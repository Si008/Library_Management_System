package Sanjay;


    import java.util.Scanner;

    public class VotingApp {

        // Method that throws an exception if age is invalid
        public static void checkEligibility(int age) throws IllegalArgumentException
        {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative.");
            } else if (age < 18) {
                throw new IllegalArgumentException("You must be at least 18 to vote.");
            } else {
                System.out.println("You are eligible to vote!");
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Enter your age: ");
                int age = scanner.nextInt();

                // Method that may throw an exception
                checkEligibility(age);

            } catch (IllegalArgumentException e) {
                // Handles exceptions thrown by checkEligibility()
                System.out.println("Exception caught: " + e.getMessage());

            } finally {
                // Always executes
                System.out.println("Thank you for using the VotingApp.");
                scanner.close();
            }
        }
    }



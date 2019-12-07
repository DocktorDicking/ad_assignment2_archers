package nl.hva.ict.se.ads.controller;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * MainClass to run test program.
 * Uses a while loop to keep the runtime active.
 * Runs all sorting algorithms sequentially through Runner class.
 *
 * Made this so i do not have to run each algorithm 100 times.
 */
public class Main {
    public static void main(String[] args) {
        //Scanner for user input in console.
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            //input and validation
            System.out.print("Enter number of archers, enter 0 to terminate: ");
            while (!scanner.hasNextInt()) {
                System.out.print("The input is not a integer! Please provide a integer: ");
                scanner.next();
            }
            int numOfArchers = scanner.nextInt();

            System.out.print("How many times do you want me to run?: ");
            while (!scanner.hasNextInt()) {
                System.out.print("The input is not a integer! Please provide a integer: ");
                scanner.next();
            }
            int runTimes = scanner.nextInt();

            boolean average = false;
            if (runTimes > 1) {
                System.out.print("Want me to only show the average of all the runs? (true or false): ");
                while (!scanner.hasNextBoolean()) {
                    System.out.print("The input is not a boolean! Please provide true/false: ");
                    scanner.next();
                }
                average = scanner.nextBoolean();
            }
            System.out.println();

            //Terminate program
            if (numOfArchers == 0) {
                System.out.println("GoodBye!");
                run = false;
            }

            //Run algorithms based on input
            for (int i = 0; i < runTimes; i++) {
                if (!average) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Run: " + (i + 1));
                    Runner.setUp(numOfArchers, false);
                    Runner.sSort();
                    Runner.qSort();
                    Runner.cSort();
                    System.out.println("-----------------------------------------------------");
                } else {
                    Runner.setUp(numOfArchers, true);
                    Runner.sSort();
                    Runner.qSort();
                    Runner.cSort();
                }
            }
            if (average) {
                System.out.println("-----------------------------------------------------");
                Runner.getAverage(runTimes);
                System.out.println("-----------------------------------------------------");
            }
        }
    }
}

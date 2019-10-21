package nl.hva.ict.se.ads.controller;


import java.util.Scanner;

/**
 * MainClass to run test program.
 * Uses a while loop to keep the runtime active.
 * Runs all sorting algorithms sequentially through Runner class.
 */
public class Main {
    public static void main(String[] args) {
        //Scanner for user input in console.
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Enter number of archers: ...\n(0 to quit)");

            //Reads user input value
            int numOfArchers = scanner.nextInt();
            if (numOfArchers == 0) {
                //Quit
                System.out.println("GoodBye!");
                run = false;
            } else {
                if (numOfArchers >= 25000) {
                    //Meme
                    System.out.println("Woah! Much archers, Much Sorting....\n");
                }

                Runner.setUp(numOfArchers);
                Runner.sSort();
                Runner.qSort();
                Runner.cSort();
            }
        }
    }
}

package nl.hva.ict.se.ads.controller;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Enter number of archers: ...\n(0 to quit)");
            int numOfArchers = scanner.nextInt();
            if (numOfArchers == 0) {
                System.out.println("GoodBye!");
                run = false;
            } else {
                if (numOfArchers >= 25000) {
                    System.out.println("Woah! Much archers, Much Sorting....\n");
                }

                Runner.sSort(numOfArchers);
                Runner.qSort(numOfArchers);
                Runner.cSort(numOfArchers);
            }
        }
    }
}

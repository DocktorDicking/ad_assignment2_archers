package nl.hva.ict.se.ads.controller;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of archers: ...");
        int numOfArchers = scanner.nextInt();
        System.out.println("\n");

        Runner.sSort(numOfArchers);
        Runner.qSort(numOfArchers);
        Runner.cSort(numOfArchers);
    }
}

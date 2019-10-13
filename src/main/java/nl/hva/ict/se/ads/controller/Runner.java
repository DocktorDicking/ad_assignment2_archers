package nl.hva.ict.se.ads.controller;

import nl.hva.ict.se.ads.Archer;
import nl.hva.ict.se.ads.ArcherComparator;
import nl.hva.ict.se.ads.ChampionSelector;

import java.util.Comparator;
import java.util.List;

public class Runner {
    private static Comparator<Archer> comparator = new ArcherComparator();
    private static List<Archer> archers;
    private static long startTime;
    private static long stopTime;


    public static void sSort(int numOfArchers) {
        archers = Archer.generateArchers(numOfArchers);
        startTime = System.currentTimeMillis();
        ChampionSelector.selInsSort(archers, comparator);
        stopTime = System.currentTimeMillis();
        outputToConsole(numOfArchers, "SELECTION SORT");
    }

    public static void qSort(int numOfArchers) {
        archers = Archer.generateArchers(numOfArchers);
        startTime = System.currentTimeMillis();
        ChampionSelector.quickSort(archers, comparator);
        stopTime = System.currentTimeMillis();
        outputToConsole(numOfArchers, "QUICK SORT");
    }

    public static void cSort(int numOfArchers) {
        archers = Archer.generateArchers(numOfArchers);
        startTime = System.currentTimeMillis();
        ChampionSelector.quickSort(archers, comparator);
        stopTime = System.currentTimeMillis();
        outputToConsole(numOfArchers, "COLLECTION SORT");
    }

    private static void outputToConsole(int numOfArchers, String sort) {
        long elapsedTime = stopTime - startTime;
        System.out.printf("Sorting algorithm: %s\nNumber of archers: %d\nElapsed time in mili seconds: %d\n\n"
                ,sort,numOfArchers,elapsedTime);
    }
}

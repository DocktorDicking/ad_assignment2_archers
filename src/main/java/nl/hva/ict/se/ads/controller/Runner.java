package nl.hva.ict.se.ads.controller;

import nl.hva.ict.se.ads.Archer;
import nl.hva.ict.se.ads.ArcherComparator;
import nl.hva.ict.se.ads.ChampionSelector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Runner class for running sorting algorithms.
 * Used for testing and benchmarking. Currently only useable in the order: sSort, qSort, cSort.
 * All algorithms use the same list with generated archers. Each method copies the generated archer list (archers)
 */
public class Runner {
    private static Comparator<Archer> comparator = new ArcherComparator();
    private static List<Archer> archers;
    private static long startTime;
    private static long stopTime;

    /**
     * Generates initial list of archers.
     *
     * @param numOfArchers int
     */
    public static void setUp(int numOfArchers) {
        //If archers in initiated, clear data.
        if (archers != null) {
            archers.clear();
        }
        archers = Archer.generateArchers(numOfArchers);
    }

    /**
     * Selection sort
     */
    public static void sSort() {
        List<Archer> myArchers = new ArrayList<>(archers);

        startTime = System.currentTimeMillis();
        ChampionSelector.selInsSort(myArchers, comparator);
        stopTime = System.currentTimeMillis();
        outputToConsole(myArchers.size(), "SELECTION SORT");
    }

    /**
     * Quick sort
     */
    public static void qSort() {
        List<Archer> myArchers = new ArrayList<>(archers);

        startTime = System.currentTimeMillis();
        ChampionSelector.quickSort(myArchers, comparator);
        stopTime = System.currentTimeMillis();
        outputToConsole(myArchers.size(), "QUICK SORT");
    }

    /**
     * Collection sort (Merge sort)
     */
    public static void cSort() {
        List<Archer> myArchers = new ArrayList<>(archers);

        startTime = System.currentTimeMillis();
        ChampionSelector.quickSort(myArchers, comparator);
        stopTime = System.currentTimeMillis();
        outputToConsole(myArchers.size(), "COLLECTION SORT");
    }

    /**
     * Default output to console used by sorting methods to output stats.
     *
     * @param numOfArchers int
     * @param sort String
     */
    private static void outputToConsole(int numOfArchers, String sort) {
        long elapsedTime = stopTime - startTime;
        System.out.printf("Sorting algorithm: %s\nNumber of archers: %d\nElapsed time in mili seconds: %d\n\n"
                ,sort,numOfArchers,elapsedTime);
    }
}

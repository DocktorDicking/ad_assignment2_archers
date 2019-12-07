package nl.hva.ict.se.ads.controller;

import nl.hva.ict.se.ads.Archer;
import nl.hva.ict.se.ads.ArcherComparator;
import nl.hva.ict.se.ads.ChampionSelector;

import java.util.*;

/**
 * Runner class for running sorting algorithms.
 * Used for testing and benchmarking. Currently only useable in the order: sSort, qSort, cSort.
 * All algorithms use the same list with generated archers. Each method copies the generated archer list (archers)
 */
public class Runner {
    private static Comparator<Archer> comparator = new ArcherComparator();
    private static List<Archer> archers = new ArrayList<>();
    private static HashMap<String, Long> times = new HashMap<>();
    private static boolean showOnlyAverage;
    private static long startTime;
    private static long stopTime;

    /**
     * Generates initial list of archers.
     *
     * @param numOfArchers int
     */
    public static void setUp(int numOfArchers, boolean average) {
        //If archers is initiated, clear data.
        if (archers.size() > 0) {
            archers.clear();
        }
        archers = Archer.generateArchers(numOfArchers);
        showOnlyAverage = average;
    }

    /**
     * Selection sort
     */
    public static void sSort() {
        List<Archer> myArchers = new ArrayList<>(archers);

        startTime = getSystemMicroTime();
        ChampionSelector.selInsSort(myArchers, comparator);
        stopTime = getSystemMicroTime();
        long elapsedTime = stopTime - startTime;

        if (showOnlyAverage) {
            registerTime("SELECTION SORT", elapsedTime);
        } else {
            outputToConsole(myArchers.size(), "SELECTION SORT", elapsedTime);
        }
    }

    /**
     * Quick sort
     */
    public static void qSort() {
        List<Archer> myArchers = new ArrayList<>(archers);

        startTime = getSystemMicroTime();
        ChampionSelector.quickSort(myArchers, 0, (myArchers.size() - 1), comparator);
        stopTime = getSystemMicroTime();
        long elapsedTime = stopTime - startTime;

        if (showOnlyAverage) {
            registerTime("QUICK SORT", elapsedTime);
        } else {
            outputToConsole(myArchers.size(), "QUICK SORT", elapsedTime);
        }
    }

    /**
     * Collection sort
     */
    public static void cSort() {
        List<Archer> myArchers = new ArrayList<>(archers);

        startTime = getSystemMicroTime();
        ChampionSelector.collectionSort(myArchers, comparator);
        stopTime = getSystemMicroTime();
        long elapsedTime = stopTime - startTime;

        if (showOnlyAverage) {
            registerTime("COLLECTION SORT", elapsedTime);
        } else {
            outputToConsole(myArchers.size(), "COLLECTION SORT", elapsedTime);
        }
    }

    /**
     * Calculates microTime based on system nanoTime.
     * @return microTime
     */
    private static long getSystemMicroTime() {
        //nano second divided with 1000 equals microsecond.
        return (System.nanoTime() / 1000);
    }

    /**
     * Registers time for each algorithm, for each run.
     * Saved times are used to calc average.
     * @param name String
     * @param elapsedTime long
     */
    private static void registerTime(String name, long elapsedTime) {
        if (times.containsKey(name)) {
            times.put(name, (times.get(name) + elapsedTime));
        } else {
            times.put(name, elapsedTime);
        }
    }

    /**
     * Prints the average of all algorithms during n amount of runs.
     * @param runTimes int
     */
    public static void getAverage(int runTimes) {
        for (Map.Entry<String, Long> time : times.entrySet()) {
            long average = (time.getValue() / runTimes);
            System.out.printf("Sorting algorithm: %s\nNumber of archers: %d\nElapsed time in micro seconds: %d\n"
                    , time.getKey(), archers.size(), average);
        }
    }

    /**
     * Default output to console used by sorting methods to output stats.
     *
     * @param numOfArchers int
     * @param sort         String
     */
    private static void outputToConsole(int numOfArchers, String sort, long elapsedTime) {
        System.out.printf("Sorting algorithm: %s\nNumber of archers: %d\nElapsed time in micro seconds: %d\n"
                , sort, numOfArchers, elapsedTime);
    }
}

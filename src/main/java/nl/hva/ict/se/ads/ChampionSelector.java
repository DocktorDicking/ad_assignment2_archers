package nl.hva.ict.se.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Given a list of Archer's this class can be used to sort the list using one of three sorting algorithms.
 */
public class ChampionSelector {

    /**
     * This method uses either selection sort or insertion sort for sorting the archers.
     *
     * @param archers List
     * @param scoringScheme Comparator
     * @return List
     */
    public static List<Archer> selInsSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        int n = archers.size();

        //One by one, move pointer in subarray
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            //Finding minimum element in unsorted array
            for (int j = i + 1; j < n; j++) {
                if (scoringScheme.compare(archers.get(j), archers.get(minIndex)) > 0) {
                    minIndex = j;
                }
            }
            //Swap found minimum with first element
            Archer temp = archers.get(minIndex);
            archers.set(minIndex, archers.get(i));
            archers.set(i, temp);
        }
        return archers;
    }

    /**
     * This method uses quick sort for sorting the archers.
     *
     * @param archers List
     * @param scoringScheme Comparator
     * @return List
     */
    public static List<Archer> quickSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        sort(archers, 0, archers.size() - 1, scoringScheme);
        return archers;
    }

    /**
     * Sorting algorithm used by QuickSort method.
     *
     * @param archers List
     * @param low int
     * @param high int
     * @param scoringScheme Comparator
     */
    private static void sort(List<Archer> archers, int low, int high, Comparator<Archer> scoringScheme) {
        int i = low;
        int j = high;

        Archer pivot = archers.get(low + (high - low) / 2);
        while (i <= j) {
            //Go through list and look for values bigger/smaller than pivot.
            while (scoringScheme.compare(archers.get(i), pivot) > 0) {
                i++;
            }
            while (scoringScheme.compare(archers.get(j), pivot) < 0) {
                j--;
            }

            //Swap elements
            if (i <= j) {
                Archer temp = archers.get(i);
                archers.set(i, archers.get(j));
                archers.set(j, temp);

                i++;
                j--;
            }
        }

        //Cut list in smaller pieces and sort agian.
        if (low < j) {
            sort(archers, low, j, scoringScheme);
        }
        if (i < high) {
            sort(archers, i, high, scoringScheme);
        }
    }


    /**
     * This method uses the Java collections sort algorithm for sorting the archers.
     *
     * @param archers List
     * @param scoringScheme Comparator
     * @return List
     */
    public static List<Archer> collectionSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        Collections.sort(archers, scoringScheme);
        Collections.reverse(archers);
        return archers;

    }

    /**
     * This method uses quick sort for sorting the archers in such a way that it is able to cope with an Iterator.
     *
     * <b>THIS METHOD IS OPTIONAL</b>
     */
    public static Iterator<Archer> quickSort(Iterator<Archer> archers, Comparator<Archer> scoringScheme) {
        return null;
    }

}

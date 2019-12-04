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
    public static void selInsSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
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
    }

    public static void quickSort(List<Archer> archers,int start, int end, Comparator<Archer> comparator) {
        int partition = partition(archers, start, end, comparator);
            if ((partition - 1 ) > start) {
                quickSort(archers, start, partition - 1, comparator);
            }

            if ((partition + 1) < end) {
                quickSort(archers, partition + 1, end, comparator);
            }
        }

    private static int partition(List<Archer> archers, int start, int end, Comparator<Archer> comparator) {
        Archer pivot = archers.get(end);

        for(int index = start; index < end; index++){
            if(comparator.compare(archers.get(index), pivot) > 0){
                Archer temp = archers.get(start);
                archers.set(start, archers.get(index));
                archers.set(index, temp);
                start++;
            }
        }

        //Swap pivot to start index values left of start index are considered sorted or partitioned.
        Archer temp = archers.get(start);
        if (temp != pivot) { //Avoids swap when elements are the same.
            archers.set(start, pivot);
            archers.set(end, temp);
        }
        return start;
    }

    /**
     * This method uses the Java collections sort algorithm for sorting the archers.
     *
     * @param archers List
     * @param comparator Comparator
     * @return List
     */
    public static List<Archer> collectionSort(List<Archer> archers, Comparator<Archer> comparator) {
        Collections.sort(archers, comparator);
        Collections.reverse(archers);
        return archers;

    }

//    /**
//     * Sorting algorithm used by QuickSort method.
//     *
//     * @param archers List
//     * @param low int
//     * @param high int
//     * @param scoringScheme Comparator
//     */
//    private static void sort(List<Archer> archers, int low, int high, Comparator<Archer> scoringScheme) {
//        //TODO: Not maintainable, do not do this in "RL".
//        //TODO: Make a short report on how this algorithm works.
//        int i = low;
//        int j = high;
//
//        Archer pivot = archers.get(low + (high - low) / 2);
//        while (i <= j) {
//            //Go through list and look for values bigger/smaller than pivot.
//            while (scoringScheme.compare(archers.get(i), pivot) > 0) {
//                i++;
//            }
//            while (scoringScheme.compare(archers.get(j), pivot) < 0) {
//                j--;
//            }
//
//            //Swap elements
//            if (i <= j) {
//                Archer temp = archers.get(i);
//                archers.set(i, archers.get(j));
//                archers.set(j, temp);
//
//                i++;
//                j--;
//            }
//        }
//
//        //Cut list in smaller pieces and sort agian.
//        if (low < j) {
//            sort(archers, low, j, scoringScheme);
//        }
//        if (i < high) {
//            sort(archers, i, high, scoringScheme);
//        }
//    }

    /**
     * This method uses quick sort for sorting the archers.
     *
     * @param archers List
     * @param comparator Comparator
     * @return List
     */
//    public static List<Archer> quickSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
//        sort(archers, 0, archers.size() - 1, scoringScheme);
//        return archers;
//    }
}

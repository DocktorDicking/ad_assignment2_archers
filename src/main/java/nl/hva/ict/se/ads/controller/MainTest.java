package nl.hva.ict.se.ads.controller;


import nl.hva.ict.se.ads.Archer;
import nl.hva.ict.se.ads.ArcherComparator;
import nl.hva.ict.se.ads.ChampionSelector;

import java.util.Comparator;
import java.util.List;

/**
 * MainClass to run test program.
 * Uses a while loop to keep the runtime active.
 * Runs all sorting algorithms sequentially through Runner class.
 */
public class MainTest {
    public static void main(String[] args) {
        Comparator<Archer> comparator = new ArcherComparator();
        List<Archer> archers = Archer.generateArchers(10);
        System.out.println(archers.toString());
        ChampionSelector.quickSort(archers, 0, (archers.size() - 1), comparator);
        System.out.println(archers.toString());
    }
}

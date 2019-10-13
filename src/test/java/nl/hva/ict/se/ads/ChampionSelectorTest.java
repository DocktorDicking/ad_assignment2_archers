package nl.hva.ict.se.ads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChampionSelectorTest {
    private Comparator<Archer> comparator;

    @BeforeEach
    public void createComparator() {
        comparator = new ArcherComparator();
    }

    /**
     * Test for selectionSort.
     */
    @Test
    public void selInsSortAndCollectionSortResultInSameOrder() {
        List<Archer> archersForSelIns = Archer.generateArchers(23);
        List<Archer> archersForCollection = new ArrayList<>(archersForSelIns);

        ChampionSelector.selInsSort(archersForSelIns, comparator);
        ChampionSelector.collectionSort(archersForCollection, comparator);

        assertEquals(archersForCollection, archersForSelIns);
    }

    /**
     * Test to test quicksort. This test checks all sorted archer by testing the edge cases.
     * This test also validates the comparator.
     */
    @Test
    public void quickSortTest() {
        List<Archer> archers = Archer.generateArchers(25);
        ChampionSelector.quickSort(archers, comparator);
        Archer current;
        Archer next;

        for (int i = 0; i < archers.size() - 1; i++) {
            current = archers.get(i);
            next = archers.get(i + 1);
            if (current.getTotalScore() == next.getTotalScore()) {
                if (current.getWeightedScore() == next.getWeightedScore()) {
                    assertTrue(current.getId() > next.getId());
                } else {
                    assertTrue(current.getWeightedScore() > next.getWeightedScore());
                }
            } else {
                assertTrue(current.getTotalScore() > next.getTotalScore());
            }
        }
    }
}
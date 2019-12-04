package nl.hva.ict.se.ads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Place all your own tests for ChampionSelector in this class. Tests in any other class will be ignored!
 */
public class ExtendedChampionSelectorTest {
    private Comparator<Archer> comparator;

    @BeforeEach
    public void createComparator() {
        comparator = new ArcherComparator();
    }

    /**
     * Test to test quicksort. This test checks all sorted archer by testing the edge cases.
     * This test also validates the comparator.
     */
    @Test
    public void quickSortTest() {
        List<Archer> archers = Archer.generateArchers(155);
        ChampionSelector.quickSort(archers, 0, (archers.size() - 1), comparator);
        Archer current;
        Archer next;

        for (int i = 0; i < (archers.size() - 1); i++) {
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

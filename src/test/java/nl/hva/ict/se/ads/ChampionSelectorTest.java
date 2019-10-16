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
}
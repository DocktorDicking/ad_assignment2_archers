package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;
//import main.java.nl.hva.ict.se.ads.Archer;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArcherTest {

    @Test
    public void generateArchers() {
        List<Archer> archers = Archer.generateArchers(5);
        assertEquals(5, archers.size());
        for (Archer archer : archers) {
            assertNotNull(archer);
            assertTrue(archer.getId() > 0);
            assertTrue(archer.getTotalScore() > 0);
            assertNotNull(archer.getFirstName());
            assertNotNull(archer.getLastName());
        }
    }

    @Test
    public void archerCustomIdsIncreaseCorrectly() {
        int customId = 100;
        List<Archer> archers = Archer.generateArchers(3, customId);
        assertTrue(archers.get(1).getId() == archers.get(0).getId()+ 1);
        assertTrue(archers.get(2).getId() == archers.get(1).getId()+ 1);
    }

    @Test
    public void archerIdsIncreaseCorrectly() {
        List<Archer> archers = Archer.generateArchers(3);
        assertTrue(archers.get(1).getId() == archers.get(0).getId()+ 1);
        assertTrue(archers.get(2).getId() == archers.get(1).getId()+ 1);
    }

    @Test
    public void iteratorImplementedCorrectlyIfImplemented() {
        long nrOfArchers = 10;
        Iterator<Archer> archerIterator = Archer.generateArchers(nrOfArchers);
        if (archerIterator != null) {
            Archer firstArcher = archerIterator.next();
            Archer secondArcher = Archer.generateArchers(1).get(0);
            Archer thirdArcher = archerIterator.next();

            assertTrue(secondArcher.getId() == firstArcher.getId() + 1);
            assertTrue(thirdArcher.getId() == secondArcher.getId() + 1);

            int remainder = 0;
            while (archerIterator.hasNext()) {
                archerIterator.next();
                remainder++;
            }
            assertEquals(8, remainder);
        } else {
            fail("Iterator == null.");
        }
    }

}
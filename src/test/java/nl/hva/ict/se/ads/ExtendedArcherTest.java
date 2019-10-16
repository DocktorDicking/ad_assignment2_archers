package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Place all your own tests for Archer in this class. Tests in any other class will be ignored!
 */
public class ExtendedArcherTest {

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
}

package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArcherTest {

    @Test
    public void archerIdsIncreaseCorrectly() {
        List<Archer> archers = Archer.generateArchers(3);
        assertEquals(archers.get(1).getId(), archers.get(0).getId() + 1);
        assertEquals(archers.get(2).getId(), archers.get(1).getId() + 1);
    }
}
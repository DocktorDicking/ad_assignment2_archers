package nl.hva.ict.se.ads;

/**
 * This is a class to store archer 'settings'.
 * Made because we needed a place to save the current archer id (to use when creating a new archer).
 *
 * Did not want to save this in Archer class since all archers would have their own instance of these variables, these
 * variables are shard across all Archers.
 */
class ArcherSetting {
    static final int MAX_ARROWS = 3;
    static final int MAX_ROUNDS = 10;
    static final int MAX_SCORE = 11; //maximum score is below 11 (10)
    private static int id = 135787;

    /**
     * Returns a unsigned id to be assigned to a new archer.
     * @return id int
     */
    static int getId() {
        incrementId();
        return id;
    }

    /**
     * Increments the id.
     */
    private static void incrementId() {
        id++;
    }
}

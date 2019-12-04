package nl.hva.ict.se.ads;

import java.util.*;

/**
 * Holds the name, archer-id and the points scored for 30 arrows.
 * <p>
 * Archers MUST be created by using one of the generator methods. That is way the constructor is private and should stay
 * private. You are also not allowed to add any constructor with an access modifier other then private unless it is for
 * testing purposes in which case the reason why you need that constructor must be contained in a very clear manner
 * in your report.
 */
public class Archer {
    private final int id;
    private int totalScore = 0;

    private String firstName;
    private String lastName;

    private Integer weightedScore = 0;
    private List<Integer> points = new LinkedList<>();
    private static Random randomizer = new Random();

    /**
     * Constructs a new instance of bowman and assigns a unique ID to the instance. The ID is not allowed to ever
     * change during the lifetime of the instance! For this you need to use the correct Java keyword.Each new instance
     * is a assigned a number that is 1 higher than the last one assigned. The first instance created should have
     * ID 135788;
     *
     * @param firstName the archers first name.
     * @param lastName  the archers surname.
     */
    private Archer(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * This methods creates a List of archers. Supply the id of the last generated archer.
     *
     * @param nrOfArchers the number of archers in the list.
     * @return List
     */
    public static List<Archer> generateArchers(int nrOfArchers) {
        List<Archer> archers = new ArrayList<>(nrOfArchers);
        for (int i = 0; i < nrOfArchers; i++) {
            Archer archer = new Archer(Names.nextFirstName(), Names.nextSurname(), ArcherSetting.getId());
            letArcherShoot(archer, nrOfArchers % 100 == 0);
            calculateWeightedScore(archer);
            archers.add(archer);
        }
        return archers;
    }

    /**
     * Let's an archer shoot all arrows for all rounds.
     *
     * @param archer Archer
     * @param isBeginner boolean
     */
    private static void letArcherShoot(Archer archer, boolean isBeginner) {
        for (int round = 0; round < ArcherSetting.MAX_ROUNDS; round++) {
            List<Integer> points = shootArrows(isBeginner ? 0 : 1);
            archer.addAllPoints(points);
            for (int point : points) {
                archer.setTotalScore((archer.getTotalScore() + point));
            }
        }
    }

    /**
     * pew pew pew!
     * shoots 3 arrows.
     * @param min int
     * @return int[]
     */
    private static List<Integer> shootArrows(int min) {
        List<Integer> points = new LinkedList<>();
        for (int arrow = 0; arrow < ArcherSetting.MAX_ARROWS; arrow++) {
            points.add(shoot(min));
        }
        return points;
    }

    /**
     * pew!
     * shoots one arrow.
     * @param min int
     * @return int
     */
    private static int shoot(int min) {
        return Math.max(min, randomizer.nextInt(ArcherSetting.MAX_SCORE));
    }

    /**
     * Calculates the weighted score using the points the archer scored.
     * First the points get sorted into a hashMap. The key is the score and the value holds the amount of
     * times this score has been scored.
     *
     * HashMap key: score value: # arrows
     * @param archer Archer
     */
    private static void calculateWeightedScore(Archer archer) { //TODO: add to report
        HashMap<Integer, Integer> sortedPoints = new HashMap<>();
        List<Integer> points = archer.getPoints();

        //Sort points on how many times a target is hit. (3 arrows hit 0, then key = 0 and value = 3)
        for (int point : points) {
            Integer key = point;
            if (!sortedPoints.containsKey(key)) { //if key does not exist: shots = 1
                sortedPoints.put(key,1);
            } else {
                sortedPoints.put(key, (sortedPoints.get(key) + 1)); //if key exist: shots = shots + 1
            }
        }
        //Calculate the actual weighted score.
        int weightedScore = 0;
        for (Integer key : sortedPoints.keySet()) { //Loop over keySet (possible scores)
            if (key == 0) {
                weightedScore -= sortedPoints.get(key) * 7; //score 0 = -7 weightedScore
            } else {
                int multiplier = key + 1;
                weightedScore += sortedPoints.get(key) * multiplier; //score > 0 = timesShot * multiplier
            }
        }
        archer.setWeightedScore(weightedScore);
    }

    /**
     * Returns id, score and weighted score.
     *
     * @return String
     */
    public String toString() {
        String output = String.format("%d (%d/%d)%n", this.getId(), this.getTotalScore(), this.getWeightedScore());
        return output;
    }

    // Getters & Setters
    public int getTotalScore() {
        return this.totalScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setWeightedScore(Integer weightedScore) {
        this.weightedScore = weightedScore;
    }

    public int getWeightedScore() {
        return this.weightedScore;
    }

    public int getId() {
        return id;
    }

    private void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    private void addAllPoints(List<Integer> points) {
        this.points.addAll(points);
    }

    private List<Integer> getPoints() {
        return this.points;
    }
}

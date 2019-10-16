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
    public static int MAX_ARROWS = 3;
    public static int MAX_ROUNDS = 10;
    private int totalScore = 0;

    private String firstName;
    private String lastName;

    private Integer weightedScore;
    private HashMap<Integer, int[]> points = new HashMap<>();
    private HashMap<Integer, Integer> weightedScores = new HashMap<>();
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
     * Registers the point for each of the three arrows that have been shot during a round. The <code>points</code>
     * parameter should hold the three points, one per arrow.
     *
     * @param round  int
     * @param points list
     */
    public void registerScoreForRound(int round, int[] points) {
        for (int point : points) {
            this.totalScore += point;
        }
        this.points.put(round, points);
    }

    /**
     * This methods creates a List of archers. Supply the id of the last generated archer.
     *
     * @param nrOfArchers the number of archers in the list.
     * @return List
     */
    public static List<Archer> generateArchers(int nrOfArchers, int startId) {
        List<Archer> archers = new ArrayList<>(nrOfArchers);
        final int DEFAULT_START_ID = 135788;
        if (startId < DEFAULT_START_ID) {
            startId = DEFAULT_START_ID;
        }
        for (int i = 0; i < nrOfArchers; i++) {
            startId++;
            Archer archer = new Archer(Names.nextFirstName(), Names.nextSurname(), startId);
            letArcherShoot(archer, nrOfArchers % 100 == 0);
            calculateWeightedScore(archer);
            archers.add(archer);
        }
        return archers;
    }

    /**
     * Method overloading. When there is no list of archers yet use this method.
     *
     * @param nrOfArchers int
     * @return List
     */
    public static List<Archer> generateArchers(int nrOfArchers) {
        return generateArchers(nrOfArchers, 0);
    }

    /**
     * This methods creates a Iterator that can be used to generate all the required archers. If you implement this
     * method it is only allowed to create an instance of Archer inside the next() method!
     *
     * <b>THIS METHODS IS OPTIONAL</b>
     *
     * @param nrOfArchers the number of archers the Iterator will create.
     * @return
     */
    public static Iterator<Archer> generateArchers(long nrOfArchers) {
        return null;
    }

    public int getId() {
        return id;
    }

    private static void letArcherShoot(Archer archer, boolean isBeginner) {
        for (int round = 0; round < MAX_ROUNDS; round++) {
            int [] points = shootArrows(isBeginner ? 0 : 1);
            archer.registerScoreForRound(round, points);
            archer.setWeightedScoreArray(points);
        }
    }

    private static int[] shootArrows(int min) {
        int[] points = new int[MAX_ARROWS];
        for (int arrow = 0; arrow < MAX_ARROWS; arrow++) {
            points[arrow] = shoot(min);
        }
        return points;
    }

    private static int shoot(int min) {
        return Math.max(min, randomizer.nextInt(11));
    }

    /**
     *
     * @param points
     */
    private void setWeightedScoreArray(int[] points) {
        for (int point : points) {
            Integer count = this.weightedScores.get(point);

            if (count == null) {
                this.weightedScores.put(point, 1);
            } else {
                this.weightedScores.put(point, count + 1);
            }
        }
    }

    /**
     *
     * @param archer
     */
    private static void calculateWeightedScore(Archer archer) { //TODO: Check this methods calculation with the assignment.
        HashMap<Integer, Integer> weightedScores = archer.getWeightedScores();
        int weightedScore = 0;

        for (int i = 0; i < 11; i++) { //TODO: Magic number
            Integer score = weightedScores.get(i);
            if(score != null){
                int multiplier = i + 1;
                if(i == 0) {
                    weightedScore -= score * 7;
                } else {
                    weightedScore += score * multiplier;
                }
            }
        }
        archer.setWeightedScore(weightedScore);
    }

    private HashMap<Integer, Integer> getWeightedScores()
    {
        return this.weightedScores;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWeightedScore(Integer weightedScore) {
        this.weightedScore = weightedScore;
    }

    public int getWeightedScore() {
        return this.weightedScore;
    }
}

package nl.hva.ict.se.ads;

        import java.util.Comparator;

public class ArcherComparator implements Comparator<Archer> {

    /**
     * Compares archers by the rules in the assignment.
     * When return value is negative, archerTwo haves a higher score.
     * When return value is positive, achterOne haves a higher score.
     *
     * @param ArcherOne Archer
     * @param ArcherTwo Archer
     * @return int
     */
    @Override
    public int compare(Archer ArcherOne, Archer ArcherTwo) { //TODO: add to report.
        int scoreOne = ArcherOne.getTotalScore();
        int scoreTwo = ArcherTwo.getTotalScore();

        if (scoreOne == scoreTwo) { //If scores are equal, check weighted score
            scoreOne = ArcherOne.getWeightedScore();
            scoreTwo = ArcherTwo.getWeightedScore();

            if (scoreOne == scoreTwo) { //If weighted scores are equal, check id to see which archer signed up first.
                return ArcherOne.getId() - ArcherTwo.getId();
            }
            return scoreOne - scoreTwo;
        }
        return scoreOne - scoreTwo;
    }
}

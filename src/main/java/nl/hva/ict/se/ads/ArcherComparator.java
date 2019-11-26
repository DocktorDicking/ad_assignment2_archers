package nl.hva.ict.se.ads;

        import java.util.Comparator;

public class ArcherComparator implements Comparator<Archer> {

    /**
     * Compares archers by the rules in the assignment.
     *
     * @param ArcherOne Archer
     * @param ArcherTwo Archer
     * @return int
     */
    @Override
    public int compare(Archer ArcherOne, Archer ArcherTwo) {
        int scoreOne = ArcherOne.getTotalScore();
        int scoreTwo = ArcherTwo.getTotalScore();

        if (scoreOne == scoreTwo) {
            scoreOne = ArcherOne.getWeightedScore();
            scoreTwo = ArcherTwo.getWeightedScore();

            if (scoreOne == scoreTwo) {
                return ArcherOne.getId() - ArcherTwo.getId();
            }
            return scoreOne - scoreTwo;
        }
        return scoreOne - scoreTwo;
    }
}

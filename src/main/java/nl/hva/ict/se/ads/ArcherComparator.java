package nl.hva.ict.se.ads;

        import java.util.Comparator;

public class ArcherComparator implements Comparator<Archer> {

    @Override
    public int compare(Archer one, Archer two) {
        if (one.getTotalScore() == two.getTotalScore()) {
            if (one.getWeightedScore() == two.getWeightedScore()) {
                return one.getId() - two.getId();
            }
            return one.getWeightedScore() - two.getWeightedScore();
        }
        return one.getTotalScore() - two.getTotalScore();
    }
}

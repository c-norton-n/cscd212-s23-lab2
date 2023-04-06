package cscd212comparators.lab2;

import java.util.Comparator;
import cscd212classes.lab2.Television;

public class TelevisionResolutionMakeDescendingComparator
    implements Comparator<Television> {
    public int compare(final Television t1, final Television t2) {
        if (t1.getResolution() == t2.getResolution()) {
            return t1.getMake().compareTo(t2.getMake());
        }
        return t1.getResolution() - t2.getResolution();
    }
}

package elementFind.receiver;

import elementFind.periodic.PeriodicElement;
import elementFind.periodic.Phase;

import java.util.ArrayList;
import java.util.List;

public class PhaseFinder implements IPeriodicElementFinder {
    private Phase phase;

    public PhaseFinder(String input) {
        this.phase = Phase.names(input);
    }

    @Override
    public List<PeriodicElement> find(List<PeriodicElement> elements){
        List<PeriodicElement> foundElements = new ArrayList<>();

        for (PeriodicElement element : elements) {
            if (element.getPhase().equals(phase)) {
                foundElements.add(element);
            }
        }

        return foundElements;
    }
}

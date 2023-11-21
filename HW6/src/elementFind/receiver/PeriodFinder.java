package elementFind.receiver;

import elementFind.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.List;

public class PeriodFinder implements IPeriodicElementFinder {
    private int period;

    public PeriodFinder(int period) {
        this.period = period;
    }

    @Override
    public List<PeriodicElement> find(List<PeriodicElement> elements){
        List<PeriodicElement> foundElements = new ArrayList<>();

        for (PeriodicElement element : elements) {
            if (element.getPeriod() == period) {
                foundElements.add(element);
            }
        }

        return foundElements;

    }
}

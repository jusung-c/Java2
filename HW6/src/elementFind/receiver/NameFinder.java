package elementFind.receiver;
import elementFind.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameFinder implements IPeriodicElementFinder {
    private String[] names;

    public NameFinder(String[] names) {
        this.names = names;
    }

    @Override
    public List<PeriodicElement> find(List<PeriodicElement> elements){
        List<PeriodicElement> foundElements = new ArrayList<>();

        for (PeriodicElement element : elements) {
            if (Arrays.stream(names).anyMatch(s -> s.equals(element.getName()))) {
                foundElements.add(element);
            }
        }

        return foundElements;
    }
}

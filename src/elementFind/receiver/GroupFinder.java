package elementFind.receiver;


import elementFind.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.List;

public class GroupFinder implements IPeriodicElementFinder {
    private int group;

    public GroupFinder(int group) {
        this.group = group;
    }

    @Override
    public List<PeriodicElement> find(List<PeriodicElement> elements){
        List<PeriodicElement> foundElements = new ArrayList<>();

        // null인 경우
        if (group == 0) {
            for (PeriodicElement element : elements) {
                if (element.getGroup() >= 1 && element.getGroup() <= 18) {
                    continue;
                } else {
                    foundElements.add(element);
                }
            }
        } else {
            for (PeriodicElement element : elements) {
                if (element.getGroup() == group) {
                    foundElements.add(element);
                }
            }
        }

        return foundElements;
    }
}

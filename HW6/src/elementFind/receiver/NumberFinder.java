package elementFind.receiver;

import elementFind.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberFinder implements IPeriodicElementFinder {
    private int[] numbers;

    public NumberFinder(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<PeriodicElement> find(List<PeriodicElement> elements){
        List<PeriodicElement> foundElements = new ArrayList<>();

        for (PeriodicElement element : elements) {
            if (Arrays.stream(numbers).anyMatch(n -> n == element.getNumber())) {
                foundElements.add(element);
            }
        }

        return foundElements;
    }
}

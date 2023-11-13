package elementFind.receiver;


import elementFind.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.List;

public class WeightFinder implements IPeriodicElementFinder {
    private double[] weights;

    public WeightFinder(double[] weights) {
        this.weights = weights;
    }

    @Override
    public List<PeriodicElement> find(List<PeriodicElement> elements){
        List<PeriodicElement> foundElements = new ArrayList<>();

        for (PeriodicElement element : elements) {
            // 주어진 weights 범위 안의 weight를 가진 값 조회
            if (element.getWeight() >= weights[0] && element.getWeight() <= weights[1]) {
                foundElements.add(element);
            }
        }

        return foundElements;
    }
}

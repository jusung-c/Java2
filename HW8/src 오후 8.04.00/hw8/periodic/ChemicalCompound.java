package hw8.periodic;

import hw8.periodic.PeriodicElement;
import hw8.periodic.Phase;

import java.util.*;

// 화합물
public class ChemicalCompound {
    private String name;
    private String symbol;
    private List<CompoundElementInfo> compounds = new ArrayList<>();
    private Phase phase;

    // 생성자
    public ChemicalCompound(String name, String symbol, List<CompoundElementInfo> compounds, Phase phase) {
        this.name = name;
        this.symbol = symbol;
        this.compounds = compounds;
        this.phase = phase;
    }

    // calculate molecular weight from atomic weight * count
    public double getWeight() {
        double weight = 0.0;

        // List를 순환하면서 각 성분의 무게 x 개수를 더해준다.
        for (CompoundElementInfo compoundElementInfo : this.compounds) {
            PeriodicElement element = compoundElementInfo.getElement();
            int count = compoundElementInfo.getCount();
            weight += element.getWeight() * count;
        }

        return weight;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public List<CompoundElementInfo> getCompounds() {
        return compounds;
    }

    public Phase getPhase() {
        return phase;
    }

    @Override
    public String toString() {
        return "ChemicalCompound{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", compounds=" + compounds +
                ", phase=" + phase +
                '}';
    }
}

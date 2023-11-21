package elementFind.receiver;


import elementFind.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymbolFinder implements IPeriodicElementFinder {
    private String[] symbols;

    public SymbolFinder(String[] symbols) {
        this.symbols = symbols;
    }

    @Override
    public List<PeriodicElement> find(List<PeriodicElement> elements){
        List<PeriodicElement> foundElements = new ArrayList<>();

        for (PeriodicElement element : elements) {
            if (Arrays.stream(symbols).anyMatch(s -> s.equals(element.getSymbol()))) {
                foundElements.add(element);
            }
        }

        return foundElements;
    }
}

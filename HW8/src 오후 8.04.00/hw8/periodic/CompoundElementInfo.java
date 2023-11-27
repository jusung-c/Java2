package hw8.periodic;

public class CompoundElementInfo {
    private PeriodicElement element;
    private int count;

    public CompoundElementInfo(PeriodicElement element, int count) {
        this.element = element;
        this.count = count;
    }

    public PeriodicElement getElement() {
        return element;
    }

    public int getCount() {
        return count;
    }

    public void setElement(PeriodicElement element) {
        this.element = element;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CompoundElementInfo{" +
                "element=" + element +
                ", count=" + count +
                '}';
    }
}

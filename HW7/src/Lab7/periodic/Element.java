package Lab7.periodic;


public class Element {
    private int number;
    private String name;
    private String symbol;
    private double weight;

    public Element(int number, String name, String symbol, double weight) {
        this.number = number;
        this.name = name;
        this.symbol = symbol;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return number + "," + name + "," + symbol + "," + weight;
    }
}

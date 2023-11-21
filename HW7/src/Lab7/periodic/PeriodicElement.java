package Lab7.periodic;


public class PeriodicElement {
	protected int number;
	protected String symbol;
	protected String name;
	protected double weight;
	protected int period;
	protected int group;
	protected Phase phase;
	protected String type;

	// constructor
	public PeriodicElement(int number, String name, String symbol, double weight, int period, int group, Phase phase,
			String type) {
		this.number = number;
		this.name = name;
		this.symbol = symbol;
		this.weight = weight;
		this.period = period;
		this.group = group;
		this.phase = phase;
		this.type = type;
	}

	// getter/setter
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public Phase getPhase() {
		return phase;
	}
	
	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PeriodicElement [number=" + number + ", symbol=" + symbol + ", name=" + name + ", weight=" + weight
				+ ", period=" + period + ", group=" + group + ", phase=" + phase + ", type=" + type + "]";
	}
}

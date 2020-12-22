public class Item {
	int weight = 1;
	String name;

	public Item reverseValue(){
		weight=weight*-1;
		return this;
	}
	public void addWeight(int weight) {
		this.weight += weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return name + " * " + weight;
	}

	Item(String name, int weight) {
		this.name = name.trim();
		this.weight = weight;
	}

	public boolean compare(Item item) {
		return (item.name.equals(this.name));
	}
}

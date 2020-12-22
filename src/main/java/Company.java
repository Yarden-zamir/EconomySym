import java.util.ArrayList;

public class Company {
	ArrayList<Item> sources = new ArrayList<Item>(); // things they source
	ArrayList<recipe> recipes = new ArrayList<>(); // what they can make
	ArrayList<Item> values = new ArrayList<>();
	String name;

	public Company(ArrayList<Item> sources, ArrayList<recipe> recipes, String name) {
		this.sources = sources;
		this.recipes = recipes;
		this.name = name;
	}

	public Company(String name) {
		this.name = name;
	}

	public void calcValues() {
		//        product value = source+recipe+recipe made
		//source
		values = new ArrayList<>(sources);
		//recipe
		for (recipe r : recipes) {
			value(r.output);
			for (Item item:r.ingredients){
				value(item.reverseValue());
			}
		}
		System.out.println(values);
	}


	private void value(Item item) {
		for (Item i : values) {
			if (i.compare(item)) {
				i.addWeight(item.weight);
				return;
			}

		}
		values.add(item);
	}
}

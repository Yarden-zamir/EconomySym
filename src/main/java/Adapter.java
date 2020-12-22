import java.util.ArrayList;
import java.util.HashMap;

public class Adapter {
	public static void main(String[] args) {
		Company Milqe;
		String sources = "<minecraft:iron_ore> * 4;" +
				"<minecraft:raw_beef>;" +
				"<minecraft:leather>;" +
				"<minecraft:milk>;" +
				"<minecraft:rose> * 3;";
		interpreter.retrieveItems(sources);

	}

}

class Company {
	ArrayList<item> sources = new ArrayList<item>(); // things they source
	ArrayList<recipe> recipes = new ArrayList<>(); // what they can make
	String name;

	public Company(ArrayList<item> sources, ArrayList<recipe> recipes, String name) {
		this.sources = sources;
		this.recipes = recipes;
		this.name = name;
	}

	public Company(String name) {
		this.name = name;
	}
}

class interpreter {
	public static ArrayList<item> retrieveItems(String input) {
		ArrayList<item> output = new ArrayList<>();
		for (String s : input.split(";")) {
			if (s.contains("*")) {
				output.add(new item(s.split("\\*")[0], Integer.parseInt(s.split("\\*")[1].trim())));
			} else {
				output.add(new item(s, 1));
			}
		}
		return output;
	}

}

class recipe {
	ArrayList<item> ingredients = new ArrayList<>();
	item output;

	public recipe(ArrayList<item> ingredients, item output) {
		this.ingredients = ingredients;
		this.output = output;
	}
}

class item {
	int weight = 1;
	String name;

	@Override
	public String toString() {
		return name+" * "+weight;
	}

	item(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
}
import java.util.ArrayList;

public class Adapter {
	static int tradeScale = 32;

	public static void main(String[] args) {
		String sources = "<minecraft:iron_ore> * 40;" +
				"<minecraft:beef>;" +
				"<minecraft:leather>;" +
				"<minecraft:milk>;" +
				"<minecraft:rose> * 30;";
		String recipes = "<minecraft:beef>*10 = <minecraft:wheat> * 2,<minecraft:iron_ingot> * 3;" +
				"<minecraft:leather>*10 = <minecraft:wheat>,<minecraft:pumpkin> * 2,<minecraft:iron_ingot>;" +
				"<minecraft:milk>*5=<minecraft:wheat>*3;";
		Company Milqe = new Company(
				interpreter.retrieveItems(sources),
				interpreter.retrieveRecipes(recipes),
				"Milqe inq");
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

	public ArrayList<item> calcValues(){
		ArrayList<item> values;
	}
}

class interpreter {
	public static ArrayList<recipe> retrieveRecipes(String input) {
		ArrayList<recipe> output = new ArrayList<>();
		for (String entry : input.split(";")) {
			//result
			item result = retrieveItem(entry.split("\\=")[0]);
			//ingredients
			ArrayList<item> ingredients = new ArrayList<>();
			for (String ingredient : entry.split("\\=")[1].split(",")) {
				ingredients.add(retrieveItem(ingredient));
			}
			//put into list
			output.add(new recipe(result, ingredients));
		}
		return output;
	}

	public static item retrieveItem(String item) {
		if (item.contains("*")) {
			return new item(item.split("\\*")[0], Integer.parseInt(item.split("\\*")[1].trim()));
		} else {
			return new item(item, 10);
		}
	}

	public static ArrayList<item> retrieveItems(String input) {
		ArrayList<item> output = new ArrayList<>();
		for (String s : input.split(";")) {
			output.add(retrieveItem(s));
		}
		return output;
	}

}

class recipe {
	item output;
	ArrayList<item> ingredients = new ArrayList<>();

	public recipe(item output, ArrayList<item> ingredients) {
		this.ingredients = ingredients;
		this.output = output;
	}

	@Override
	public String toString() {
		return "recipe{" +
				"output=" + output +
				", ingredients=" + ingredients +
				"}\n";
	}
}

class item {
	int weight = 1;
	String name;

	@Override
	public String toString() {
		return name + " * " + weight;
	}

	item(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
}
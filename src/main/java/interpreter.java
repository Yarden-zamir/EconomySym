import java.util.ArrayList;

public class interpreter {
	public static ArrayList<recipe> retrieveRecipes(String input) {
		ArrayList<recipe> output = new ArrayList<>();
		for (String entry : input.split(";")) {
			//result
			Item result = retrieveItem(entry.split("\\=")[0]);
			//ingredients
			ArrayList<Item> ingredients = new ArrayList<>();
			for (String ingredient : entry.split("\\=")[1].split(",")) {
				ingredients.add(retrieveItem(ingredient));
			}
			//put into list
			output.add(new recipe(result, ingredients));
		}
		return output;
	}

	public static Item retrieveItem(String item) {
		if (item.contains("*")) {
			return new Item(item.split("\\*")[0], Integer.parseInt(item.split("\\*")[1].trim()));
		} else {
			return new Item(item, 10);
		}
	}

	public static ArrayList<Item> retrieveItems(String input) {
		ArrayList<Item> output = new ArrayList<>();
		for (String s : input.split(";")) {
			output.add(retrieveItem(s));
		}
		return output;
	}

}

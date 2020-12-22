import java.util.ArrayList;

public class Recipe {
	Item output;
	ArrayList<Item> ingredients = new ArrayList<>();

	public Recipe(Item output, ArrayList<Item> ingredients) {
		this.ingredients = ingredients;
		this.output = output;
	}

	@Override
	public String toString() {
		return "Recipe{" +
				"output=" + output +
				", ingredients=" + ingredients +
				"}\n";
	}
}

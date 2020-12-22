import java.util.ArrayList;

public class recipe {
	Item output;
	ArrayList<Item> ingredients = new ArrayList<>();

	public recipe(Item output, ArrayList<Item> ingredients) {
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

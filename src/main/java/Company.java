import java.util.ArrayList;
import java.util.Random;

public class Company {
	//config
	static float chanceToCraftNeed = 0.9f;
	static float chanceToCraft = 0.2f;
	static int needThreshold = 20;
	static int minimumToKeep = -25;
	//
	ArrayList<Item> sources = new ArrayList<Item>(); // things they source
	ArrayList<Recipe> Recipes = new ArrayList<>(); // what they can make
	ArrayList<Item> values = new ArrayList<>();
	String name;

	public Company(ArrayList<Item> sources, ArrayList<Recipe> Recipes, String name) {
		this.sources = sources;
		this.Recipes = Recipes;
		this.name = name;
	}

	public Company(String name) {
		this.name = name;
	}

	private Item getValue(Item I) {
		for (Item entry : values) {
			if (entry.compare(I))
				return entry;
		}
		return null;
	}

	public void craftingPhase() {
		//the company evaluates what they want to craft
		try {
			for (Recipe recipe : Recipes) {
				//there is a chance that the company will decide to craft even when they don't need and vice versa
				float chance = chanceToCraft;
				if (getValue(recipe.output).weight < needThreshold) {
					System.out.println("need to craft " + getValue(recipe.output));
					chance = chanceToCraftNeed;
				}
				if (new Random().nextFloat() < chance)
					craft(recipe);
			}
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	private void craft(Recipe recipe) {
		for (Item ingredient : recipe.ingredients) {
			if (getValue(ingredient).weight > minimumToKeep) {
				//we have enough to craft
			} else {
				//not enough
				return;
			}
		}
		System.out.println("crafting "+recipe.output);
		for (Item ingredient : recipe.ingredients) {
			getValue(ingredient).addWeight(ingredient.weight);
		}
		getValue(recipe.output).addWeight(recipe.output.weight);
	}

	public void calcValues() {
		//        product value = source+Recipe+Recipe made
		//source
		values = new ArrayList<>(sources);
		//Recipe
		for (Recipe r : Recipes) {
			value(r.output);
			for (Item item : r.ingredients) {
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

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
		Milqe.calcValues();
	}

}


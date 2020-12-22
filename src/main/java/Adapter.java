import java.util.ArrayList;
import java.util.HashMap;

public class Adapter {
	public static void main(String args){
		Company Milqe = new Company("Milqe");

	}

}
class Company{
	ArrayList<item> needs = new ArrayList<item>(); // things they need for production
	HashMap<item, ArrayList<item>> makes; //things they make
	Company(String name){

	}
}

class item{
	int weight=1;
	item(String name, int weight){
		this.weight = weight;
	}
}
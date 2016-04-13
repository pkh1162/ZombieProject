package pkh1162.model;
import java.util.ArrayList;

public class Inventory {

	private ArrayList<Item> inventory;
	private Meds meds = new Meds();
	private Food food = new Food();
	private Ammo ammo = new Ammo();

	public Inventory() {
		this.inventory = new ArrayList<Item>() {
			{
				add(meds);
				add(meds);
				add(food);
				add(food);
				add(ammo);
			}
		};

	}
	
	
	public void newInventory(){
		this.inventory.add(meds);
		this.inventory.add(meds);
		this.inventory.add(food);
		this.inventory.add(food);
		this.inventory.add(ammo);	
	}

	public ArrayList<Item> getInventory() {
		return this.inventory;
	}

	public void storeItems(ArrayList<Item> list) {
		inventory.addAll(list);
	}

	public void removeItem(Item typeOfItem) {

		if (inventory.remove(typeOfItem)) {
			System.out.println("You have succefully used some " + typeOfItem);
		} else {
			System.out.println("The inventory does not contain any " + typeOfItem);
		}
	}

	public void useItem(int choice2, ArrayList<Settler> settlers, int times) {

		switch (choice2) {
		case 1:
			change(meds, settlers, times);
			break;
		case 2:
			change(food, settlers, times);
			break;
		case 3:
			change(ammo, settlers, times);
			break;
		}
	}

	private void change(Item m, ArrayList<Settler> people, int times) {

		for (int i = 0; i < times; i++) {
			if (inventory.contains(m)) {
				for (Settler person : people) {
					m.use(person);
				}
				removeItem(m);
			} else {
				System.out.println("Sorry, you don't have " + m + " in your inventory");
			}
			
		}
	}

	public void findItem(Item itemChoice) {

		if (inventory.contains(itemChoice)){
			System.out.println("The inventory contains " + itemChoice + ".");
		}
		else{
			System.out.println("I'm sorry, the inventory does not contain " + itemChoice + ".");
		}

	}

	public void sortItem() {
		inventory.sort((p1, p2) -> p1.getItemType().compareTo(p2.getItemType()));

		// pass list of Items to the sort settlers class.
	}

	@Override
	public String toString() {
		return "Inventory = " + inventory + "]";
	}

}

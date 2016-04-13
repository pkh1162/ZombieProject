package pkh1162.model;

import java.util.ArrayList;
import java.util.List;

public class Old_Asylum implements Location {

	private List<Item> itemList;
	private Randomness random = new Randomness();
	private int inherentDamage;

	public Old_Asylum(){
		this.itemList = new ArrayList<Item>();
		
		this.inherentDamage = 10;
		
		itemList.add(new Meds());
		itemList.add(new Meds());
		itemList.add(new Food());

		}

	@Override
	public void itemPass(ArrayList<Item> list) {
		
		list.addAll(itemList);
		System.out.println(itemList + " has been added to inventory");
		
	}

	@Override
	public void hurtPlayer(Settler getter) {
		int damage = random.locationDamage(getter.getExp());
		int newHealth = getter.getHealth() - (damage + inherentDamage);
		System.out.print("DAMAGE = " + damage + ",\t ");
		getter.setHealth(newHealth);

	}

	@Override
	public String toString() {
		return "Old Asylum [itemList=" + itemList + "]";
	}
	
	

}

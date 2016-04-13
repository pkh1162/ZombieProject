package pkh1162.model;

public class Ammo extends Item {

	//private String name;
	
	public Ammo() {
		this.itemType = ItemType.Ammo ;
		this.value = 30;
	}

	@Override
	public void use(Settler settler) {
	//	for (int i = 0; i < x; i++){
		settler.setHealth(settler.getHealth() + value);
	//	}
	}

	
	

}

package pkh1162.model;

public class Food extends Item {

	//private String name;
	
	public Food() {
		this.itemType = ItemType.Food ;
		this.value = 3;
	}

	@Override
	public void use(Settler settler) {
		settler.setHealth(settler.getHealth() + value);
	}

	
	

}

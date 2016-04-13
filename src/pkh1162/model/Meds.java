package pkh1162.model;

public class Meds extends Item {
	
	//private String name;

	public Meds() {
		this.itemType = ItemType.Medicine ;
		this.value = 8;
	}

	

	@Override
	public void use(Settler settler) {
		settler.setHealth(settler.getHealth() + value);
	}


	

}

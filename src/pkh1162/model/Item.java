package pkh1162.model;

public abstract class Item {

	protected int value;
	public enum ItemType{
		Ammo, Food, Medicine;				
	}
	
	protected ItemType itemType;
	
	public ItemType getItemType() {
		return itemType;
	}

	public int getValue() {
		return value;
	}

	public void use(Settler settler){
	};

	
	
	@Override
	public String toString() {
		return "" + itemType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemType != other.itemType)
			return false;
		return true;
	}


	

}

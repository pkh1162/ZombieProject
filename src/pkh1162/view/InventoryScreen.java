package pkh1162.view;

public class InventoryScreen extends MasterScreen{
	
	public InventoryScreen() {
		this.thisScreen = ScreenType.InventoryScreen;
		this.validateChoice = new ValidateChoice();		
	}

	@Override
	public void display() {

		System.out.println("\n\n\nINVENTORY");
		System.out.println("\nShow Items (1)");
		System.out.println("Use Items (2)");
		System.out.println("Sort Items (3)");
		System.out.println("Back (4)\n");
		System.out.println("User input:");
	}


	@Override
	public ScreenFeatures storeState(int userChoice) {
		switch (userChoice){
		case 1: 
			return new InventoryScreen();
		case 2:
			return new UseItemsScreen();
		case 3:
			return new InventoryScreen();
		case 4:
			return new SettlementScreen();
		default:
			return null;
		}
	}



}

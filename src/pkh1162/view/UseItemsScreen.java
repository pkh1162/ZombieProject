package pkh1162.view;

public class UseItemsScreen extends MasterScreen{
	
	public UseItemsScreen() {
		this.thisScreen = ScreenType.UseItemsScreen;
		this.validateChoice = new ValidateChoice();		
	}

	@Override
	public void display() {
		System.out.println("\n\nDisplay Items (1)");
		System.out.println("Use Meds (2)");
		System.out.println("Use Food (3)");
		System.out.println("Use Ammo (4)");
		System.out.println("Back (5)\n");
		System.out.println("User input:");
	}


	@Override
	public ScreenFeatures storeState(int userChoice) {
		switch (userChoice){
		case 1: 
		case 2:
		case 3:
		case 4:
			return new UseItemsScreen();
		case 5:
			return new InventoryScreen();
		default:
			return null;
		}
	}



}

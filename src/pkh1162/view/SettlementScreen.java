package pkh1162.view;

public class SettlementScreen extends MasterScreen{

	public SettlementScreen(){
		this.thisScreen = ScreenType.SettlementScreen;
	}
	
	@Override
	public void display() {
		System.out.println("\n\nSETTLEMENT NAME");
		
		System.out.println("\n\nCreate Settler (1)");
		System.out.println("Inventory (2)");
		System.out.println("Show Settlers (3)");
		System.out.println("Save Game (4)");
		System.out.println("Exit (5)\n");
		System.out.println("User input:");
	}

	@Override
	public ScreenFeatures storeState(int userChoice) {
		switch (userChoice){
		case 1: 
			return new CreateSettlerScreen();
		case 2:
			return new InventoryScreen();
		case 3:
			return new ShowSettlersScreen();
		case 4:
			return new SaveGameScreen();
		case 5:
			return new ExitScreen();
		default:
			return null;
		}
		
	}
	
	@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}
	

}

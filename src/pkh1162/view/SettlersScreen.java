package pkh1162.view;

public class SettlersScreen extends MasterScreen{
	
	public SettlersScreen() {
		this.thisScreen = ScreenType.SettlersScreen;
		this.validateChoice = new ValidateChoice();		
	}

	@Override
	public void display() {
		System.out.println("\n\nShow Settlers (1)");
		System.out.println("Sort Settlers (2)");
		System.out.println("Send Settler (3)");
		System.out.println("Back to Settlement (4)\n");
		System.out.println("User input:");
	}


	@Override
	public ScreenFeatures storeState(int userChoice) {
		switch (userChoice){
		case 1: 
			return new ShowSettlersScreen();
		case 2:
			return new SortSettlersScreen();
		case 3:
			return new ToLocationScreen();
		case 4:
			return new SettlementScreen();
		default:
			return null;
		}
	}


}

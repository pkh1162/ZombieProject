package pkh1162.view;

public class SortSettlersScreen extends MasterScreen {
	
	public SortSettlersScreen() {
		this.thisScreen = ScreenType.SortSettlersScreen;
		this.validateChoice = new ValidateChoice();		
	}

	@Override
	public void display() {
		System.out.println("\n\nSort by Name (1)");
		System.out.println("Sort by Age (2)");
		System.out.println("Sort by Health (3)");
		System.out.println("Sort by ID (4)");
		System.out.println("Sort by Experience (5)");
		System.out.println("Sort by Gender (6)");
		System.out.println("Back (7)\n");
		System.out.println("User input:");
	}


	@Override
	public ScreenFeatures storeState(int userChoice) {
		switch (userChoice){
		case 1: 
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			return new SortSettlersScreen();
		case 7:
			return new SettlersScreen();
		default:
			return null;
		}
	}



}

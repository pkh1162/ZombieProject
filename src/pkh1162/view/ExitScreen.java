package pkh1162.view;

public class ExitScreen extends MasterScreen {	

	public ExitScreen() {
		this.thisScreen = ScreenType.ExitScreen;
		//this.validateChoice = new ValidateChoice();	
	}

	@Override
	public void display() {
		System.out.println("\n\nExit Game (1)");
		System.out.println("Back (2)\n");
		System.out.println("User input:");
	}


	@Override
	public ScreenFeatures storeState(int userChoice) {
		
		switch (userChoice){
		case 1: 
			return new Exit();
		case 2:
			return new SettlementScreen();
		default:
			return null;
		}
	}
	
	
	@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}

}
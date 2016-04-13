package pkh1162.view;

public class ToLocationScreen extends MasterScreen {
	
	public ToLocationScreen() {
		this.thisScreen = ScreenType.ToLocationScreen;
		this.validateChoice = new ValidateChoice();		
	}

	@Override
	public void display() {
		System.out.println("\n\nSend to Hospital (1)");
		System.out.println("Send Old Asylum (2)");
		System.out.println("Send to Military Installation (3)");
		System.out.println("Back to Show Settlers (4)\n");
		System.out.println("User input:");
	}


	@Override
	public ScreenFeatures storeState(int userChoice) {
		switch (userChoice){
		case 1: 
		case 2:
		case 3:
			return new ToLocationScreen();
		case 4:
			return new SettlersScreen();
		default:
			return null;
		}
	}


}

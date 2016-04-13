package pkh1162.view;

public class StartScreen extends MasterScreen {

//	private ScreenType thisScreen;
//	private ValidateChoice validateChoice;
	

	public StartScreen() {
		this.thisScreen = ScreenType.StartScreen;
		
	}

	@Override
	public void display() {
		System.out.println("\n\nNew Game (1)");
		System.out.println("Load Game (2)");
		System.out.println("Exit (3)\n");
		System.out.println("User input:");
	}
	
	
	@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}


	@Override
	public ScreenFeatures storeState(int userChoice) {
		
		switch (userChoice){
		case 1: 
			return new IntroScreen();
		case 2:
			return new LoadGameScreen();
		case 3:
			return new ExitScreen();
		default:
			return null;
		}
	}

}

package pkh1162.view;

public class IntroScreen extends MasterScreen {

	public IntroScreen(){
		this.thisScreen = ScreenType.IntroScreen;
	}
	
	
	@Override
	public int getInput() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public void display() {
		System.out.println("\n\n\nYou are the new manager. Good luck.");
	}

	@Override
	public ScreenFeatures storeState(int userChoice) {
		return new SettlementScreen();
	}
	
	@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}

}

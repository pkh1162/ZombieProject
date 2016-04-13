package pkh1162.view;

public class LoadGameScreen extends MasterScreen {

	public LoadGameScreen(){
		this.thisScreen = ScreenType.LoadGameScreen;
	}
	
	
	@Override
	public void display() {
		System.out.println("LOADING...");

	}

	@Override
	public int getInput() {
		// TODO Auto-generated method stub
		return 0;
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

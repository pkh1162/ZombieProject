package pkh1162.view;

public class SaveGameScreen extends MasterScreen {

	public SaveGameScreen(){
		this.thisScreen = ScreenType.SaveGameScreen;
	}
	
	
	@Override
	public void display() {
		System.out.println("SAVING...");

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

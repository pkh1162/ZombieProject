package pkh1162.view;

public class NewGameScreen extends MasterScreen {

	public NewGameScreen(){
		this.thisScreen = ScreenType.NewGame;
	}
	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ScreenFeatures storeState(int userChoice) {
		return null;
		
	}
	
	@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}

}

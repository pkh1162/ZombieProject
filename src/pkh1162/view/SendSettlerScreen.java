package pkh1162.view;

public class SendSettlerScreen extends MasterScreen {
	

	public SendSettlerScreen(){
		this.thisScreen = ScreenType.SendSettlerScreen;
	}
	
	
	@Override
	public int getInput() {
		return 0;
	}
	

	@Override
	public void display() {
	}

	@Override
	public ScreenFeatures storeState(int userChoice) {
		return new SettlersScreen();
	}
	
	@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}


}

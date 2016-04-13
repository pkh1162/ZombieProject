package pkh1162.view;

public class ShowSettlersScreen extends MasterScreen {
	
	public ShowSettlersScreen(){
		this.thisScreen = ScreenType.ShowSettlersScreen;
	}
	
	@Override
	public void display() {				
	}
		
	@Override
	public int getInput() {
		return 1;
	}

	
	@Override
	public ScreenFeatures storeState(int userChoice) {
		switch (userChoice){
		case 1: 
			return new SettlersScreen();		
		default:
			return null;
		}
		
	}
	
	@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}

}

package pkh1162.view;

public class CreateSettlerScreen extends MasterScreen {
	
	public CreateSettlerScreen(){
		this.thisScreen = ScreenType.CreateSettlerScreen;
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

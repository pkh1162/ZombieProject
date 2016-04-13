package pkh1162.view;

public class Exit extends MasterScreen{
	
	public Exit(){
		this.thisScreen = ScreenType.Exit;
	}
	
	public void display(){
		System.out.println("You have exited the game.");
	}
	
	public int getInput(){
		return 0;
	}
	
	@Override
	public ScreenFeatures storeState(int userChoice) {
		return new Exit();
	}
	
	@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}
	

}

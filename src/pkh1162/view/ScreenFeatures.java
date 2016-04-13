package pkh1162.view;

public interface ScreenFeatures {
	public void display();
	public int getInput();
	public ScreenFeatures storeState(int userChoice);
	public ScreenType getThisScreen();

}

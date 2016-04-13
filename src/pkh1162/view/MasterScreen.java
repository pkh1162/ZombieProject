package pkh1162.view;

public class MasterScreen implements ScreenFeatures{

	protected ScreenType thisScreen = ScreenType.MasterScreen;
	protected ValidateChoice validateChoice  = new ValidateChoice();

	

	public int getInput() {

		int choice = 0;
		choice = validateChoice.validateInteger(thisScreen, this);
																	
		return choice;

	}



	@Override
	public void display() {
		System.out.println("This is the master screen.");
		
	}

	@Override
	public ScreenFeatures storeState(int userChoice) {
		return null;
	}

	
	

@Override
	public ScreenType getThisScreen() {
		return this.thisScreen;
	}



	////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((thisScreen == null) ? 0 : thisScreen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MasterScreen other = (MasterScreen) obj;
		if (thisScreen != other.thisScreen)
			return false;
		return true;
	}
	
	

}
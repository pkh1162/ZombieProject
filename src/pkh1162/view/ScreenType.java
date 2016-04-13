package pkh1162.view;

public enum ScreenType {
	StartScreen (0,3), 		 	//(x, y) represent the range of choices on each screen.
	SettlementScreen(0,5), 
	CreateSettlerScreen(0, 0), 
	ExitScreen(0, 2),
	MasterScreen(0,2),
	SettlersScreen(0,4),
	Exit(0, 0),
	IntroScreen(0,0),
	LoadGameScreen(0,0),
	SaveGameScreen(0,0),
	NewGame(0,0),
	ShowSettlersScreen(0,0),
	SortSettlersScreen(0,7),
	InventoryScreen(0, 4),
	UseItemsScreen(0,5),
	SendSettlerScreen(0,0),
	ToLocationScreen(0, 4);
	
	
	
	
	private int lowerChoice, upperChoice;
	
	private ScreenType(int lowerChoice, int upperChoice){
		this.lowerChoice = lowerChoice;
		this.upperChoice = upperChoice;
	}

	public int getLowerChoice() {
		return lowerChoice;
	}

	public int getUpperChoice() {
		return upperChoice;
	}
	
	
	
}

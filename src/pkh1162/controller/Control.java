package pkh1162.controller;
import pkh1162.view.ScreenFeatures;

public class Control {
	
	private ScreenFeatures screen;
	private static ViewModel interact = new ViewModel();
		
	
	public Control(ScreenFeatures screen) {
		this.screen = screen;
	}

	
	public ScreenFeatures run(){
		screen.display();
	    int userChoice = screen.getInput();	    
		interact.doStuff(screen.getThisScreen(), userChoice);    //Could make this method return a screenType, then I could swithc between Screen more easily.
	    return screen.storeState(userChoice);
	}
}

package pkh1162.controller;

import pkh1162.view.Exit;
import pkh1162.view.ScreenFeatures;
import pkh1162.view.StartScreen;

public class App {

	public static void main(String[] args) {
		
		ScreenFeatures state = new StartScreen();
		
		while (!state.equals(new Exit())) {
			
			Control del = new Control(state);
			state = del.run();
			
			}		
		}
	


	}



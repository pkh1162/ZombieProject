/*
package pkh1162.view;


import java.util.Scanner;

public class OldValidateChoice {
	
	private Scanner input = new Scanner(System.in);


	
	public boolean inputValidation(int choice, ScreenType currentScreen, ScreenFeatures screen) {
		
		//Method determines whether or not the int value chosen by user, falls within the choice range 
		//for the current screen. If so, return true to break input loop.

		if (currentScreen == ScreenType.StartScreen) {
			if ((choice > 0) && (choice < currentScreen.getUpperChoice())) {
				return true;
			} else {
				displayAgain(screen);
				System.out.println("Please enter number between: " + currentScreen.getLowerChoice() + " - " + currentScreen.getUpperChoice());
				return false;
			}
		}
		else {			
		}

		return false;
	}
	
	
	public int validateInteger(ScreenFeatures screen){
		
		//Checks user input to see if int value. If so, returns the int, if not, asks 
		//for 
		
		String message = "Enter a positive number below 10";

		while (true) {
			if (input.hasNextInt()) {
				int x = input.nextInt();

				if ((x > 0) && (x < 10)) {
					return x;
				} else {
					displayAgain(screen);
					System.out.println(message);
				}
			} 
            else {
				displayAgain(screen);
				System.out.println(message);
				input.next();
			}
		}
	}

	
	public void displayAgain(ScreenFeatures screen){
		System.out.println();
		screen.display();
	}
	
	
	
}


*/

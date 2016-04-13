package pkh1162.view;

import java.util.Scanner;

public class ValidateChoice {
	
	private Scanner input = new Scanner(System.in);


/*	
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
	
*/
	
	
	public int validateInteger(ScreenType currentScreen, ScreenFeatures screen){
		
		//Checks user input to see if int value. If so, check to see if it matches the current 
		//screens input range. If so, return the choice.
		
		String message = "Please enter number between: " + currentScreen.getLowerChoice() + " - " + currentScreen.getUpperChoice() + "";

		while (true) {
			if (input.hasNextInt()) {
				int x = input.nextInt();

			    if ((x > 0) && (x < currentScreen.getUpperChoice() + 1))  {
					return x;
				} else {
					displayAgain(screen, message);
				}
			} 
            else {
				displayAgain(screen, message);
				input.next();
			}
		}
	}

	
	public void displayAgain(ScreenFeatures screen, String message){
		System.out.println();
		screen.display();
		System.out.println(message);
	}
	
	
	
}

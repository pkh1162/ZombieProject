package pkh1162.model;
import java.util.Scanner;

public class ValidateInput {
	
	private Scanner input;
	
	public ValidateInput(){
		this.input = new Scanner(System.in);
	}

	public String validateGender() {

	//	Scanner input = new Scanner(System.in);

		do {
			String gender = input.nextLine();

			if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
				System.out.println("You are a man");
				return "MALE";
			} else if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
				System.out.println("You are a woman");
				return "FEMALE";
			} else {
				System.out.println("Please choose either 'MALE' or 'FEMALE'");
			}
		} while (true);

	}

	public int validateAge() {
		
		// Could have this class take in a state and use it to validate screen choices as well?

		//Scanner input = new Scanner(System.in);
		String message = "Enter a positive number below 130";

		while (true) {
			if (input.hasNextInt()) {
				int x = input.nextInt();

				if ((x > 0) && (x < 130)) {
					return x;
				} else {
					System.out.println(message);
				}
			} 
            else {
				System.out.println(message);
				input.next();
			}
		}
	}
	
	public String validateName() {
		return input.nextLine();
	}
	
	
	
		
		
	
	
	
}

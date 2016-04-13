package pkh1162.model;
import java.util.ArrayList;

public class SettlerFactory {

	private String settlerName;
	private String settlerGender;
	private int settlerAge;
	private String settlerNameQuery;
	private int settlerIdQuery;
	private ValidateInput validate;
	private static ArrayList<Settler> settlerList = new ArrayList<Settler>();

	public void createSettler() {
		
		validate = new ValidateInput();		//Need to initialise here, as a new scanner has to be set up everytime,
											//otherwise, creating new settlers will take in input from last settler.
		

		
		//Scanner settlerScan = new Scanner(System.in);
		
		System.out.println("Please enter a name for your settler");
		settlerName = validate.validateName();

		System.out.println("Please enter the gender of your settler: ");
		settlerGender = validate.validateGender();

		System.out.println("Please enter the age of your settler");
		settlerAge = validate.validateAge();

		makeSettler(settlerName, settlerGender, settlerAge);

	}
	
	public void hurtAllSettlers(){
		
		ArrayList<Settler> tempList = new ArrayList<Settler>();		//Need to create a temporary list here. As can't add/remove items from settlerList while looping over it.
	
		for(Settler settler: settlerList){
			settler.setHealth(settler.getHealth() - 10);
			if (settler.getState()==false){
				tempList.add(settler);
				System.out.println("Sorry, " + settler.getName() + " died during the attack.\n");
						//Removes settler based on their id-1 = index
			}
			
		}
		
		settlerList.removeAll(tempList);	//this removes the temporary list from the settlerList, removing the dead settlers.
	
	}
	
	

	
	private void makeSettler(String name, String gender, int age) {
		Settler newSettler = new Settler(settlerName, settlerGender, settlerAge);
		addToSettlerList(newSettler);
	}

	
	public void addToSettlerList(Settler person) {
		settlerList.add(person);
		addToLog(person);
	}
	
	public void addToListFromDB(Settler dbPerson) {
		settlerList.add(dbPerson);
	}
	
	
	public ArrayList<Settler> getSettlerList(){								
		return settlerList;
	}
	
	public void sendSettler(Location location, ArrayList<Item> inventory){
	
		Settler chosenOne = enterSettler();
		if (chosenOne != null && (chosenOne.getState())){
			location.hurtPlayer(chosenOne);	
			if (chosenOne.getState() == true){
				chosenOne.setExcursionCount(chosenOne.getExcursionCount() + 1);
				chosenOne.updateClassification();
				location.itemPass(inventory);
			}
			else{
				System.out.println(chosenOne.getName() + " died during this excursion, I'm sorry for your loss.");								
				//removeSettler(chosenOne.getId()-1);
				removeSettler(settlerList.indexOf(chosenOne));
				// or use lambda to do it more efficiently: settlerList.removeIf(e -> (settler.getState()==false));
			}
		}
		
		//The removal of the dead settlers make first if redundant.
		else if (chosenOne != null && (!chosenOne.getState())){
			System.out.println("Sorry, " + chosenOne.getName() + " is dead, they can not be sent to retireive items.");
		}
		else{
			System.out.println("Sorry, this settler doesn't exist.");		}
	}
	
	
	public Settler enterSettler(){
		
		validate = new ValidateInput();
		
		System.out.println("Please enter the name of the settler");
		settlerNameQuery = validate.validateName();

		System.out.println("Please enter the ID of the settler");
		settlerIdQuery = validate.validateAge();

		return findSettler(settlerNameQuery, settlerIdQuery);
		

		
	}
	
	private Settler findSettler(String name, int id){
		for (Settler person: settlerList){
			if ((person.getId() == id) && (person.getName().equalsIgnoreCase(name))){
				return person;
			}	
		}
		
		
		return null;
		
	}
	
	
	public void removeSettler(int index){
		settlerList.remove(index);
		//add to log here that settler has been removed.
	}
	
	
	
	private void addToLog(Settler newSettler){
		// Will send this new person, along with a date to a logFile class, where it 
		// can add the info to a log file which I will create.
		System.out.println(newSettler.getName() + ": New settler created on " + newSettler.getCreationTimeString());
	}

}

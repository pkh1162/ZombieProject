package pkh1162.controller;

import java.util.Scanner;

import pkh1162.model.DatabaseCon;
import pkh1162.model.Hospital;
import pkh1162.model.Inventory;
import pkh1162.model.Item;
import pkh1162.model.Location;
import pkh1162.model.Military_Installation;
import pkh1162.model.Old_Asylum;
import pkh1162.model.Settler;
import pkh1162.model.SettlerFactory;
import pkh1162.model.SortSettlers;
import pkh1162.model.ZombieSleep;
import pkh1162.view.ScreenType;

public class ViewModel {

	private SettlerFactory factory;
	private Inventory inventory;
	private SortSettlers sorter;
	private Scanner scan = new Scanner(System.in);
	private String continueMessage;
	private Location location;
	private ZombieSleep zombies;
	private DatabaseCon dbConnect;
	

	
	
	
	
	public ViewModel() { // Initialising static lists: inventory, settler list.
		this.factory = new SettlerFactory();
		this.inventory = new Inventory();
		this.sorter = new SortSettlers(factory.getSettlerList());
		this.zombies = new ZombieSleep();
		this.dbConnect = new DatabaseCon();
		zombies.start();

		this.continueMessage = "Please press enter to continue";
	}

	
	
	public void pressEnter() {
		System.out.println(continueMessage);
		scan.nextLine();
	}
	
	

	public void doStuff(ScreenType x, int userChoice) {

		if (x.equals(ScreenType.LoadGameScreen)) {
			try {
				dbConnect.readDataBase(factory, inventory);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("LOAD COMPLETE");
			pressEnter();
		}
		
		
		else if (x.equals(ScreenType.SaveGameScreen)) {
			try {
				dbConnect.dropTable();
				dbConnect.createTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (Settler person: factory.getSettlerList()){
				dbConnect.writeSettler(person);
			}
			for (Item item: inventory.getInventory()){
				dbConnect.writeInventory(item);
			}
			
			
			System.out.println("SAVE COMPLETE");
			pressEnter();
		}
						
				
		
		
	    else if (x.equals(ScreenType.IntroScreen)) {
			pressEnter();
		}
		
		
		
		
		
		
	    	
		
	    else if (x.equals(ScreenType.ExitScreen)){
			if (userChoice == 1){
				//System.out.println("Zombies end");
				zombies.interrupt();
			
				
			}
			
		}
		
		
		

		
		
		
		
		
		
		
		
		else if (x.equals(ScreenType.CreateSettlerScreen)) {
			factory.createSettler();
			pressEnter();
			
			if (zombies.getIsAttack()){
				System.out.println("Zombies have attacked.\n\n\n");
				zombies.startUpTimer();
				factory.hurtAllSettlers();
				pressEnter();
			}
			
		} 
		
		
		else if (x.equals(ScreenType.ToLocationScreen)){
			switch (userChoice){
			case 1:
				factory.sendSettler(new Hospital(), inventory.getInventory());
				break;
			case 2:
				factory.sendSettler(new Old_Asylum(), inventory.getInventory());
				break;
			case 3:
				factory.sendSettler(new Military_Installation(), inventory.getInventory());
				break;
			default:
				break;
			}
			pressEnter();
		}
		
		
		else if (x.equals(ScreenType.ShowSettlersScreen)) {
			sorter.printNewList(); // Need to create specific method for
									// printing formatted list.
			pressEnter();
			
		}
		
		
		
		else if (x.equals(ScreenType.SettlersScreen)){
			if (userChoice == 4){
				if (zombies.getIsAttack()){
					System.err.println("Zombies have attacked.\n\n\n");
					zombies.startUpTimer();
					factory.hurtAllSettlers();
					pressEnter();
				}
				
			}
		}
		
		
		else if (x.equals(ScreenType.SortSettlersScreen)) {
			switch (userChoice) {
			case 1:
				sorter.sortByName();
				break;
			case 2:
				sorter.sortByAge();
				break;
			case 3:
				sorter.sortByHealth();
				break;
			case 4:
				sorter.sortById();
				break;
			case 5:
				sorter.sortByExp();
				break;
			case 6:
				sorter.sortByGender();
				break;
			default:
				break;
			}
			sorter.printNewList();
			pressEnter();
			
		} 
		
		
		else if (x.equals(ScreenType.InventoryScreen)){
			
			if (userChoice == 1){
				System.out.println(inventory);
				pressEnter();
			}	
			else if (userChoice == 3){
				inventory.sortItem();
				pressEnter();
			}
			else if (userChoice == 4){
				if (zombies.getIsAttack()){
					System.err.println("Zombies have attacked.\n\n\n");
					zombies.startUpTimer();
					factory.hurtAllSettlers();
					pressEnter();
				}
				
			}
		}
		
		else if (x.equals(ScreenType.UseItemsScreen)) {
			switch (userChoice) {
			case 1:
				System.out.println(inventory);
				break;
			case 2:
				inventory.useItem(1, factory.getSettlerList(), 1);
				break;
			case 3:
				inventory.useItem(2, factory.getSettlerList(), 1);
				break;
			case 4:
				inventory.useItem(3, factory.getSettlerList(), 1);
				break;
			default:
				break;
			}
			pressEnter();
		}
	}
}

package pkh1162.model;
import java.util.ArrayList;

public class SortSettlers {

	private ArrayList<Settler> list;

	public SortSettlers(ArrayList<Settler> list) {
		this.list = list;
	}
	
	
	
	

	public void sortByName() {
		list.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		}

	

	public void sortByAge() {
		list.sort((o1, o2) -> o1.getAge() - o2.getAge());
	//	list.sort((o2, o1) -> o1.getAge() - o2.getAge());   Descending

		}
		
	public void sortById() {
		list.sort((n1, n2) -> n1.getId() - n2.getId());
		}
	

	public void sortByGender() {
		list.sort((n1, n2) -> n1.getGender().compareToIgnoreCase(n2.getGender()));
	}

	public void sortByExp() {
		list.sort((n1, n2) -> n1.getExp().compareTo(n2.getExp()));
	}

	public void sortByHealth() {
		list.sort((n1, n2) -> n1.getId() - n2.getId());
	}
	
	
	
	
	public void printNewList(){
		for (Settler person: list){
			System.out.println(person);
		}
		// Sorting methods can call this to print the settler toSting method, so that 
		// it only one name, id etc is printed. Can format this like a table.
		// Maybe though I can just print them using a specific printing class, I think that would make more sense. 
	}

}

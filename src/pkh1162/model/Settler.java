package pkh1162.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Settler {
	


	private String name;
	private String gender;
	private int health;
	private int id;
	private int age;
	private static int count = 1;
	private Classification exp;
	private LocalDateTime creationTime;
	private boolean state;
	private int excursionCount;

	public Settler(String name, String gender, int age) {

		this.name = name.toUpperCase();
		this.gender = gender;
		this.health = 100;
		this.id = count++;
		this.age = age;
		this.exp = Classification.Newbie;
		this.creationTime = LocalDateTime.now();
		this.state = true;								//Settler is alive.
		this.excursionCount = 0;
	
	}
	
	
	public Settler(String name, String gender, int age, int health, Classification exp, LocalDateTime creationTime, boolean state, int excursionCount) {

		this.name = name.toUpperCase();
		this.gender = gender;
		this.health = health;
		this.id = count++;
		this.age = age;
		this.exp = exp;
		this.creationTime = creationTime;
		this.state = state;								//Settler is alive.
		this.excursionCount = excursionCount;
	}
	

	public int getHealth() {
		return health;
	}

	public void setHealth(int newhealth) {	// Only allows health to reach 100.

		
		if (newhealth <= 0){
			this.health = 0;
			setState();
		//	System.out.print("Settler " + this.getName() + " is dead.\t");
		}
		else if (newhealth > 0 && newhealth < 100) {
			this.health = newhealth;
		//	System.out.print("\t");
		}	
		else if (newhealth >= 100){
			this.health = 100;
		//	System.out.print("Settler " + this.getName() + " has full health\t");		//remove player from list here.
		}
		
		
	}

	public Classification getExp() {
		return exp;
	}

	public void setExp(Classification exp) {
		this.exp = exp;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}
	
	private void setState(){
		this.state = !state;
	}
	
	public boolean getState(){
		if (state){
		//	System.out.println(this.getName() + " is alive.");
			return true;
		}
		else
		{
		//	System.out.println(this.getName() + " is dead.");
			return false;
		}
	}
	
	public int getExcursionCount(){
		return this.excursionCount;
	}
	
	public void setExcursionCount(int excursionCount){
		this.excursionCount = excursionCount;
	}
	
	public void updateClassification(){
		if (excursionCount >= 3 && excursionCount <=6){
			setExp(Classification.Runner);
		}
		else if (excursionCount > 6 ){
			setExp(Classification.Veteran);
		}
	}
	
	

	public String getCreationTimeString() {
		return creationTime.format(DateTimeFormatter.ofPattern("[dd/MM/YYYY]: hh:mm"));
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	/////////////////////////// OVERRIDE
	/////////////////////////// METHODS///////////////////////////////////////

	@Override
	public String toString() {
		return "ID: \t" + id + ", Name: " + name + ", Gender: " + gender + ", Exp: " + exp + ", Health: " + health + ":\t\t" + creationTime + "\n";	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Settler other = (Settler) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

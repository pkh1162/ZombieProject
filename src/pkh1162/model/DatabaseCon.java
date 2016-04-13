package pkh1162.model;

import java.sql.*;
import java.time.LocalDateTime;

import pkh1162.model.Item.ItemType;

public class DatabaseCon {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	

	public DatabaseCon() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://localhost/gameproject?autoReconnect=true&useSSL=false";
			connect = DriverManager.getConnection(connectionURL, "paul", "");			
			statement = connect.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	

	}

	public void readDataBase(SettlerFactory fact, Inventory inventory) throws Exception {
		try {
			resultSet = statement.executeQuery("select * from gameproject.settler");
			writeResultSet(resultSet, fact);
		} catch (Exception e) {
			throw e;
		} finally {
		//	close();
		}
		
		try {
			resultSet = statement.executeQuery("select * from gameproject.inventory");
			writeResultSet2(resultSet, inventory);
		} catch (Exception e) {
			throw e;
		}
		
		
		
		
		
		
		

	}

	public void dataInsert(Settler settler) {

		try {
			statement.executeUpdate(
					"insert into gameproject.settler (settlerName, gender, age, health) values ('Paul', 'female', 34, 90)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	// there is a finally in here that I deleted

	private void writeResultSet(ResultSet resultSet, SettlerFactory fact) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			
			String settlerName = resultSet.getString("settlerName");
			String gender = resultSet.getString("gender");
			//int id = resultSet.getInt("id");
			int age = resultSet.getInt("age");
			int health = resultSet.getInt("health");
			int excursionCount = resultSet.getInt("excursion_count");
			Timestamp tempCreationTime = resultSet.getTimestamp("creation_time");
			boolean state = resultSet.getBoolean("state");
			String tempClassification = resultSet.getString("classification");
			
			
			// Date date = resultSet.getDate("datum");
			
			//Conversions: timestamp -> localdatetime & String -> enum
			LocalDateTime creationTime = tempCreationTime.toLocalDateTime();
			Classification classification = Classification.valueOf(tempClassification);
			
			
			Settler dbSettler = new Settler(settlerName, gender, age, health, classification, creationTime, state, excursionCount);

			
			
			
		/*	Settler dbSettler = new Settler(settlerName, gender, age);
			dbSettler.setHealth(health);
			dbSettler.setExp(Classification.Newbie);
		*/
			
			fact.addToListFromDB(dbSettler);
			
			//System.out.println("ID: " + id);
			//System.out.println(
			//		"Name: " + settlerName + ",  Gender: " + gender + ",  age: " + age + ",  Health: " + health);
			//System.out.println();
			// System.out.println("Date: " + date);
		}
	}
	
	
	private void writeResultSet2(ResultSet resultSet, Inventory invent) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			
			String tempItem = resultSet.getString("item");
			
			if (tempItem.equals("Medicine")){
				invent.getInventory().add(new Meds());
			}
			else if (tempItem.equals("Ammo")){
				invent.getInventory().add(new Ammo());
			}
			else if(tempItem.equals("Food")){
				invent.getInventory().add(new Food());
			}
			
			
		}
	}
	
	
	
	
	

	public void dropTable() {

		try {
			statement.executeUpdate("drop table if exists gameproject.settler");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			statement.executeUpdate("drop table if exists gameproject.inventory");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createTable() {
		
		String create = "create table if not exists gameproject.settler (id int auto_increment primary key, settlerName varchar(20), gender varchar(20), age int, health int, creation_time timestamp not null default now(), state boolean not null default true, classification varchar(20), excursion_count int)";
		String create2 = "create table if not exists gameproject.inventory (item varchar(20))";

		try {
			statement.executeUpdate(create);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			statement.executeUpdate(create2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void writeSettler(Settler settler) {

		String name = settler.getName();
		String gender = settler.getGender();
		int age = settler.getAge();
		int health = settler.getHealth();
		int excursionCount = settler.getExcursionCount();
		String classification = settler.getExp().toString();
		LocalDateTime tempCreationTime = settler.getCreationTime();
		
		//Conversions
		Timestamp creationTime = Timestamp.valueOf(tempCreationTime);
		
		String loadSettlers = "insert into gameproject.settler (settlerName, gender, age, health, creation_time, classification, excursion_count) values (?, ?, ?, ? ,?, ?, ?)";

		try {
			preparedStatement = connect.prepareStatement(loadSettlers);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, gender);
			preparedStatement.setInt(3, age);
			preparedStatement.setInt(4, health);
			preparedStatement.setTimestamp(5, creationTime);
			preparedStatement.setString(6, classification);
			preparedStatement.setInt(7, excursionCount);
			// preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void writeInventory(Item item) {

		String itemName = item.toString();
		
		String loadInventory = "insert into gameproject.inventory (item) values (?)";

		try {
			preparedStatement = connect.prepareStatement(loadInventory);

			preparedStatement.setString(1, itemName);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}

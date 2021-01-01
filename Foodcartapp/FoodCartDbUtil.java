package com.foodcart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDbUtil {
	
	public static List<Food> getFoodList() throws ClassNotFoundException, SQLException
	{
		String URL = "jdbc:mysql://localhost:3306/food";
		String USERNAME = "root";
		String PASSWORD = "1234567";
	
		ArrayList<Food> food = new ArrayList<Food>();
		//load the mysql driver
		Class.forName("com.mysql.jdbc.Driver");
		//get the connection
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		//create a statement
		Statement stmt = con.createStatement();
		//execute the statement and loop over the result set
		ResultSet rs = stmt.executeQuery("SELECT * FROM foodcart");
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String item = rs.getString(2);
			String price = rs.getString(3);
			Food f = new Food(id, item, price);
			food.add(f);
		}
		return food;
	}

}

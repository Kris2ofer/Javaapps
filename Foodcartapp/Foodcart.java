package com.foodcart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Foodcart")
public class Foodcart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data from the database(model)
		
		  try {
			  
		 List<Food> foodItems = FoodCartDbUtil.getFoodList();
		  request.setAttribute("foodItems", foodItems); 
		  } catch (ClassNotFoundException| SQLException e) {
		  
		  e.printStackTrace(); 
		  }
		 
		//String[] foodItems = {"chicken cheese box", "Shrimps", "Mac junior"};
		//request.setAttribute("foodItems", foodItems);
		
		//redirect to a different pager (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("show-food.jsp");
		dispatcher.forward(request, response);
	}

}

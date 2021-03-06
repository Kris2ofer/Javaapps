package javagaragetask;

public class ParkingLot {
	// private data field
	private Level[] lvls;
	// constant variable
	private final int NUM_OF_LEVELS = 5;

	// constructor
	public ParkingLot(){
		lvls = new Level[NUM_OF_LEVELS];
		
		for (int count = 0; count < NUM_OF_LEVELS; count++){
			lvls[count] = new Level(count, 30);
		} // end of for loop
	} // end of constructor

	public boolean parkVeh(Vehicle veh){
		
		for (int count = 0; count < lvls.length; count++){
			if (lvls[count].parkVeh(veh)){
				// return statement
				return true;
			}
		} // end of for loop
		
		// return statement
		return false;
	} // end of parkVeh method
	
	// print out the result in string style
	public String toString(){
		// creating instance
		StringBuilder sb = new StringBuilder();
		
		// print out parking lot
		for (int count = 0; count < NUM_OF_LEVELS; count++){
			sb.append("Level " + count + ": " + lvls[count] + "\n");
		} // end of for loop
		
		// return statement
		return sb.toString();
	} // end of toString method
} // end of ParkingLot class

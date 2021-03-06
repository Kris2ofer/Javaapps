package javagaragetask;

public class Level {
	// private data field
	// spots in each level
	private ParkingSpot[] spts;
	// free spots
	private int avaSpots = 0;
	private static final int SPOTS_PER_ROW = 10;
	
	// default constructor
	public Level(){
		
	} // end of default constructor

	// Overloading constructor
	public Level(int flr, int numSpts){
		// variable declaration
		int smSpts = 0;
		int medSpts = 0;
		int lgSpts = 0;
		int spots = 0;
		int row = 0;
		avaSpots = numSpts;
		spts = new ParkingSpot[numSpts];

		// calculation
		smSpts = numSpts / 4;
		lgSpts = numSpts / 4;
		medSpts = numSpts - smSpts - lgSpts;
		spots = medSpts + lgSpts;
		
		for (int count = 0; count < numSpts; count++){
			// creating instance
			VehicleSize sz = VehicleSize.Bike;
			
			if (count < lgSpts){
				sz = VehicleSize.Large;
			}
			else if (count < spots){
				sz = VehicleSize.Car;
			}
			
			// calculation
			row = count / SPOTS_PER_ROW;
			
			spts[count] = new ParkingSpot(this, row, count, sz);
		} // end of for loop
	} // end of overloading constructor

	// tells program how many available spots are there
	public int availSpts(){
		// return statement
		return avaSpots;
	} // end of availSpts method

	public boolean parkVeh(Vehicle veh){
		// variable declaration and initialization
		int sptNum = fiAvaSpts(veh);
		
		// check if there is still suitable spot left
		if (availSpts() < veh.getSptsNeeded()){
			// return statement
			return false;
		}
		
		if (sptNum < 0){
			// return statement
			return false;
		}
		
		// return statement
		return parkSAtSpot(sptNum, veh);
	} // end of parkVeh method

	// return true if a vehicle parks successfully
	private boolean parkSAtSpot(int numb, Vehicle veh){
		// park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded
		// variable declaration
		boolean succ = true;
		
		for (int count = numb; count < (Vehicle.needSpts + numb); count++){
			succ = succ & spts[count].park(veh);
		} // end of for loop
		
		// calculation
		avaSpots = avaSpots - Vehicle.needSpts;
		
		// return statement
		return succ;
	} // end of parkSAtSpot method

	// find available spot if there is any
	private int fiAvaSpts(Vehicle veh){
		// variable declaration
		int sptNeeded = veh.getSptsNeeded();
		int lastR = -1;
		int sptsFd = 0;
		int sptMOne = 0;
		
		for (int count = 0; count < spts.length; count++){
			// creating instance
			ParkingSpot spt = spts[count];
			
			if (lastR != spt.getRow()){
				sptsFd = 0;
				lastR = spt.getRow();
			}
			
			if (spt.fitVeh(veh)){
				sptsFd++;
			} else {
				sptsFd = 0;
			}
			
			sptMOne = sptNeeded - 1;
			
			if (sptsFd == sptNeeded){
				return (count - sptMOne);
			}
		} // end of for loop
		
		// return statement
		return -1;
	} // end of fiAvaSpts method

	// this method free up spot
	public void frSpt(){
		// calculation
		avaSpots++;
	} // end of feSpt method
	
	// print out in string style
	public String toString(){
		// creating instance
		StringBuilder sb = new StringBuilder();
		
		for (int count = 0; count < spts.length; count++){
			if (count == 10 || count == 20){
				sb.append(" ");
			}
			
			sb.append(spts[count]);
		} // end of for loop
		
		// return statement
		return sb.toString();
	} // end of toString method
} // end of Level class
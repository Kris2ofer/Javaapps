package javagaragetask;

public class Motorcycle extends Vehicle{
	// constructor
	public Motorcycle(){
		needSpts = 1;
		sz = VehicleSize.Bike;
	} // end of constructor

	public boolean canFitSpt(ParkingSpot spt){
		// return true if motorcycle can fit in the spot
		return spt.getSize() == VehicleSize.Bike || spt.getSize() == VehicleSize.Car || spt.getSize() == VehicleSize.Large;
	} // end of canFitSpt method
} // end of Motorcycle class
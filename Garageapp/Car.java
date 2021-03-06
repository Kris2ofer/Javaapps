package javagaragetask;


public class Car extends Vehicle{
	// constructor
	public Car(){
		needSpts = 1;
		sz = VehicleSize.Car;
	} // end of constructor

	public boolean canFitSpt(ParkingSpot spt){
		// return true if it is a large spot
		return spt.getSize() == VehicleSize.Large || spt.getSize() == VehicleSize.Car;
	} // end of canFitSpt method
} // end of Car class
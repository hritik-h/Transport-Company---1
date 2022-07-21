package service;

import java.util.List;

import model.Vehicle;

public interface VehicleCrud {
	
	int insertRecord(Vehicle vehicle);
	int updateRecord(Vehicle vehicle);
	int deleteRecord(String vehicleId);
	List<Vehicle> getAllRecords();
	Vehicle getVehicleByVehicleNumber(int vehicleNumber);
}

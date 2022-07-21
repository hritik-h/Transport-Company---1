package service;

import java.util.List;

import model.User;

public interface DriverCrud {
	int insertRecord(User user);
	int updateRecord(User user);
	int deleteRecord(int id);
	List<User> getAllRecords();
	User getUserbyId(int id);	
}
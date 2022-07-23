package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.xdevapi.Statement;

import model.User;

public class UserService implements UserCrud {
	@Override
	public int insertRecord(User user) {
		
		int result=0;
		try{
			Connection con=VehicleConnection.getConnection();
			//To insert records 
			PreparedStatement ps=con.prepareStatement("insert into userdetails(id,first_name,last_name,uname,password,contactno) values(?,?,?,?,?,?)");
			ps.setInt(1, user.getId());
			ps.setString(2,user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4,user.getUname());
			ps.setString(5, user.getPassword());
			ps.setInt(6, user.getContactno());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}
	
	@Override
	public int updateRecord(User user) {
		
		int result=0;
		try{
			Connection con=VehicleConnection.getConnection();
			//To insert records 
			PreparedStatement ps=con.prepareStatement("update userdetails(id,first_name,last_name,uname,password,contactno) values(?,?,?,?,?,?)");
			ps.setInt(1, user.getId());
			ps.setString(2,user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4,user.getUname());
			ps.setString(5, user.getPassword());
			ps.setInt(6, user.getContactno());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}
	
	@Override
	public int deleteRecord(int id) {
		int result=0;
		try{
			Connection con=VehicleConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from userdetails where id=?");
			
			ps.setInt(1,id);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}
	
	@Override
	public List<User> getAllRecords() {
		ArrayList<User> list=new ArrayList<>();
		try{
		Connection con=VehicleConnection.getConnection();
		//To get all Records
		PreparedStatement stmt=con.prepareStatement("select * from userdetails");
		ResultSet rs=stmt.executeQuery();
		//Add all Records in ArrayList		
						
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getInt(6));
			list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
			//Student student=new Student(rs.getInt(1),rs.getString(2),rs.getDate(3));
			//list.add(student);
					
		}
		con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public User getUserbyId(int id) {
		User userc=null;
		try{
			Connection con=VehicleConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from userdetails where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				userc=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(5));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return userc;
	}

	
	
	

}
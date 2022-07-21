package model;

public class User {
	private int id;
	private String FirstName;
	private String LastName;
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	private String uname;
	private String password;
	private int contactno;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", uname=" + uname
				+ ", password=" + password + ", contactno=" + contactno + "]";
	}
	public User(int id, String firstName, String lastName, String uname, String password, int contactno) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.uname = uname;
		this.password = password;
		this.contactno = contactno;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
}

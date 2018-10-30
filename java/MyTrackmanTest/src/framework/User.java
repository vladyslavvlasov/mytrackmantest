package framework;

public class User {
	public String username;
	public String firstname;
	public String lastname;
	public String password;
	public String email;
	
	public User (String username, String firstname, String lastname, String password)
	{
		this.username=username;
		this.firstname=firstname;
		this.lastname=lastname;
		this.password=password;
	}
	
	public User (String username, String email, String firstname, String lastname, String password)
	{
		this.username=username;
		this.firstname=firstname;
		this.lastname=lastname;
		this.password=password;
		this.email = email;
	}

}

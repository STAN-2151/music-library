package library;
import java.sql.*;

public class Conn {
	Statement s;
	Connection c;
Conn(){
		System.out.println("works A");
	
	
	try {
//		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("works b");

		c=DriverManager.getConnection("jdbc:mysql:///musiclibrary","root","akash@12");
		
		System.out.println("works c");

		s=c.createStatement();
		System.out.println("Works D");
	
		
		}  
		catch(Exception e) {
		System.out.println(e);
		}
		
		
	
	
	
	}
}

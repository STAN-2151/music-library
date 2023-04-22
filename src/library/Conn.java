package library;
import java.sql.*;

public class Conn {
	public Statement s;
	public Connection c;
	
Conn(){	
	try {
		c=DriverManager.getConnection("jdbc:mysql:///musiclibrary","root","akash@12");
		s=c.createStatement();		
		}  
		catch(Exception e) {
		System.out.println(e);
		}	
	}
}

package library;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class BrowsePlaylist extends JFrame {
	
	public BrowsePlaylist() throws SQLException{
		setSize(900,600);
		setVisible(true);
		setLocation(340,150);
		setTitle("Music Library Project");
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
				
		JLabel text = new JLabel("All available Playlists are:");
		add(text);
		text.setFont(new Font("sans-serif",Font.BOLD,44));
		text.setForeground(Color.WHITE);
		text.setBounds(180,30,720,60);
		
		Conn obj = new Conn();	
		String query = "show tables;";
	    ResultSet resultSet = obj.s.executeQuery(query);
	    
	    String playlists[] = new String[50];
	    int i =0;
	    while(resultSet.next()) {
	    	playlists[i] = (String) resultSet.getString(1);
	    	i++;
	        System.out.println( (String) resultSet.getString(1));
	        System.out.println( playlists[i]);
	         
	    }
	}
	
	public static void main(String args[]) throws SQLException {
		try {
			new BrowsePlaylist();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

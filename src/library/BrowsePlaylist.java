package library;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class BrowsePlaylist extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JRadioButton yes;

	
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
	    
			    String[] playlists = new String[20];
			    int i =0;
			    while(resultSet.next()) {
			    	playlists[i] = ""+ resultSet.getString(1);
			    	i++;
			    }
			    
			    int i1=1;
			    String list ="<html>" +"* "+playlists[0];
			    while(playlists[i1]!=null) {
			    	list+= "<br>" + "* "+playlists[i1] ;
			    	i1++;
			    }	list+="</html>";
			
				JLabel song = new JLabel(list);
				add(song);
				song.setFont(new Font("sans-serif",Font.BOLD,24));
				song.setForeground(Color.WHITE);
				song.setBounds(240,100,310,400);
				
				JLabel back = new JLabel("Go back to main menu:");
				back.setFont(new Font("sans-serif",Font.ITALIC,22));
				back.setForeground(Color.WHITE);
				add(back);
				back.setBounds(200,490,400,40);

				 	yes = new JRadioButton("YES");
					yes.setBounds(440,490,80,40);
					add(yes);
					yes.setBackground(Color.BLACK);
					yes.setForeground(Color.WHITE);
					yes.addActionListener(this);
			    
			    
			    
			}
	public void actionPerformed(ActionEvent ae) {
		if(yes.isSelected()) {
			new Login();
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

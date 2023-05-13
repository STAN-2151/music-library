package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.swing.*;

public class OpenPlaylist extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton sub1;
	JTextField OpnPly;
	JRadioButton yes;
	OpenPlaylist()
	{
		setSize(900,600);
		setVisible(true);
		setLocation(340,150);
		setTitle("Music Library Project");
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
				
		JLabel text = new JLabel("Browse your playlist");
		add(text);
		text.setFont(new Font("sans-serif",Font.BOLD,44));
		text.setForeground(Color.WHITE);
		text.setBounds(180,30,720,60);
		
		JLabel entName = new JLabel("Enter name of playlist : ");
		add(entName);
		entName.setForeground(Color.WHITE);
		entName.setFont(new Font("sans-serif",Font.ITALIC,22));
		entName.setBounds(180,40,400,160);
		
		OpnPly = new JTextField();
		OpnPly.setBounds(430, 114, 200, 20);
		add(OpnPly);
		
		sub1 = new JButton("SUBMIT");
		sub1.setBackground(Color.BLACK);
		sub1.setForeground(Color.WHITE);
		add(sub1);
		sub1.addActionListener(this);
		sub1.setBounds(300,150,200,40);
		
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
	String name;

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==sub1) {			
				try {
					
				 name = (String) OpnPly.getText();
					if( name.equals("") ) {
						JOptionPane.showMessageDialog(null,"Invalid input");
					}
					else if (name.contains(" ")) {
						JOptionPane.showMessageDialog(null,"You cannot add space in playlist name");
					}
					else {
						Conn obj = new Conn();	
						String query = "show tables;";
					    ResultSet resultSet = obj.s.executeQuery(query);
							    String[] playlists = new String[20];
							    
							    int i =0;
							    while(resultSet.next()) {
							    	playlists[i] = ""+ resultSet.getString(1);
							    	i++;	
							    }
							    
							    boolean test = Arrays.asList(playlists).contains(name);
							    if(test) {
							    	new songs(name);
							    }
							    else 		
							    	JOptionPane.showMessageDialog(null,"Playlist doesn't exist");

				}
		}
				
	
				catch(Exception e) {
					e.printStackTrace();
				}
			
			
		}
		else if(yes.isSelected()) {
			
			new Login();
		}
		
	}
	
	public static void main(String args[])
	{
		new OpenPlaylist();
	}

	
	
}

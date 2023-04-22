package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class CreatePlaylist extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton sub;
	JTextField CrtPly;
	CreatePlaylist()
	{
		setSize(900,600);
		setVisible(true);
		setLocation(340,150);
		setTitle("Music Library Project");
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
				
		JLabel text = new JLabel("Create a new playlist");
		add(text);
		text.setFont(new Font("sans-serif",Font.BOLD,44));
		text.setForeground(Color.WHITE);
		text.setBounds(180,30,720,60);
		
		JLabel entName = new JLabel("Enter name for playlist : ");
		add(entName);
		entName.setFont(new Font("sans-serif",Font.ITALIC,22));
		entName.setForeground(Color.WHITE);
		entName.setBounds(180,40,400,220);
		
		CrtPly = new JTextField();
		CrtPly.setBounds(430, 140, 200, 30);
		add(CrtPly);
		
		sub = new JButton("SUBMIT");
		sub.setBackground(Color.BLACK);
		sub.setForeground(Color.WHITE);
		add(sub);
		sub.setBounds(300,220,200,40);
		sub.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == sub) {
			try {

			String name = (String) CrtPly.getText();

				if( name.equals("") ) {
					JOptionPane.showMessageDialog(null,"Invalid input");
				}
				if (name.contains(" ")) {
					JOptionPane.showMessageDialog(null,"You cannot add space in playlist name");
				}
				else {
					Conn obj = new Conn();	
					String query = "create table "+name+"( songs varchar(20));";
					obj.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Playlist created");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	  }	
	}
	
	public static void main(String args[])
	{
		try {
				new CreatePlaylist();	
		}
		catch(Exception e) 
		{
		
		}
	}	
}

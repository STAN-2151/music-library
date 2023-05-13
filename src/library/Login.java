package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		JButton submit;JTextField inputText;
		
	Login(){
		setSize(900,600);
		setVisible(true);
		setLocation(340,150);
		setTitle("Music Library Project");
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel text = new JLabel("Welcome to your Music Library");
		add(text);
		text.setFont(new Font("sans-serif",Font.BOLD,38));
		text.setForeground(Color.WHITE);
		text.setBounds(100, 40, 800, 40);
		
		JLabel menu = new JLabel("Would you like to: ");
		add(menu);
		menu.setFont(new Font("sans-serif",Font.ITALIC,24));
		menu.setForeground(Color.WHITE);
		menu.setBounds(150, 60, 200, 120);		

		JLabel opn = new JLabel("1. Open a playlist ");
		add(opn);
		opn.setFont(new Font("sans-serif",Font.ITALIC,24));
		opn.setForeground(Color.WHITE);
		opn.setBounds(200, 60, 200, 180);
		
		JLabel crt = new JLabel("2. Create a playlist");
		add(crt);
		crt.setFont(new Font("sans-serif",Font.ITALIC,24));
		crt.setForeground(Color.WHITE);
		crt.setBounds(200, 60, 200, 240);
		
		JLabel brws = new JLabel("3. Browse playlists");
		add(brws);
		brws.setFont(new Font("sans-serif",Font.ITALIC,24));
		brws.setForeground(Color.WHITE);
		brws.setBounds(200, 60, 300, 300);
		
		JLabel dlt = new JLabel("4. Delete Existing Playlist");
		add(dlt);
		dlt.setFont(new Font("sans-serif",Font.ITALIC,24));
		dlt.setForeground(Color.WHITE);
		dlt.setBounds(200, 60, 300, 360);

		JLabel inp = new JLabel("Your Input:");
		add(inp);
		inp.setFont(new Font("sans-serif",Font.BOLD,32));
		inp.setForeground(Color.WHITE);
		inp.setBounds(150, 60, 200, 460);
		
		inputText = new JTextField();
		inputText.setBounds(320, 284, 150, 20);
		add(inputText);
		
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(200, 330, 250, 40);
		add(submit);
		submit.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			String choose = ""+ inputText.getText();
			
			switch(choose) {
			case "1" :  new OpenPlaylist();
						break;
			case "2" :  new CreatePlaylist();
						break;
			case "3" : 	try {
						new BrowsePlaylist();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
			case "4" : 	new Delete();
						break;
				
			default  : 	JOptionPane.showMessageDialog(null, "Invalid Input");
						break;
			}
		}
		
	}
			
			/*
			if(choose.equals("1")) {
				OpenPlaylist obj= new OpenPlaylist();
			}
			
			else if(choose.equals("2")) {
			CreatePlaylist obj= new CreatePlaylist();
			}
			else if(choose.equals("3")){
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Input");
			} */

	public static void main(String[] args) {
		new Login();
	}
}

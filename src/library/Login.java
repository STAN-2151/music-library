package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
		JButton submit;JTextField inputText;
		
	Login(){
		setSize(800,480);
		setVisible(true);
		setLocation(340,210);
		setTitle("Music Library Project");
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel text = new JLabel("Welcome to your Music Library");
		add(text);
		text.setFont(new Font("sans-serif",Font.BOLD,38));
		text.setBounds(100, 40, 800, 40);
		
		JLabel menu = new JLabel("Would you like to: ");
		add(menu);
		menu.setFont(new Font("sans-serif",Font.ITALIC,24));
		menu.setBounds(150, 60, 200, 120);		

		JLabel opn = new JLabel("1. Open a playlist ");
		add(opn);
		opn.setFont(new Font("sans-serif",Font.ITALIC,24));
		opn.setBounds(200, 60, 200, 180);
		
		JLabel crt = new JLabel("2. Create a playlist");
		add(crt);
		crt.setFont(new Font("sans-serif",Font.ITALIC,24));
		crt.setBounds(200, 60, 200, 240);
		
		JLabel brws = new JLabel("3. Browse playlists");
		add(brws);
		brws.setFont(new Font("sans-serif",Font.ITALIC,24));
		brws.setBounds(200, 60, 300, 300);

		JLabel inp = new JLabel("Your Input:");
		add(inp);
		inp.setFont(new Font("sans-serif",Font.BOLD,32));
		inp.setBounds(150, 60, 200, 430);
		
		inputText = new JTextField();
		inputText.setBounds(320, 270, 150, 20);
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
			case "1" : 	OpenPlaylist obj= new OpenPlaylist();
						break;
			case "2" : 	CreatePlaylist obj1= new CreatePlaylist();
						break;
			case "3" :  break;
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

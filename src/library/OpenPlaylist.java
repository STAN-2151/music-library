package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class OpenPlaylist extends JFrame implements ActionListener
{
	JButton sub1;
	JTextField OpnPly;
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
		text.setBounds(180,30,720,60);
		
		JLabel entName = new JLabel("Enter name of playlist : ");
		add(entName);
		entName.setFont(new Font("sans-serif",Font.ITALIC,22));
		entName.setBounds(180,40,400,220);
		
		OpnPly = new JTextField();
		OpnPly.setBounds(430, 140, 200, 30);
		add(OpnPly);
		
		sub1 = new JButton("SUBMIT");
		sub1.setBackground(Color.BLACK);
		sub1.setForeground(Color.WHITE);
		add(sub1);
		sub1.setBounds(300,220,200,40);
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==sub1) {
		
		}
		
	}
	
	public static void main(String args[])
	{
	new OpenPlaylist();	
	}

	
	
}

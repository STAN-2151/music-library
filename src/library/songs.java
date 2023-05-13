package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class songs extends JFrame implements ActionListener
{ /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

String name;

	JRadioButton yes,addButton,removeButton;
	JRadioButton viewButton;
	songs(String a)
	{
		String ab = "Playlist Name: "+a; 
				
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
			
			
			JLabel add1 = new JLabel("Add Songs");
			add1.setFont(new Font("sans-serif",Font.ITALIC,22));
			add1.setForeground(Color.WHITE);
			add(add1);
			add1.setBounds(200,200,400,40);
			
			JLabel pname = new JLabel(ab);
			pname.setFont(new Font("sans-serif",Font.ITALIC,28));
			pname.setForeground(Color.WHITE);
			add(pname);
			pname.setBounds(200,120,400,40);
			
			addButton = new JRadioButton("");
			addButton.setBounds(360,200,400,40);
			add(addButton);
			addButton.setBackground(Color.BLACK);
			addButton.setForeground(Color.WHITE);
			addButton.addActionListener(this);
			
			JLabel rm = new JLabel("Remove Songs");
			rm.setFont(new Font("sans-serif",Font.ITALIC,22));
			rm.setForeground(Color.WHITE);
			add(rm);
			rm.setBounds(200,240,400,40);
			
			removeButton = new JRadioButton("");
			removeButton.setBounds(360,240,400,40);
			add(removeButton);
			removeButton.setBackground(Color.BLACK);
			removeButton.setForeground(Color.WHITE);
			removeButton.addActionListener(this);
			
			
			
			name=a;
			System.out.println("name of playlist is "+name);
			
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(yes.isSelected()) {
			new Login();
		}
		else if(addButton.isSelected()) {
			new AddSongs(name);
		}
		else if(removeButton.isSelected()) {
			new RemoveSongs(name);
			
			}
		}
	}
	

	
	


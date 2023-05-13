package library;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class Delete extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JRadioButton yes;
	JButton sub;
	JTextField DltPly;
	
	Delete()
	{
		setSize(900,600);
		setVisible(true);
		setLocation(340,150);
		setTitle("Music Library Project");
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
				
		JLabel text = new JLabel("Delete Existing Playlist");
		add(text);
		text.setFont(new Font("sans-serif",Font.BOLD,44));
		text.setForeground(Color.WHITE);
		text.setBounds(180,30,720,60);
		
		JLabel entName = new JLabel("Enter name of playlist : ");
		add(entName);
		entName.setFont(new Font("sans-serif",Font.ITALIC,22));
		entName.setForeground(Color.WHITE);
		entName.setBounds(180,40,400,220);
		
		DltPly = new JTextField();
		DltPly.setBounds(430, 140, 200, 30);
		add(DltPly);
		
		sub = new JButton("SUBMIT");
		sub.setBackground(Color.BLACK);
		sub.setForeground(Color.WHITE);
		add(sub);
		sub.setBounds(300,220,200,40);
		sub.addActionListener(this);
		
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
		if(ae.getSource() == sub) {
			try {

			String name = (String) DltPly.getText();

				if( name.equals("") ) {
					JOptionPane.showMessageDialog(null,"Invalid input");
				}
				if (name.contains(" ")) {
					JOptionPane.showMessageDialog(null,"You cannot add space in playlist name");
				}
				else {
					Conn obj = new Conn();	
					String query = "drop table "+name;
					obj.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Playlist removed");
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
		try {
				new Delete();	
		}
		catch(Exception e) 
		{
		
		}
	}
}
	

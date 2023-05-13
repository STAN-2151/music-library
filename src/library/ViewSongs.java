package library;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ViewSongs extends JFrame implements ActionListener {
	JRadioButton yes,add,remove;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewSongs(String a) {
		
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
		text.setBounds(180,20,720,60);
		
		JLabel entName = new JLabel("Available Songs in your playlist:");
		add(entName);
		entName.setFont(new Font("sans-serif",Font.ITALIC,28));
		entName.setForeground(Color.WHITE);
		entName.setBounds(200,0,440,220);
		
		JLabel list = new JLabel(a);
		add(list);
		list.setFont(new Font("sans-serif",Font.ITALIC,23));
		list.setForeground(Color.WHITE);
		list.setBounds(220,40,440,500);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
if(yes.isSelected()) {
	new Login();
}
	}
	


}

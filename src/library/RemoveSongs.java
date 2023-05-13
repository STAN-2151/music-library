package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RemoveSongs extends JFrame implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String name,songList;
String[] songs = new String[40];
JButton sub;
JTextField remSong;
JRadioButton yes, viewButton;
	public RemoveSongs(String a) {
		name = a;
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
		text.setBounds(180,20,720,60);
		
		JLabel pname = new JLabel(ab);
		pname.setFont(new Font("sans-serif",Font.ITALIC,28));
		pname.setForeground(Color.WHITE);
		add(pname);
		pname.setBounds(200,80,400,40);
		
		JLabel entName = new JLabel("Remove song: ");
		add(entName);
		entName.setFont(new Font("sans-serif",Font.ITALIC,22));
		entName.setForeground(Color.WHITE);
		entName.setBounds(160,40,440,220);
		
		remSong = new JTextField();
		remSong.setBounds(310, 144, 150, 17);
		add(remSong);
		
		sub = new JButton("SUBMIT");
		sub.setBackground(Color.BLACK);
		sub.setForeground(Color.WHITE);
		add(sub);
		sub.setBounds(510,138,200,30);
		sub.addActionListener(this);
	
		JLabel view1 = new JLabel("View Songs");
		view1.setFont(new Font("sans-serif",Font.ITALIC,22));
		view1.setForeground(Color.WHITE);
		add(view1);
		view1.setBounds(200,450,400,40);
		
		 viewButton = new JRadioButton("");
		viewButton.setBounds(360,450,400,40);
		add(viewButton);
		viewButton.setBackground(Color.BLACK);
		viewButton.setForeground(Color.WHITE);
		viewButton.addActionListener(this);
		
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
	public void actionPerformed(ActionEvent e) {
		if(yes.isSelected()) {
			new Login();
		}
		else if(viewButton.isSelected()) {
			new ViewSongs(songList);
		}
		else if(e.getSource() == sub) {
			
				String rem = (String) remSong.getText();
				if( rem.equals("") ) {
					JOptionPane.showMessageDialog(null,"Invalid input");
				}
				if (rem.contains(" ")) {
					JOptionPane.showMessageDialog(null,"You cannot add space in song name");
				}
				else {
					
				try {
				Conn obj = new Conn();	
				String query = "delete from "+name+" where songs='"+rem+"';";
					obj.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Song removed");

					String query2 = "select * from "+name;
					ResultSet rs = obj.s.executeQuery(query2);
					int i=0;
					while(rs.next()) {
				    	songs[i] = ""+ rs.getString("songs");
				    	i++;
				    }
					
					int i1=1;
					songList ="<html>" + songs[0];
				    while(songs[i1]!=null) {
				    	songList+= "<br>" + "* "+songs[i1] ;
				    		i1++;
				    	}
				    songList+="</html>";
				
			    
			    
			    
			    
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}			
				}
			}
	
		}
	public static void main(String args[]) {
		new RemoveSongs("demo");
	}
}

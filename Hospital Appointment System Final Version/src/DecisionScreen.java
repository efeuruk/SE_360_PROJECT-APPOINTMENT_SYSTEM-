import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
public class DecisionScreen {
	JFrame Decision=new JFrame("Decision Screen");
	JButton make;
	JButton look;
	JButton back;
	JLabel l1;
	

	
	DecisionScreen(){
		Decision.setLayout(null);
		make=new JButton("Make Appointment");
		look=new JButton("Look My Appointment");
		back = new JButton("Back");
		make.setBounds(80, 100, 150, 30);
		look.setBounds(80, 150, 150, 30);
		back.setBounds(80,200,150,30);
		Decision.add(make);
		Decision.add(look);
		Decision.add(back);
		Decision.setVisible(true);
		Decision.setSize(400,400);
		look.setVisible(true);
		
		
		
		make.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				new MainScreen();
				Decision.setVisible(false);
			}
			
		});
		
		look.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CheckAppointment();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Decision.setVisible(false);
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Decision.setVisible(false);
				new Test();
				
			}
		});
	}

	public static void main(String[] args) {
		
		new DecisionScreen();
		

	}

}

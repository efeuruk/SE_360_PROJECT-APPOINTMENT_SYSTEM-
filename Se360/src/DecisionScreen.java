import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class DecisionScreen {
	JFrame Decision=new JFrame("Decision Screen");
	JButton make;
	JButton look;
	JLabel l1;
	
	DecisionScreen(){
		Decision.setLayout(null);
		make=new JButton("Make Appointment");
		look=new JButton("Look My Appointment");
		make.setBounds(80, 100, 150, 30);
		look.setBounds(80, 150, 150, 30);
		Decision.add(make);
		Decision.add(look);
		
		
		
		Decision.setVisible(true);
		Decision.setSize(400,400);
		
	
	
		make.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				
				new MainScreen();
				Decision.setVisible(false);
				
			}
			
		});
		
		look.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panel4 dekiler eklenecek
			}
		});
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		new DecisionScreen();
		

	}

}

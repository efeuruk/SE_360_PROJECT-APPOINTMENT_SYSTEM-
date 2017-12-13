import java.awt.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class MainScreen {
	
	JFrame anaEkran;
	
	MainScreen(){
		
		anaEkran = new JFrame("Appointment System 1.0 Main Screen"); 
        
        //PANEL1
		JPanel panel1=new JPanel();
		panel1.setBounds(0, 0, 300, 250);	
		anaEkran.add(panel1);
		JButton b1=new JButton("Click");
		b1.setBounds(20, 150, 100, 30);
		panel1.add(b1);
		panel1.setBackground(Color.gray);
		
		JRadioButton rb1=new JRadioButton("KBB"); 
		JRadioButton rb2=new JRadioButton("Radyoloji");
		JRadioButton rb3=new JRadioButton("Cildiye");
		rb1.setBounds(20, 20, 100, 30);
		rb2.setBounds(20, 60, 100, 30);
		rb3.setBounds(20, 100, 100, 30);//sizelarý ayarlanmalý
		panel1.add(rb1);
		panel1.add(rb2);
		panel1.add(rb3);
		panel1.setLayout(null);
		
		
		
		
		
		//PANEL2
		JPanel panel2=new JPanel();
		panel2.setBounds(300,0,300,250);
		anaEkran.add(panel2);
		JButton b2=new JButton("Click");
		panel2.add(b2);
		panel2.setBackground(Color.gray);
		panel2.setVisible(false);
		JRadioButton r1=new JRadioButton("Berk");    
		JRadioButton r2=new JRadioButton("Alper");
		JRadioButton r3=new JRadioButton("Efe");    
		JRadioButton r4=new JRadioButton("Ipek");
		JRadioButton r5=new JRadioButton("Hamza");
		JRadioButton r6=new JRadioButton("Clement");    
		JRadioButton r7=new JRadioButton("Artour");
		JRadioButton r8=new JRadioButton("Jacky");
		panel2.add(r1);panel2.add(r2);panel2.add(r3);panel2.add(r4);
		panel2.add(r5);panel2.add(r6);panel2.add(r7);panel2.add(r8);
		r1.setVisible(false);r2.setVisible(false);r3.setVisible(false);
		r4.setVisible(false);r5.setVisible(false);r6.setVisible(false);
		r7.setVisible(false);r8.setVisible(false);
				
		
		
		//PANEL3
		JPanel panel3=new JPanel();
		panel3.setBounds(0,250,300,250);
		anaEkran.add(panel3);
		panel3.setBackground(Color.gray);
		JButton b3=new JButton("Click");
		panel3.add(b3);
		String hours1[]={"09.00","10.00","11.00","12.00","13.00"};
		String days1[]={"Tuesday","Wednesday","Thursday","Friday"};
		String hours2[]= {"14.00","15.00","16.00","17.00"};
		String day2[]= {};
		final JComboBox cb1=new JComboBox(hours1);
		final JComboBox cb2=new JComboBox(days1);
		panel3.add(cb1);panel3.add(cb2);
		cb1.setVisible(false);cb2.setVisible(false);
		panel3.setVisible(false);
		
		
		//PANEL4
		JPanel panel4=new JPanel();
		anaEkran.add(panel4);
		panel4.setBounds(300,250, 300, 250);
		panel4.setBackground(Color.gray);
		panel4.setVisible(false);
		JButton b4=new JButton("Submit");
		panel4.add(b4);
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )  {
			
				
				if(rb1.isSelected()) {
					r1.setVisible(true);
					r2.setVisible(true);
					panel2.setVisible(true);
					panel2.setLayout(null);
					
					r1.setBounds(10,20,100,30);
					r2.setBounds(10,60,100,30);
					b2.setBounds(10, 100, 100, 30);
					
					
					
				}
				
				if(rb2.isSelected()) {
					r3.setVisible(true);
					r4.setVisible(true);
					r5.setVisible(true);
					panel2.setVisible(true);
					panel2.setLayout(null);
					r3.setBounds(10,20,100,30);
					r4.setBounds(10,60,100,30);
					r5.setBounds(10, 100, 100, 30);
					b2.setBounds(10, 140, 100, 30);
				}
				
				if(rb3.isSelected()) {
					r6.setVisible(true);
					r7.setVisible(true);
					r8.setVisible(true);
					panel2.setVisible(true);
					panel2.setLayout(null);
					r6.setBounds(10,20,100,30);
					r7.setBounds(10,60,100,30);
					r8.setBounds(10, 100, 100, 30);
					b3.setBounds(10, 140, 100, 30);
					
				}
			
			
			
				panel2.setVisible(true);
			}
			
			
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )  {
				
				if(r1.isSelected()) {
									 
					  cb1.setVisible(true);
					  cb2.setVisible(true);
					  panel3.setLayout(null);
					  panel3.setVisible(true);
					  cb1.setBounds(10,20,100,30);
					  cb2.setBounds(10,60,100,30);
					  b3.setBounds(10, 100, 100, 30);
					
				}
				
			panel3.setVisible(true);
				
			}
			
			
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )  {
				
				panel4.setVisible(true);
				
				
			}
			
			
		});
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )  {
				JOptionPane.showMessageDialog(anaEkran,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);
				anaEkran.setVisible(false);
				
			}
			
			
		});
		
		anaEkran.setSize(800,600);
		anaEkran.setLayout(null);
		anaEkran.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new MainScreen();
	}

}
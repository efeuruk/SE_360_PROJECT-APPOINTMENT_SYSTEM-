import java.awt.Color;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
public class MainScreen {
	
	PersonIslemler islemler = new PersonIslemler();
	JFrame anaEkran;
	ButtonGroup group1 = new ButtonGroup();
	ButtonGroup group2 = new ButtonGroup();
	ButtonGroup group3 = new ButtonGroup();
	ButtonGroup group4 = new ButtonGroup();
	ButtonGroup group5 = new ButtonGroup();
	
	MainScreen(){
		
		anaEkran = new JFrame("Appointment System 1.0 Main Screen"); 
        
        //PANEL1
		JPanel panel1=new JPanel();
		panel1.setBounds(0, 0, 300, 250);	
		anaEkran.add(panel1);
		JButton b1=new JButton("Click");
		b1.setBounds(20, 180, 100, 30);
		panel1.add(b1);
		panel1.setBackground(Color.gray);
		panel1.setLayout(null);
		JRadioButton rb1=new JRadioButton("Ear-Nose-Throat Clinic"); 
		JRadioButton rb2=new JRadioButton("Surgery Clinic");
		JRadioButton rb3=new JRadioButton("Dermatology Clinic");
		JRadioButton rb4=new JRadioButton("Orthopedics ");
		rb1.setBounds(20, 20, 160, 30);
		rb2.setBounds(20, 60, 160, 30);
		rb3.setBounds(20, 100, 160, 30);
		rb4.setBounds(20,140,160,30);
		panel1.add(rb1);
		panel1.add(rb2);
		panel1.add(rb3);
		panel1.add(rb4);
		group1.add(rb1);
		group1.add(rb2);
		group1.add(rb3);
		group1.add(rb4);
		panel1.setLayout(null);
		
		
		
		
		
		//PANEL2
		JPanel panel2=new JPanel();
		panel2.setBounds(300,0,300,250);
		anaEkran.add(panel2);
		JButton b2=new JButton("Click");
		panel2.add(b2);
		panel2.setBackground(Color.gray);
		panel2.setVisible(false);
		JRadioButton dr1=new JRadioButton("Dr. Ertug Adalarli");    
		JRadioButton dr2=new JRadioButton("Dr. Alper Ezircan");
		JRadioButton dr3=new JRadioButton("Dr. Kubilay Aydede");    
		JRadioButton dr4=new JRadioButton("Dr. Hande Ozdinler");
		JRadioButton dr5=new JRadioButton("Dr. Omer Ozkan");
		JRadioButton dr6=new JRadioButton("Dr. Tufan Aybek");    
		JRadioButton dr7=new JRadioButton("Dr. Murat Gunel");
		JRadioButton dr8=new JRadioButton("Dr. Nihat Tanfer");
		JRadioButton dr9=new JRadioButton("Dr. Mehmet Oz");
		panel2.add(dr1);panel2.add(dr2);panel2.add(dr3);panel2.add(dr4);
		panel2.add(dr5);panel2.add(dr6);panel2.add(dr7);panel2.add(dr8);
		panel2.add(dr9);
		//r1.setVisible(false);r2.setVisible(false);r3.setVisible(false);
		//r4.setVisible(false);r5.setVisible(false);r6.setVisible(false);
		//r7.setVisible(false);r8.setVisible(false);r9.setVisible(false);
		group2.add(dr1);group2.add(dr2);group3.add(dr3);group3.add(dr4);group3.add(dr5);
		group4.add(dr6);group4.add(dr7);group4.add(dr8);group5.add(dr9);
				
		
		
		//PANEL3
		JPanel panel3=new JPanel();
		panel3.setBounds(0,250,300,250);
		anaEkran.add(panel3);
		panel3.setBackground(Color.gray);
		JButton b3=new JButton("Click");
		panel3.add(b3);
		
		String hours[]= {"09.00","10.00","11.00","12.00","14.00","15.00","16.00"};
		String days[]= {"Monday","Tuesday","Wednesday","Thursday","Friday"};
		final JComboBox cb1=new JComboBox(days);
		final JComboBox cb2=new JComboBox(hours);
		
		
		
		panel3.add(cb1);panel3.add(cb2);
		panel3.setVisible(false);
		
		
		//PANEL4
		JPanel panel4=new JPanel();
		anaEkran.add(panel4);
		panel4.setBounds(300,250, 300, 250);
		panel4.setBackground(Color.gray);
		panel4.setVisible(false);
		JButton submit=new JButton("Submit");
		panel4.add(submit);
		
		
		
		
		
		
		
		//ACTION LISTNERS
		
		rb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingClinic(1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		rb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingClinic(2);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		rb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingClinic(3);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		rb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingClinic(4);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )  {
			
				
				if(rb1.isSelected()) {
					
					dr1.setVisible(true);
					dr2.setVisible(true);
					panel2.setVisible(true);
					panel2.setLayout(null);
					dr3.setVisible(false);
					dr4.setVisible(false);dr5.setVisible(false);dr6.setVisible(false);
					dr7.setVisible(false);dr8.setVisible(false);dr9.setVisible(false);
					
					dr1.setBounds(10,20,150,30);
					dr2.setBounds(10,60,150,30);
					b2.setBounds(10, 100, 150, 30);
					
					
					
				}
				
				if(rb2.isSelected()) {
					
					dr3.setVisible(true);
					dr4.setVisible(true);
					dr5.setVisible(true);
					dr1.setVisible(false);dr2.setVisible(false);dr6.setVisible(false);
					dr7.setVisible(false);dr8.setVisible(false);dr9.setVisible(false);
					panel2.setVisible(true);
					panel2.setLayout(null);
					dr3.setBounds(10,20,150,30);
					dr4.setBounds(10,60,150,30);
					dr5.setBounds(10, 100, 150, 30);
					b2.setBounds(10, 140, 150, 30);
				}
				
				if(rb3.isSelected()) {
					
					panel2.setLayout(null);
					dr6.setVisible(true);
					dr7.setVisible(true);
					dr8.setVisible(true);
					panel2.setVisible(true);
					dr1.setVisible(false);dr2.setVisible(false);dr3.setVisible(false);
					dr4.setVisible(false);dr5.setVisible(false);dr9.setVisible(false);
				
					dr6.setBounds(10,20,150,30);
					dr7.setBounds(10,60,150,30);
					dr8.setBounds(10, 100, 150, 30);
					b2.setBounds(10, 135, 120, 30);
					
				}
				
				if(rb4.isSelected()) {
		
					dr9.setVisible(true);
					panel2.setVisible(true);
					panel2.setLayout(null);
					dr9.setBounds(10,20,120,30);
					b2.setBounds(10, 60, 120, 30);
					
					dr1.setVisible(false);dr2.setVisible(false);dr3.setVisible(false);
					dr4.setVisible(false);dr5.setVisible(false);dr6.setVisible(false);
					dr7.setVisible(false);dr8.setVisible(false);
				}
			
			
			
				panel2.setVisible(true);
			}
			
			
		});
		
		dr1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		dr2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		dr3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		dr4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(4);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		dr5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(5);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		dr6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(6);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		dr7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(7);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		dr8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(8);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		dr9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					islemler.choosingDoctor(9);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )  {
				
				cb1.setVisible(true);
				cb2.setVisible(true);
				panel3.setLayout(null);
				panel3.setVisible(true);
				cb1.setBounds(10,20,100,30);
				cb2.setBounds(10,60,100,30);
				b3.setBounds(10, 100, 100, 30);
				
					
				
				
			panel3.setVisible(true);
				
			}
			
			
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )  {
				
				panel4.setVisible(true);
				
				
			}
			
			
		});
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e )  {
				JOptionPane.showMessageDialog(anaEkran,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);
				anaEkran.setVisible(false);
				new DecisionScreen();
				
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
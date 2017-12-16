//import java.awt.FlowLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.sql.rowset.JdbcRowSet;
import javax.swing.*;
import java.sql.*;


public class LoginScreen implements ActionListener {
	PersonIslemler islemler = new PersonIslemler();
	JFrame f;
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField pf1 = new JTextField();
	//JPasswordField pf1;
	JButton b1=new JButton("Apply");
		   
	LoginScreen(){
		f=new JFrame("Register New Patient");
		f.setVisible(true);
		f.setSize(600, 600);
		JLabel l1=new JLabel("Ad: ");
		l1.setBounds(50,50, 150,20);
		JLabel l2=new JLabel("Soyad: ");
		l2.setBounds(50,100, 150,20);
		JLabel l3=new JLabel("SSN:");
		l3.setBounds(50,150, 150,20);
		JLabel l4=new JLabel("Email:");
		l4.setBounds(50,200,150,20);
		JLabel l5=new JLabel("Password:");
		l5.setBounds(50,250,150,20);
		tf1.setBounds(170,50, 150,20);
		tf2.setBounds(170,100, 150,20);
		tf3.setBounds(170,150, 150,20);
		tf4.setBounds(170,200, 150,20);
		pf1.setBounds(170,250, 150,20);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);
		f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(pf1);
		f.setLayout(null);
		
		
		b1.setBounds(170,300,150,20);
		f.add(b1);
		b1.addActionListener(this);
			
	}
	

	public void actionPerformed(ActionEvent e) { 
		String ad = tf1.getText();
		String soyad = tf2.getText();
		String ssn = tf3.getText();
		String email = tf4.getText();
		String password = pf1.getText();
		try {
			islemler.kaydet(ad, soyad, ssn, email, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		f.setVisible(false);
		new Test();
	      
	}
}

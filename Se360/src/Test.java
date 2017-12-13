import javax.swing.*;  
import java.sql.*;
import java.awt.*;  
import java.awt.event.*;
import java.util.Arrays;  

public class Test {
	PersonIslemler islemler = new PersonIslemler();
	static JDialog girisEkrani;//ekranýn kapanmasý için static olmasý gerek
	JFrame anaEkran;
	JButton login;
	JTextField Tusername;
	JPasswordField Tpassword;
	JLabel Lusername,Lpassword;
	JButton newPatient;
	
	Test(){
		
		girisEkrani = new JDialog(anaEkran,"Dialog Example",true);
		
		newPatient=new JButton("New Patient");
		girisEkrani.add(newPatient);
		newPatient.setBounds(0, 10, 200, 30);
		newPatient.addActionListener(new ActionListener(){
		
		            public void actionPerformed( ActionEvent e)  
		            {  
		            	girisEkrani.setVisible(false);
		            	new LoginScreen();
		            }  });  
			
		
		Lusername = new JLabel("SSN : "); // Social Security Number
		Lusername.setBounds(100, 100, 100, 30);
		girisEkrani.add(Lusername);
		Lpassword = new JLabel("Password : ");
		Lpassword.setBounds(100, 200, 100, 30);
		girisEkrani.add(Lpassword);
		
		Tusername = new JTextField();
		Tusername.setBounds(200, 100, 110, 30);
		girisEkrani.add(Tusername);
		
		Tpassword = new JPasswordField();
		Tpassword.setBounds(200, 200, 110, 30);
		girisEkrani.add(Tpassword);
		


		login = new JButton("Login");
		login.setBounds(300, 300, 100, 20);
		girisEkrani.add(login);	
		
		login.addActionListener ( new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String ssn = Tusername.getText();
				String parola = new String(Tpassword.getPassword());
				try {
					boolean girisBasarili = islemler.girisYap(ssn,parola);
					if (girisBasarili == true) {
						System.out.println("Giriþ Baþarýlý");
						girisEkrani.setVisible(false);
						new MainScreen();
					}
					else {
						System.out.println("Giriþ Baþarýsýz");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
		} );
		
		girisEkrani.setSize(800,600);
		girisEkrani.setLayout(null);
		girisEkrani.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new Test();

	}

}

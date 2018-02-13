import javax.swing.*; 
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
 

public class Test {
	PersonIslemler islemler = new PersonIslemler();
	static JDialog girisEkrani;
	JFrame anaEkran;
	JButton login;
	JTextField Tusername;
	JPasswordField Tpassword;
	JLabel Lusername,Lpassword;
	JButton newPatient;
	JButton admin;
	JLabel warning;
	
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
		

		warning= new JLabel();
		girisEkrani.add(warning);
		warning.setBounds(200, 260, 210, 30);
		
		
		login = new JButton("Login");
		login.setBounds(300, 300, 100, 20);
		girisEkrani.add(login);	
		
		login.addActionListener ( new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String ssn = Tusername.getText();
				String password = new String(Tpassword.getPassword());
				//admin ve normal user arasýnda distinction yapmayý denedik
				/*try {
				if(Tusername.getText() != "admin" && new String(Tpassword.getPassword()) != "admin") {
					new MainScreen();
					
				}
				else {
					new DecisionScreen();
			}
			}catch(Exception Ex) {
				System.out.println("Error in admin section.");
			}*/
				try {
					boolean girisBasarili = islemler.girisYap(ssn,password);
					if (girisBasarili == true) {
						System.out.println("Succeseed.");
						girisEkrani.setVisible(false);
						new DecisionScreen();
							
						
					}
					else {
						System.out.println("Wrong Password or SSN");
						warning.setVisible(true);
						warning.setText("Wrong Password or SSN");
						warning.setForeground(Color.red);
						
						
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

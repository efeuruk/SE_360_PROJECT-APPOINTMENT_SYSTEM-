	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class PersonIslemler {
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement ps = null;
	
	//first screen, takes ssn and a password
	public boolean girisYap(String ssn,String password) throws SQLException {
		String sorgu = "Select * From patients where ssn = ? and password = ?";
		ps = con.prepareStatement(sorgu); // sorguyu yolladýk
		ps.setString(1, ssn);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		return rs.next();
		
	}
	
	public boolean adminGiris(String ssn,String password) throws SQLException{
		String sorgu="Select * From patients where ssn='admin' and password='admin'";
		ps=con.prepareStatement(sorgu);
		ps.setString(1, ssn);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		return rs.next();
		
	}
	
	//mail function
	public boolean sendMail(String email) throws SQLException{
		String sorgu="Select email from patients";
		ps=con.prepareStatement(sorgu);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		return rs.next();
		
		
	}
	
	//login screen's function for new patients
	public void kaydet(String ad,String soyad,String ssn,String password) throws SQLException {
		String sorgu = "Insert into patients(ad,soyad,ssn,password) values (?,?,?,?)";
		ps = con.prepareStatement(sorgu);
		ps.setString(1, ad);
		ps.setString(2, soyad);
		ps.setString(3, ssn);
		//ps.setString(4, email);
		ps.setString(4, password);
		ps.executeUpdate();
	}
	
	//making a save to appointment table
		public void saveToAppointmentTable(String doctor,String clinic,String day,String hour) throws SQLException {
			String s = "Insert into appointment(doctor,clinic,day,hour) values (?,?,?,?)";
			ps = con.prepareStatement(s);
			ps.setString(1, doctor);
			ps.setString(2, clinic);
			ps.setString(3, day);
			ps.setString(4, hour);
			ps.executeUpdate();
		}
		
		
		
	public PersonIslemler() {
		String url="jdbc:mysql://"+PersonDB.host+":"+PersonDB.port+"/"+PersonDB.db_name+"?useUnicode=true&characterEncoding=utf8";
				try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception ex) {
			System.out.println("Driver can't be found....");
		}
		try {
			con = DriverManager.getConnection(url,PersonDB.username,PersonDB.password);
			System.out.println("Connection is succeed....");
		}catch(Exception ex) {
			System.out.println("Connection is failed....");
		}
	}
}

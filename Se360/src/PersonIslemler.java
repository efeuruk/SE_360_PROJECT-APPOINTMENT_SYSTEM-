import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonIslemler {
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement ps = null;
	
	public boolean girisYap(String ssn,String password) throws SQLException {
		String sorgu = "Select * From patients where ssn = ? and password = ?";
		ps = con.prepareStatement(sorgu); // sorguyu yollad�k
		ps.setString(1, ssn);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
		
	}
	
	
	
	public void kaydet(String ad,String soyad,String ssn,String email,String password) throws SQLException {
		String sorgu = "Insert into patients(ad,soyad,ssn,email,password) values (?,?,?,?,?)";
		ps = con.prepareStatement(sorgu);
		ps.setString(1, ad);
		ps.setString(2, soyad);
		ps.setString(3, ssn);
		ps.setString(4, email);
		ps.setString(5, password);
		ps.executeUpdate();
	}
	
	public void choosingClinic(int id) throws SQLException {
		String sorgu = "Select name from clinics where id = ?";
		ps = con.prepareStatement(sorgu);
		ps.setInt(1, id);
		ps.executeQuery();
	}
	
	public void choosingDoctor(int id) throws SQLException {
		String sorgu = "Select name from doctors where id = ?";
		ps = con.prepareStatement(sorgu);
		ps.setInt(1, id);
		ps.executeQuery();
	}
	
	public void choosingHour(int id) throws SQLException {
		String sorgu = "Select hour from doctors where id = ?";
		ps = con.prepareStatement(sorgu);
		ps.setInt(1, id);
		ps.executeQuery();
	}
	
	public void choosingDay(int id) throws SQLException {
		String sorgu = "Select day from  where id = ?";
		ps = con.prepareStatement(sorgu);
		ps.setInt(1, id);
		ps.executeQuery();
	}
	
	
	public PersonIslemler() {
		String url="jdbc:mysql://"+PersonDB.host+":"+PersonDB.port+"/"+PersonDB.db_ismi+"?useUnicode=true&characterEncoding=utf8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception ex) {
			System.out.println("Driver Bulunamad�....");
		}
		try {
			con = DriverManager.getConnection(url,PersonDB.kullan�c�_ad�,PersonDB.parola);
			System.out.println("Ba�lant� Ba�ar�l�....");
		}catch(Exception ex) {
			System.out.println("Ba�lant� Ba�ar�s�z....");
		}
	}
}

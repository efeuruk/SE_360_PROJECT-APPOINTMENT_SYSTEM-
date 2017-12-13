
public class Person {
	private String Ad;
	private String Soyad;
	private String SSN;
	private String Email;
	private String Password;
	
	public Person() {
		this.Ad=Ad;
		this.Soyad=Soyad;
		this.SSN=SSN;
		this.Email=Email;
		this.Password=Password;
		
	}
	
	void setAd(String Ad) {
		this.Ad=Ad;
	}
	
	void setSoyad(String Soyad) {
		this.Soyad=Soyad;
	}
	void setSSN(String SSN) {
		this.SSN=SSN;
	}
	void setEmail(String Email) {
		this.Email=Email;
	}
	void setPassword(String Password) {
		this.Password=Password;
	}
	
	String getAd() {
		return Ad;
	}
	
	String getSoyad() {
		return Soyad;
	}
	
	String getSSN() {
		return SSN;
	}
	
	String getEmail() {
		return Email;
	}
	
	String getPassword() {
		return Password;
	}

}

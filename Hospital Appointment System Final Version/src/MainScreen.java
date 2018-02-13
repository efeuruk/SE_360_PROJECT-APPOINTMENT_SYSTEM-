import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
//
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import java.util.Properties;
public class MainScreen implements ActionListener {
	Connection con = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	PersonIslemler islemler = new PersonIslemler();
	JFrame f = new JFrame("MainScreen");
	JComboBox ClinicCombo = new JComboBox();
	JComboBox DoctorCombo = new JComboBox();
	JComboBox DayCombo = new JComboBox();
	JComboBox HourCombo = new JComboBox();
	JButton Send = new JButton("Send");
	JButton Back = new JButton("Back");
	final JLabel label1=new JLabel();
	final JLabel label2=new JLabel();
	final JLabel label3=new JLabel();
	final JLabel label4=new JLabel();
	JTextField mailfield;
	JButton mailbutton;
	MainScreen(){
		String dbUrl = "jdbc:mysql://localhost:3308/demo";
		String user = "root";
		String password = "";
		
		//Clinic ComboBox
		try {
			con = DriverManager.getConnection(dbUrl,user,password);
			stm = con.createStatement();
			rs = stm.executeQuery("select distinct Clinic from doctors");
			while(rs.next()) {
				ClinicCombo.addItem(rs.getString(1));
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		ClinicCombo.setBounds(10,20,150,20);
		f.add(ClinicCombo);
		//Clinic ComboBox Finish
		
		//Day ComboBox
		try {
			con = DriverManager.getConnection(dbUrl,user,password);
			stm = con.createStatement();
			rs = stm.executeQuery("select name from doctors");
			while(rs.next()) {
				DoctorCombo.addItem(rs.getString(1));
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DoctorCombo.setBounds(10,70,185,20);
		f.add(DoctorCombo);
		//Doctor ComboBox Finish
		
		//Day ComboBox
		try {
			con = DriverManager.getConnection(dbUrl,user,password);
			stm = con.createStatement();
			rs = stm.executeQuery("select day from days");
			while(rs.next()) {
				DayCombo.addItem(rs.getString(1));
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		DayCombo.setBounds(10,120,150,20);
		f.add(DayCombo);
		//Day ComboBox finish
		
		//Hour ComboBox
		try {
			con = DriverManager.getConnection(dbUrl,user,password);
			stm = con.createStatement();
			rs = stm.executeQuery("select hour from hours");
			while(rs.next()) {
				HourCombo.addItem(rs.getString(1));
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		HourCombo.setBounds(10,170,150,20);
		f.add(HourCombo);
		//Hour ComboBox finish
  
		//labels
		label1.setBounds(10,270,200,30);
		label2.setBounds(10,320,200,30);
		label3.setBounds(10,370,200,30);
		label4.setBounds(10,420,200,30);
		f.add(label1); f.add(label2); f.add(label3); f.add(label4);
		//labels finish
  
		//Send Button
		Send.setBounds(40, 350, 100, 20);
		f.add(Send);
		Send.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String doctor = (String) DoctorCombo.getItemAt(DoctorCombo.getSelectedIndex());
			String clinic = (String) ClinicCombo.getItemAt(ClinicCombo.getSelectedIndex());
			String day = (String) DayCombo.getItemAt(DayCombo.getSelectedIndex());
			String hour = (String) HourCombo.getItemAt(HourCombo.getSelectedIndex());
			try {
				islemler.saveToAppointmentTable(doctor,clinic,day,hour);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
		JLabel text1=new JLabel("Enter your email for appointment report");
		text1.setBounds(10,220,240,20);
		f.add(text1);
		mailfield=new JTextField();
		mailfield.setBounds(10, 240, 150, 20);
		mailbutton=new JButton("Send Mail");
		mailbutton.setBounds(10,260,100,20);
		f.add(mailfield);
		f.add(mailbutton);
		JLabel warning=new JLabel();
		f.add(warning);
		warning.setBounds(10,280,120,20);
  
		mailbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  
				String mailinclude=(mailfield.getText());
		  
				if(!(mailinclude.contains("@gmail.com"))) {
			  
					warning.setText("Incomplete e-mail");
					warning.setForeground(Color.RED);
			  
				}
				else {
					warning.setForeground(Color.RED);
					warning.setText("Mail delivered");
					mailbutton.setEnabled(false);
		  
		  final String from = "berksoft35@gmail.com"; // 
          final String password = "kralberk"; // 
          String to = mailfield.getText(); // BURAYA KENDI MAILINI YAZ SIMDILIK
          String host = "smtp.gmail.com"; // or IP address
          
          Properties properties = System.getProperties();
          properties.put("mail.smtp.host", host);
          properties.put("mail.smtp.port", 587);
          properties.put("mail.smtp.auth", "true");
          properties.put("mail.smtp.starttls.enable", "true");
          properties.put("mail.user", from);
          properties.put("mail.password", password);
          
          Authenticator auth = new Authenticator()
          {
              public PasswordAuthentication getPasswordAuthentication()
              {
                  return new PasswordAuthentication(from,password);
              }
          };
          Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        	    protected PasswordAuthentication getPasswordAuthentication() {
        	        return new PasswordAuthentication(from, password);
        	    }
        	});
          try
          {
             // Create a default MimeMessage object.
             MimeMessage message = new MimeMessage(session);
             // Set From: header field of the header.
             message.setFrom(new InternetAddress(from));
             // Set To: header field of the header.
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
             // Set Subject: header field
             message.setSubject("Appointment Details");
             
             String doctor = (String) DoctorCombo.getItemAt(DoctorCombo.getSelectedIndex());
             String clinic = (String) ClinicCombo.getItemAt(ClinicCombo.getSelectedIndex());
             String day = (String) DayCombo.getItemAt(DayCombo.getSelectedIndex());
             String hour = (String) HourCombo.getItemAt(HourCombo.getSelectedIndex());
             
             String data=clinic+"\n"+doctor+"\n"+day+"\n"+hour+"\n Have a lovely day";
             // Now set the actual message
             message.setText(data);
             // Send message
             Transport.send(message);
             System.out.println("Sent message successfully....");
          }
          catch (SendFailedException mex)
          {
             mex.printStackTrace();
          } catch (AddressException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   } catch (MessagingException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }
          
		  }
  }
	  
});
  
  
  
  
		Back.setBounds(40,400,100,20);
		f.add(Back);
		Back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new DecisionScreen();
    
			}
		});
  
		f.setLayout(null);
		f.setSize(300, 600);
		f.setVisible(true);
 }
	public static void main(String[] args) {
		new MainScreen();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
  
	}
}
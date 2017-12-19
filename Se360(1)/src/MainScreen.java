import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

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
			System.out.println("Error.");
		}
		ClinicCombo.setBounds(10,20,150,20);
		f.add(ClinicCombo);
		//Clinic ComboBox Finish
		
		//Day ComboBox
		try {
			con = DriverManager.getConnection(dbUrl,user,password);
			stm = con.createStatement();
			rs = stm.executeQuery("select Name from doctors");
			while(rs.next()) {
				DoctorCombo.addItem(rs.getString(1));
			}
			
			
		}catch(Exception ex) {
			System.out.println("Error.");
		}
		DoctorCombo.setBounds(10,70,150,20);
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
			System.out.println("Error.");
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
			System.out.println("Error.");
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
		Send.setBounds(40, 220, 100, 20);
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
		
		Back.setBounds(40,270,100,20);
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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CheckAppointment implements ActionListener {
	PersonIslemler islemler = new PersonIslemler();
	Connection con = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	JFrame f = new JFrame("CheckAppointmentScreen");
	static JTable table = new JTable();
	JButton back = new JButton("Back");
	//String[] columnNames = {"Doctor", "Clinic", "Day", "Hour"};
	
	CheckAppointment(){
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		String dbUrl = "jdbc:mysql://localhost:3308/demo";
		String user = "root";
		String password = "";
		
		try {
			con = DriverManager.getConnection(dbUrl,user,password);
			stm = con.createStatement();
			rs = stm.executeQuery("select * from appointment");
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			//Getting column names
			for(int i=1;i<=columns;i++) {
				columnNames.add(md.getColumnName(i));
			}
			//Getting row data
			while (rs.next())
            {
				ArrayList row = new ArrayList(columns);
				for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }
					data.add(row);
            }

			
		}catch(Exception ex) {
			System.out.println("Error.");
		}
		
		 Vector columnNamesVector = new Vector();
	        Vector dataVector = new Vector();

	        for (int i = 0; i < data.size(); i++)
	        {
	            ArrayList subArray = (ArrayList)data.get(i);
	            Vector subVector = new Vector();
	            for (int j = 0; j < subArray.size(); j++)
	            {
	                subVector.add(subArray.get(j));
	            }
	            dataVector.add(subVector);
	        }

	        for (int i = 0; i < columnNames.size(); i++ )
	            columnNamesVector.add(columnNames.get(i));

	        //  Create table with database data    
	        JTable table = new JTable(dataVector, columnNamesVector)
	        {
	            public Class getColumnClass(int column)
	            {
	                for (int row = 0; row < getRowCount(); row++)
	                {
	                    Object o = getValueAt(row, column);

	                    if (o != null)
	                    {
	                        return o.getClass();
	                    }
	                }

	                return Object.class;
	            }
	        };

	        JScrollPane scrollPane = new JScrollPane( table );
	        f.getContentPane().add( scrollPane );

	        JPanel buttonPanel = new JPanel();
	        f.getContentPane().add( buttonPanel, BorderLayout.SOUTH );
	        table.setBounds(0,0,600,300);
	        f.add(table);
	        
	        //back button
	        back.setBounds(200, 300, 100, 20);
	        f.add(back);
	        back.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		f.setVisible(false);
	        		new DecisionScreen();
	        		
	        	}
	        });
	        
	        f.setLayout(null);
	        f.setSize(490, 400);
	        f.setVisible(true);
	}
	public static void main(String[] args) {
		new CheckAppointment();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

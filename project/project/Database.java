package project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

import tables.Administers;
import tables.Admit;
import tables.AssignDoc;
import tables.Diagnosis;
import tables.Employee;
import tables.Orders;
import tables.Patient;
import tables.Room;
import tables.Services;
import tables.StaffProvide;
import tables.Table;
import tables.Treatment;
import tables.VolProvide;
import tables.Volunteer;

public class Database implements Queries {
	Connection con = null;

	private static final HashMap<String, String> tables;
	static {
		tables = new HashMap<String, String>();

		tables.put("employee", employee);
		tables.put("volunteer", volunteer);
		tables.put("services", services);
		tables.put("treatment", treatment);
		tables.put("patient", patient);
		tables.put("diagnosis", diagnosis);
		tables.put("room", room);
		tables.put("admit", admit);
		tables.put("volProvide", volprovide);
		tables.put("staffProvide", staffprovide);
		tables.put("assignDoc", assigndoc);
		tables.put("orders", orders);
		tables.put("administers", administers);
		tables.put("A1", A1);
		tables.put("A2", A2);
		tables.put("A3", A3);
		tables.put("B1", B1);
		tables.put("B2", B2);
		tables.put("B3", B3);
		tables.put("B4", B4);
		tables.put("B5", B5);
		tables.put("B6", B6);
		tables.put("B7", B7);
		tables.put("B8", B8);
		tables.put("B9", B9);
		tables.put("B10", B10);
		tables.put("C1", C1);
		tables.put("C2", C2);
		tables.put("C3", C3);
		tables.put("C4", C4);
		tables.put("C5", C5);
		tables.put("C6", C6);
		tables.put("C7", C7);
		tables.put("C8", C8);
		tables.put("D1", D1);
		tables.put("D2", D2);
		tables.put("D3", D3);
		tables.put("D4", D4);
		tables.put("D5", D5);
		tables.put("D6", D6);
		tables.put("D7", D7);
	}

	private static final HashMap<String, Table> ic;
	static {
		ic = new HashMap<String, Table>();

		ic.put("employee insert", new Employee());
		ic.put("volunteer insert", new Volunteer());
		ic.put("administer insert", new Administers());
		ic.put("admitinsert", new Admit());
		ic.put("assignDoc insert", new AssignDoc());
		ic.put("services insert", new Services());
		ic.put("treatment insert", new Treatment());
		ic.put("diagnosis insert", new Diagnosis());
		ic.put("patient insert", new Patient());
		ic.put("room insert", new Room());
		ic.put("volprovide insert", new VolProvide());
		ic.put("staffprovide insert", new StaffProvide());
		ic.put("orders insert", new Orders());
	}

	public void connect() {
		String url = "jdbc:postgresql://131.204.27.85:5432/typhoan";
		String user = "irm0003";
		String password = "ian";
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void execute(String str) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		StringBuilder table = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			if (tables.containsKey(str)) {
				pst = con.prepareStatement(tables.get(str));
				pst.execute();
				rs = pst.getResultSet();
				rsmd = rs.getMetaData();

				int numOfCol = rsmd.getColumnCount();
				int colWidth = 20;
			    String colFormat = "%-" + colWidth + "s";

			    table.append("\n");
			    
			    for (int i = 1; i <= numOfCol; i++) {
			    	table.append(String.format(colFormat, rsmd.getColumnLabel(i)));
			    }
			    table.append("\n");
			    
				while (rs.next()) {
					for (int i = 1; i <= numOfCol; ++i) {
						table.append(String.format(colFormat, rs.getString(i)));
					}
					table.append("\n");
				}
				
				System.out.println(table.toString());
			} else {
				System.out.println("Query failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try
      		{
         		String tmp = null;
		        while(true)
	         	{
            			System.out.print("Press enter to continue... ");
			        tmp = br.readLine().trim();
			        if (tmp != null)
			        	break;
        		}
      		} catch (IOException e) {
	      		e.printStackTrace();
		}
	}

	public void add(String str, BufferedReader br) {
		PreparedStatement pst = null;

		try {
			if (ic.containsKey(str)) {
				pst = con.prepareStatement(ic.get(str).getStatement());
				
				try {
					ic.get(str).getPreparedStatement(br, pst);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				pst.executeUpdate();
			} else {
				System.out.println("Query failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try{
         		String tmp = null;
		        while(true)
	         	{
            			System.out.print("Press enter to continue... ");
			        tmp = br.readLine().trim();
			        if (tmp != null)
			        	break;
        		}
      		} catch (IOException e) {
	      		e.printStackTrace();
		}
	}

	public void add(String str, String comment, BufferedReader br) {
		PreparedStatement pst = null;

		try {
			if (ic.containsKey(str)) {
				pst = con.prepareStatement(ic.get(str).getStatement());
				System.out.println(comment);
				try {
					ic.get(str).getPreparedStatement(br, pst);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				pst.executeUpdate();
			} else {
				System.out.println("Query failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try
      		{
         		String tmp = null;
		        while(true)
	         	{
            			System.out.print("Press enter to continue... ");
			        tmp = br.readLine().trim();
			        if (tmp != null)
			        	break;
        		}
      		} catch (IOException e) {
	      		e.printStackTrace();
		}
	}
	
	public void display() {
		for (String s : tables.keySet()) {
			System.out.println(s);
		}
	}
	
	public void commands() {
		for (String s : ic.keySet()) {
			System.out.println(s);
		}
	}
}

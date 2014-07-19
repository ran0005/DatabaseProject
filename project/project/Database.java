package project;

import java.io.BufferedReader;
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

		try {
			if (tables.containsKey(str)) {
				pst = con.prepareStatement(tables.get(str));
				pst.execute();
				rs = pst.getResultSet();
				rsmd = rs.getMetaData();

				int col = rsmd.getColumnCount();

				System.out.println();

				while (rs.next()) {
					for (int i = 0; i < col; ++i) {
						System.out.print(rs.getString(i + 1));
					}
					System.out.println();
				}
			} else {
				System.out.println("Query failed");
			}
		} catch (SQLException e) {
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
package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import tables.*;

public class Database implements Queries {
	static Connection con = null;

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
		tables.put("A1", qA1);
		tables.put("A2", qA2);
		tables.put("A3", qA3);
		tables.put("B1", qB1);
		tables.put("B2", qB2);
		tables.put("B4", qB4);
		tables.put("B5", qB5);
		tables.put("B6", qB6);
		tables.put("B7", qB7);
		tables.put("B8", qB8);
		tables.put("B9", qB9);
		tables.put("B10", qB10);
		tables.put("C1", qC1);
		tables.put("C2", qC2);
		tables.put("C3", qC3);
		tables.put("C4", qC4);
		tables.put("C5", qC5);
		tables.put("C6", qC6);
		tables.put("C7", qC7);
		tables.put("C8", qC8);
		tables.put("D1", qD1);
		tables.put("D2", qD2);
		tables.put("D3", qD3);
		tables.put("D4", qD4);
		tables.put("D5", qD5);
		tables.put("D6", qD6);
		tables.put("D7", qD7);
		tables.put("U1", qU1);
		tables.put("U2", qU2);
		tables.put("U3", qU3);
		tables.put("U4", qU4);
		tables.put("U5", qU5);
	}

	private static final HashMap<String, Table> ic;
	static {
		ic = new HashMap<String, Table>();

		ic.put("employee insert", new Employee());
		ic.put("volunteer insert", new Volunteer());
		ic.put("administer insert", new Administers());
		ic.put("admit insert", new Admit());
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

	private static HashMap<String, UpdateTable> uc = new HashMap<String, UpdateTable>();

	public void populateUpdateCommands() {
		uc.put("B3", new B3(con));
		uc.put("B4", new B4(con));
		uc.put("B6", new B6(con));
		uc.put("B7", new B7(con));
		uc.put("B8", new B8(con));
		uc.put("C8", new C8(con));
		uc.put("D4", new D4(con));
		uc.put("D5", new D5(con));
		uc.put("D6", new D6(con));
		uc.put("U1", new U1(con));
		uc.put("U2", new U2(con));
		uc.put("U3", new U3(con));
		uc.put("U5", new U5(con));
	}

	public void connect() {
		String url = "jdbc:postgresql://131.204.27.85:5432/typhoan";
		String user = "irm0003";
		String password = "ian";
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed.");
			populateUpdateCommands();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static Connection getConnection() {
		return con;
	}

	public void execute(String str) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = con.prepareStatement(tables.get(str));
			pst.execute();
			rs = pst.getResultSet();
			displayFormattedTable(rs);
		} catch (SQLException e) {
			System.out.println("Data could not be retrieved");
		}
	}

	public void execute(String str, BufferedReader br) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = uc.get(str).prepareStatement();

			try {
				uc.get(str).getPreparedStatement(br, pst);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			pst.execute();
			rs = pst.getResultSet();
			displayFormattedTable(rs);
		} catch (SQLException e) {
			System.out.println("Data could not be retrieved");
		}

	}

	public void add(String str, BufferedReader br) {
		PreparedStatement pst = null;

		try {

			pst = con.prepareStatement(ic.get(str).getStatement());

			try {
				ic.get(str).getPreparedStatement(br, pst);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Unable to add information to database");
		}

	}

	public void add(String str, String comment, BufferedReader br) {
		PreparedStatement pst = null;

		try {

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

		} catch (SQLException e) {
			System.out.println("Unable to add information to database");
		}

	}

	public void update(String str, int type, BufferedReader br) {
		PreparedStatement pst = null;
		if (type == 1)
			execute("B2");
		else if (type == 2)
			execute("B5");
		else if (type == 3)
			execute("U4");
		else if (type == 4)
			execute("A2");

		try {
			if (uc.containsKey(str)) {
				pst = uc.get(str).prepareStatement();
				try {
					uc.get(str).getPreparedStatement(br, pst);
				} catch (IOException e) {
					e.printStackTrace();
				}
				pst.executeUpdate();
			} else {
				System.out.println("Query failed");
			}
		} catch (SQLException e) {
			System.out.println("Operation failed due to unexpected results");
		}
	}

	public void pause() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String tmp = null;
			while (true) {
				System.out.print("Press enter to continue... ");
				tmp = br.readLine().trim();
				if (tmp != null) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void displayFormattedTable(ResultSet rs) throws SQLException {
		StringBuilder table = new StringBuilder();
		int numOfCol = rs.getMetaData().getColumnCount();
		int colWidth;
		String colFormats[] = new String[numOfCol];

		table.append("\n");

		for (int i = 1; i <= numOfCol; i++) {
			colWidth = rs.getMetaData().getColumnDisplaySize(i);
			if (colWidth > 40) colWidth = 27;
			else if (colWidth < 5) colWidth = 7;
			colFormats[i - 1] = "%-" + colWidth + "s";
			table.append(String.format(colFormats[i - 1], rs.getMetaData()
					.getColumnLabel(i)));
		}
		table.append("\n");

		while (rs.next()) {
			for (int i = 1; i <= numOfCol; ++i) {
				table.append(String.format(colFormats[i - 1], rs.getString(i)));
			}
			table.append("\n");
		}

		System.out.println(table.toString());
	}
}

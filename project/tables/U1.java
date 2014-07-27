package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class U1 extends UpdateTable {
	private Connection con;
	private static int pID;

	public U1(Connection con) {
		this.con = con;
	}

	public static int getPID() {
		return pID;
	}

	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qU1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qU1;
	}

	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {

		String temp = "";

		System.out.print("Please enter Admin ID: ");
		temp = br.readLine().trim();
		int empid = -1;
		try {
			empid = Integer.parseInt(temp);
		} catch (NumberFormatException e) {
			System.out.println("Only numbers are accepted for this field");
			return;
		}

		if (Constraint.checkEmpIDMatchesAdminType(empid) && empid > 0) {
			pst.setInt(1, empid);
		} else {
			System.out.println("Improper employee identification");
			return;
		}

		// check against admit? This as far as I can tell is not catered towards setting information for any in patient being checked out,
		// should ask for patient id right then it can update the info??
		System.out.print("Please enter the end date (YYYY-MM-DD HH:MM): ");
		temp = br.readLine();

		if(!Constraint.checkTimestampFormat(temp)) {
			return;
		}

		pst.setString(2, temp);

		System.out.print("Please enter patient ID to checkout: ");
		temp = br.readLine();
		try {
			pID = Integer.parseInt(temp);
			pst.setInt(3, pID);
		} catch (NumberFormatException e) {
			System.out.println("Only numbers are accepted for this field");
			return;
		}
	}
}

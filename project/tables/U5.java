package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class U5 extends UpdateTable {
	private Connection con;
	private static int pID;

	public U5(Connection con) {
		this.con = con;
	}

	public int getPID() {
		return pID;
	}

	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qU5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qU5;
	}

	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Please enter the room number: ");
		temp = br.readLine();
		if (!Constraint.integerConstraintMatch(pst, 3, temp)) {
			return;
		}
		
		System.out.print("Please enter patient ID: ");
		temp = br.readLine();
		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Please enter the admin ID: ");
		temp = br.readLine().trim();
		int empid = -1;
		try {
			empid = Integer.parseInt(temp);
		} catch (NumberFormatException e) {
			System.out.println("Only numbers are accepted for this field");
			return;
		}

		if (Constraint.checkEmpIDMatchesAdminType(empid) && empid > 0) {
			pst.setInt(2, empid);
		} else {
			System.out.println("Improper employee identification");
			return;
		}
	}

}

package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class U3 extends UpdateTable {
	private Connection con;
	private static int pID;

	public U3(Connection con) {
		this.con = con;
	}

	public int getPID() {
		return pID;
	}

	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qU3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qU3;
	}

	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.println("Please enter Diagnosis ID: ");
		temp = br.readLine();
		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.println("Please enter patient ID to checkout: ");
		temp = br.readLine();
		if (!Constraint.integerConstraintMatch(pst, 2, temp)) {
			return;
		}
	}

}

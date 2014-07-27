package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class Admit extends Table {

	@Override
	public String getStatement() {
		return admitinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "admitting doctor's ID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "diagnosis ID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 2, temp)) {
			return;
		}

		System.out.print("Input value for " + "patient ID" + ": ");
		temp = br.readLine();
		int patID;
		try {
			patID = Integer.parseInt(temp);
			if (!Constraint.checkPatientNotCheckedIn(patID)) {
				return;
			}
		} catch (NumberFormatException e) {
			System.out
				.println("Data Entry Error: only numbers are accepted for this field");
			return;
		}
		
		pst.setInt(3, patID);

		System.out.print("Input value for " + "time of admittance (YYYY-MM-DD HH:MM)" + ": ");
		temp = br.readLine();

		if(!Constraint.checkTimestampFormat(temp)) {
			return;
		}
		
		pst.setString(4, temp);

		System.out.print("Input value for " + "patient type (in or out)" + ": ");
		temp = br.readLine();

		pst.setString(5, temp);
	}
}

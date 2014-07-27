package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class Administers extends Table {

	@Override
	public String getStatement() {
		return administersinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "the order ID" + ": ");
		temp = br.readLine();
		
		if(!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "the administering employee ID" + ": ");
		temp = br.readLine();

		if(!Constraint.integerConstraintMatch(pst, 2, temp)) {
			return;
		}
		
		if (!Constraint.checkEmpIDMatchesNeitherStaffOrAdmin(Integer.parseInt(temp))) {
			return;
		}

		System.out.print("Input value for " + "administration time (YYYY-MM-DD HH:MM)" + ": ");
		temp = br.readLine();

		if(!Constraint.checkTimestampFormat(temp)) {
			return;
		}
		pst.setString(3, temp);
	}
}

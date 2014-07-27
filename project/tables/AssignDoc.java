package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class AssignDoc extends Table {

	@Override
	public String getStatement() {
		return assignDocinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "primary doctor's ID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "secondary doctor's ID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 2, temp)) {
			return;
		}

		System.out.print("Input value for " + "patient ID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 3, temp)) {
			return;
		}

		System.out.print("Input value for " + "time of assigning (YYYY-MM-DD)" + ": ");
		temp = br.readLine();

		if (!Constraint.checkDateFormat(temp)) {
			return;
		}
		
		pst.setString(4, temp);
	}
}

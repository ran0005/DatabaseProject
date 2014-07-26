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

		System.out.print("Input value for " + "admitDocID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "diagID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 2, temp)) {
			return;
		}

		System.out.print("Input value for " + "patID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 3, temp)) {
			return;
		}

		System.out.print("Input value for " + "startTime" + ": ");
		temp = br.readLine();

		if(!Constraint.checkDateFormat(temp)) {
			return;
		}
		
		pst.setString(4, temp);

		System.out.print("Input value for " + "patType" + ": ");
		temp = br.readLine();

		pst.setString(5, temp);

		pst.setInt(6, java.sql.Types.INTEGER);

		pst.setString(7, null);
	}
}

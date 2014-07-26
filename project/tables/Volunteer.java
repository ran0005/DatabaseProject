package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class Volunteer extends Table {

	@Override
	public String getStatement() {
		return volunteerinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "volID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "vFirstName" + ": ");
		temp = br.readLine();

		pst.setString(2, temp);

		System.out.print("Input value for " + "vMInit" + ": ");
		temp = br.readLine();

		if (!Constraint.characterConstraintMatch(pst, 3, temp)) {
			return;
		}

		System.out.print("Input value for " + "vLastName" + ": ");
		temp = br.readLine();

		pst.setString(4, temp);

		System.out.print("Input value for " + "vHiredate" + ": ");
		temp = br.readLine();
		
		if (Constraint.checkDateFormat(temp)) {
			pst.setString(5, temp);
		}
	}
}

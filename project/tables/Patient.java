package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class Patient extends Table {

	@Override
	public String getStatement() {
		return patientinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "patient ID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "the first name" + ": ");
		temp = br.readLine();

		pst.setString(2, temp);

		System.out.print("Input value for " + "the middle initial" + ": ");
		temp = br.readLine();

		if (!Constraint.characterConstraintMatch(pst, 3, temp)) {
			return;
		}

		System.out.print("Input value for " + "the last name" + ": ");
		temp = br.readLine();

		pst.setString(4, temp);

		System.out.print("Input value for " + "the emergency contact" + ": ");
		temp = br.readLine();

		pst.setString(5, temp);

		System.out.print("Input value for " + "insurance" + ": ");
		temp = br.readLine();

		pst.setString(6, temp);
	}
}

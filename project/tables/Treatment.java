package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class Treatment extends Table {

	@Override
	public String getStatement() {
		return treatmentinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "treatment ID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "treatment name" + ": ");
		temp = br.readLine();

		pst.setString(2, temp);

		System.out.print("Input value for " + "treatment type (Medication or Procedure)" + ": ");
		temp = br.readLine();

		pst.setString(3, temp);
	}
}

package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class Employee extends Table {

	@Override
	public String getStatement() {
		return employeeinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "empID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "eFirstName" + ": ");
		temp = br.readLine();

		pst.setString(2, temp);

		System.out.print("Input value for " + "eMInit" + ": ");
		temp = br.readLine();
		
		if (!Constraint.characterConstraintMatch(pst, 3, temp)) {
			return;
		}

		System.out.print("Input value for " + "eLastName" + ": ");
		temp = br.readLine();

		pst.setString(4, temp);

		System.out.print("Input value for " + "eHiredate" + ": ");
		temp = br.readLine();
		
		if (!Constraint.checkDateFormat(temp)) {
			return;
		}
		
		pst.setString(5, temp);

		System.out.print("Input value for " + "eType" + ": ");
		temp = br.readLine();

		pst.setString(6, temp);

	}
}
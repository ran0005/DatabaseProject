package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class Orders extends Table {

	@Override
	public String getStatement() {
		return ordersinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "the order's ID" + ": ");
		temp = br.readLine();

		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}

		System.out.print("Input value for " + "the ordering doctor's ID" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 2, temp)) {
			return;
		}
		
		System.out.print("Input value for " + "the treatment ID" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 3, temp)) {
			return;
		}
		
		System.out.print("Input value for " + "the patient ID" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 4, temp)) {
			return;
		}

		System.out.print("Input value for " + "the time of the order (YYYY-MM-DD HH:MM)" + ": ");
		temp = br.readLine();

		if(!Constraint.checkTimestampFormat(temp)) {
			return;
		}
		
		pst.setString(5, temp);
	}
}

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

		System.out.print("Input value for " + "employee ID" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 2, temp)) {
			return;
		}
		
		System.out.print("Input value for " + "treatment ID" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 3, temp)) {
			return;
		}
		
		System.out.print("Input value for " + "patient ID" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 4, temp)) {
			return;
		}

		System.out.print("Input value for " + "time of the order (YYYY-MM-DD HH:MM)" + ": ");
		temp = br.readLine();

		pst.setString(5, temp);
	}
}

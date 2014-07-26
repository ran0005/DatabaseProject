package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class Room extends Table {

	@Override
	public String getStatement() {
		return roominsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		
		String temp = "";

		System.out.print("Input value for " + "roomNum" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}
		
		System.out.print("Input value for " + "patID" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 2, temp)) {
			return;
		}
		
		System.out.print("Input value for " + "empID" + ": ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 3, temp)) {
			return;
		}
	}
}

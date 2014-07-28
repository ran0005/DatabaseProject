package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class D6 extends UpdateTable {
	private Connection con;
	
	public D6(Connection con) {
		this.con = con;
	}
	
	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qD6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qD6;
	}
	
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, NumberFormatException, SQLException {
		int t1;
		String t2 = "";
		
		System.out.print("Please enter the doctor's employee ID: ");
		t2 = br.readLine();
		t1 = Integer.parseInt(t2);
		
		if (!Constraint.checkEmpIDMatchesPrimaryOrSecondaryDoctor(t1)) {
			return;
		}
		
		if (!Constraint.integerConstraintMatch(pst, 1, t2)) {
			return;
		}

		if (!Constraint.integerConstraintMatch(pst, 2, t2)) {
			return;
		}
	}	
}

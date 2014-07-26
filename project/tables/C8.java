package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class C8 extends UpdateTable {
	private Connection con;
	
	public C8(Connection con) {
		this.con = con;
	}
	
	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qC8);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qC8;
	}
	
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, NumberFormatException, SQLException {
		String temp = "";
		
		System.out.print("Please enter the order ID: ");
		temp = br.readLine();
		
		if (!Constraint.integerConstraintMatch(pst, 1, temp)) {
			return;
		}
	}	
}

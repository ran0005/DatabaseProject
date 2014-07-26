package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Constraint;

public class B3 extends UpdateTable {
	private Connection con;
	
	public B3(Connection con) {
		this.con = con;
	}
	
	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qB3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qB3;
	}
	
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, NumberFormatException, SQLException {
		
		String startdate;
		System.out.print("Please enter the start date (YYYY-MM-DD): ");
		startdate = br.readLine();
		
		if(!Constraint.checkDateFormat(startdate)) {
			return;
		}
		
		pst.setString(1, startdate);
		
		String enddate;
		System.out.print("Please enter the end date (YYYY-MM-DD): ");
		enddate = br.readLine();
		
		if (Constraint.checkDateRange(startdate, enddate)){		
			pst.setString(2, enddate);
		}
	}	
}

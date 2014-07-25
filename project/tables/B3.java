package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class B3 extends UpdateTable {
	private String st;
	private Connection con;
	
	public B3(String st, Connection con) {
		this.st = st;
		this.con = con;
	}
	
	public PreparedStatement prepareStatement() {
		try {
			System.out.println(con.toString());
			return con.prepareStatement(st);
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
		String temp = "";
		
		System.out.println("Please enter the start date (YYYY-MM-DD): ");
		temp = br.readLine();
		pst.setString(1, temp);
		
		System.out.println("Please enter the end date (YYYY-MM-DD): ");
		temp = br.readLine();
		pst.setString(2, temp);
	}	
}

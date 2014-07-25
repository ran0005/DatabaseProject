package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class D5 extends UpdateTable {
	private Connection con;
	
	public D5(Connection con) {
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
		return qD5;
	}
	
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, NumberFormatException, SQLException {
		String temp = "";
		
		System.out.println("Please enter the doctor's employee ID: ");
		temp = br.readLine();
		pst.setString(1, temp);
	}	
}

package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public class B7 extends UpdateTable {
	private Connection con;
	
	public B7(Connection con) {
		this.con = con;
	}
	
	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qB7);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qB7;
	}
	
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, SQLException {
		String temp = "";
		try {
		System.out.print("Please enter the patient identifcation number: ");
		temp = br.readLine();
		pst.setInt(1, Integer.parseInt(temp));
		}
		catch (NumberFormatException err)
		{
			System.out.println("Invalid Input");
		}
		catch (PSQLException e)
		{
			System.out.println("Invalid Input");
		}
	}	
}

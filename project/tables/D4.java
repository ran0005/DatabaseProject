package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.postgresql.util.PSQLException;

public class D4 extends UpdateTable {
	private Connection con;
	
	public D4(Connection con) {
		this.con = con;
	}
	
	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qD4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qD4;
	}
	
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException {
		String temp = "";
		
		System.out.print("Enter the doctor's employee ID: ");
		temp = br.readLine();
		try {
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
		catch (SQLException e)
		{
			System.out.print("Invalid Input");
		}
	}
}

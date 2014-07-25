package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public class U3 extends UpdateTable {
	private Connection con;
	private static int pID;
   
	public U3(Connection con) {
		this.con = con;
	}
   
   public int getPID(){
      return pID;
   }
   
	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qU3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qU3;
	}
	
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, SQLException {
		String temp = "";
		try {
		System.out.println("Please enter Diagnosis ID: ");
		temp = br.readLine();
		pst.setInt(1, Integer.parseInt(temp));
      
      System.out.println("Please enter patient ID to checkout: ");
      temp = br.readLine();
		pst.setInt(2, Integer.parseInt(temp));
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

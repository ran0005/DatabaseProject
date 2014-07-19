package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Administers extends Table {
	
	@Override
	public String getStatement() {
		return administersinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, NumberFormatException, SQLException {
		String temp = "";
		
		System.out.print("Input value for " + "docOrderID" + ": " );
		temp = br.readLine();
		
		pst.setInt(1, Integer.parseInt(temp));
		
		System.out.print("Input value for " + "treatID" + ": " );
		temp = br.readLine();
		
		pst.setInt(2, Integer.parseInt(temp));
		
		System.out.print("Input value for " + "patID" + ": " );
		temp = br.readLine();
		
		pst.setInt(3, Integer.parseInt(temp));
		
		System.out.print("Input value for " + "empAdministerID" + ": " );
		temp = br.readLine();
		
		pst.setInt(4, Integer.parseInt(temp));
		
		System.out.print("Input value for " + "orderTime" + ": " );
		temp = br.readLine();
		
		pst.setString(5, temp);
		
		System.out.print("Input value for " + "adminTime" + ": " );
		temp = br.readLine();
		
		pst.setString(6, temp);
	}
}

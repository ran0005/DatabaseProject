package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admit extends Table {

	@Override
	public String getStatement() {
		return admitinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "admitDocID" + ": ");
		temp = br.readLine();

		pst.setInt(1, Integer.parseInt(temp));

		System.out.print("Input value for " + "diagID" + ": ");
		temp = br.readLine();

		pst.setInt(2, Integer.parseInt(temp));

		System.out.print("Input value for " + "patID" + ": ");
		temp = br.readLine();

		pst.setInt(3, Integer.parseInt(temp));
		
		// I think this should be set by default to null along with endTime. And it will be updated 
		// when the patient is checked out, via an update to the entry.
		System.out.print("Input value for " + "dischargeAdminID" + ": ");
		temp = br.readLine();

		pst.setInt(4, Integer.parseInt(temp));

		System.out.print("Input value for " + "startTime" + ": ");
		temp = br.readLine();

		pst.setString(5, temp);

		System.out.print("Input value for " + "patType" + ": ");
		temp = br.readLine();

		pst.setString(6, temp);

		System.out.print("Input value for " + "endTime" + ": ");
		temp = br.readLine();

		pst.setString(7, temp);
	}
}

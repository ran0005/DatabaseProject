package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Services extends Table {

	@Override
	public String getStatement() {
		return servicesinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "servType" + ": ");
		temp = br.readLine();

		pst.setString(1, temp);

		//not sure if we want custom java constraint for this as looking at the api
		//anything not (ignore case) equal to true is false so that needs to be considered.
		System.out.print("Input value for " + "staffOnly" + ": ");
		temp = br.readLine();

		pst.setBoolean(2, Boolean.parseBoolean(temp));
	}
}

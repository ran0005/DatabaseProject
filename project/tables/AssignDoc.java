package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AssignDoc extends Table {

	@Override
	public String getStatement() {
		return assignDocinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "primaryID" + ": ");
		temp = br.readLine();

		pst.setInt(1, Integer.parseInt(temp));

		System.out.print("Input value for " + "secondaryID" + ": ");
		temp = br.readLine();

		pst.setInt(2, Integer.parseInt(temp));

		System.out.print("Input value for " + "patID" + ": ");
		temp = br.readLine();

		pst.setInt(3, Integer.parseInt(temp));

		System.out.print("Input value for " + "assignTime" + ": ");
		temp = br.readLine();

		pst.setString(4, temp);

	}
}

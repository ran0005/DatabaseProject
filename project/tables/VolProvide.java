package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VolProvide extends Table {

	@Override
	public String getStatement() {
		return volProvideinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "volID" + ": ");
		temp = br.readLine();

		pst.setInt(1, Integer.parseInt(temp));

		System.out.print("Input value for " + "servType" + ": ");
		temp = br.readLine();

		pst.setString(2, temp);

		System.out.print("Input value for " + "dayOfWeek" + ": ");
		temp = br.readLine();

		pst.setString(3, temp);
	}
}

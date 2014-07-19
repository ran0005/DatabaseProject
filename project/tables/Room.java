package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Room extends Table {

	@Override
	public String getStatement() {
		return roominsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "roomNum" + ": ");
		temp = br.readLine();

		pst.setInt(1, Integer.parseInt(temp));

		System.out.print("Input value for " + "patID" + ": ");
		temp = br.readLine();

		pst.setInt(2, Integer.parseInt(temp));

		System.out.print("Input value for " + "empID" + ": ");
		temp = br.readLine();

		pst.setInt(3, Integer.parseInt(temp));
	}
}

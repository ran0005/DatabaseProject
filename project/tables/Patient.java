package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Patient extends Table {

	@Override
	public String getStatement() {
		return patientinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";

		System.out.print("Input value for " + "patID" + ": ");
		temp = br.readLine();

		pst.setInt(1, Integer.parseInt(temp));

		System.out.print("Input value for " + "pFirstName" + ": ");
		temp = br.readLine();

		pst.setString(2, temp);

		System.out.print("Input value for " + "pMInit" + ": ");
		temp = br.readLine();

		pst.setString(3, temp);

		System.out.print("Input value for " + "pLastName" + ": ");
		temp = br.readLine();

		pst.setString(4, temp);

		System.out.print("Input value for " + "emergContact" + ": ");
		temp = br.readLine();

		pst.setString(5, temp);

		System.out.print("Input value for " + "insurance" + ": ");
		temp = br.readLine();

		pst.setString(6, temp);
	}
}

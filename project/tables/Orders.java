package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Orders extends Table {

	@Override
	public String getStatement() {
		return ordersinsert;
	}

	@Override
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst)
			throws IOException, NumberFormatException, SQLException {
		String temp = "";
      
      System.out.print("Input value for " + "OrderID" + ": ");
		temp = br.readLine();
      
      pst.setInt(1, Integer.parseInt(temp));
      
		System.out.print("Input value for " + "empID" + ": ");
		temp = br.readLine();

		pst.setInt(2, Integer.parseInt(temp));

		System.out.print("Input value for " + "treatID" + ": ");
		temp = br.readLine();

		pst.setInt(3, Integer.parseInt(temp));

		System.out.print("Input value for " + "patID" + ": ");
		temp = br.readLine();

		pst.setInt(4, Integer.parseInt(temp));

		System.out.print("Input value for " + "orderTime" + ": ");
		temp = br.readLine();

		pst.setString(5, temp);
	}
}

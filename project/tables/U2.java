package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class U2 extends UpdateTable {
	private Connection con;
	private static int pID;
   
	public U2(Connection con) {
		this.con = con;
	}
   
   public int getPID(){
      return pID;
   }
   
	public PreparedStatement prepareStatement() {
		try {
			return con.prepareStatement(qU2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getStatement() {
		return qU2;
	}
	
	public void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, NumberFormatException, SQLException {

		pst.setInt(1, U1.getPID());
	}	
}

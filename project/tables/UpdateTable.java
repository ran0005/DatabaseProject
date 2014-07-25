package tables;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.Queries;

public abstract class UpdateTable implements Queries {
	
	public abstract String getStatement();
	
	public abstract void getPreparedStatement(BufferedReader br, PreparedStatement pst) throws IOException, NumberFormatException, SQLException;

	public abstract PreparedStatement prepareStatement();
}

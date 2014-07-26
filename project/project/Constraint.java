package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Constraint {
	private static Connection con = Database.getConnection();

	public static boolean integerConstraintMatch(PreparedStatement pst, int i,
			String temp) throws SQLException {
		try {
			pst.setInt(i, Integer.parseInt(temp));
			return true;
		} catch (NumberFormatException e) {
			System.out
					.println("Data Entry Error: only numbers are accepted for this field");
			return false;
		}
	}

	public static boolean characterConstraintMatch(PreparedStatement pst,
			int i, String temp) throws SQLException {
		if (temp.length() > 1 || temp.length() < 0) {
			System.out
					.println("Data Entry Error: can only be a single character");
			return false;
		} else {
			pst.setString(i, temp);
			return true;
		}
	}

	public static boolean checkEmpIDMatchesAdminType(int empid)
			throws SQLException {
		// check against employee
		String adminID = "select empid from employee where etype = 'Admin'";

		PreparedStatement checkStatement = con.prepareStatement(adminID);
		checkStatement.execute();
		ResultSet rs = checkStatement.getResultSet();

		while (rs.next()) {
			if (rs.getInt(1) == empid) {
				return true;
			}
		}

		System.out
				.println("Identification Error: must match that of an Administer");
		return false;
	}

	public static boolean checkEmpIDMatchesPrimaryOrSecondaryDoctor(int empid)
			throws SQLException {
		// check against employee
		String adminID = "select empid from employee where etype = 'Admitting Doctor' or etype = 'Consulting Doctor'";

		PreparedStatement checkStatement = con.prepareStatement(adminID);
		checkStatement.execute();
		ResultSet rs = checkStatement.getResultSet();

		while (rs.next()) {
			if (rs.getInt(1) == empid) {
				return true;
			}
		}

		System.out
				.println("Identification Error: must match that of an Admitting or Consulting Doctor");
		return false;
	}

	public static boolean checkEmpIDMatchesNeitherStaffOrAdmin(int empid)
			throws SQLException {
		// check against employee
		String adminID = "select empid from employee where etype = 'Staff' or etype = 'Admin'";

		PreparedStatement checkStatement = con.prepareStatement(adminID);
		checkStatement.execute();
		ResultSet rs = checkStatement.getResultSet();

		while (rs.next()) {
			if (rs.getInt(1) == empid) {
				return false;
			}
		}

		System.out
				.println("Identification Error: cannot be Staff or an Administer");
		return true;
	}
	
	//add checks for valid months and days for instance no 2014-13-68 as that would look stupid...
	public static boolean checkDateFormat(String date) {
		if (date.length() != 10) {
			System.out
					.println("Data Entry Error: date format should be YYYY-MM-DD");
			return false;
		}

		for (char c : date.toCharArray()) {
			if (c != '-' && Character.getNumericValue(c) < 0) {
				System.out
						.println("Data Entry Error: date format should be YYYY-MM-DD");
				return false;
			}
		}
		return true;
	}

	public static int getDateAsInteger(String date) {
		try {
			return Integer.parseInt(date.replace("-", ""));
		} catch (NumberFormatException e) {
			System.out
					.println("Data Entry Error: date format should be YYYY-MM-DD");
			return -1;
		}
	}

	public static boolean checkDateRange(String startdate, String enddate) {
		if (checkDateFormat(enddate)
				&& (getDateAsInteger(startdate) < getDateAsInteger(enddate))) {
			return true;
		}
		System.out
				.println("Improper Date Error: ending date must be greater than starting date");
		return false;
	}
}

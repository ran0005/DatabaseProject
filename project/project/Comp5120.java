package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import menu.Menu;

public class Comp5120 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Database db = new Database();
		db.connect();
		Menu m = new Menu(db);
	}
}

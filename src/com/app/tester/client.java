package com.app.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.UserDaoImpl;
import static com.app.dao.UserDaoImpl.*;

public class client {

	public static void main(String args[]) throws SQLException {
		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();

			while (true) {
				System.out.println("1.Display all");
				switch(sc.nextInt()) {
				case 1:
					dispAll();
				}
			}
		}
	}
}

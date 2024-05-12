package com.app.tester;

import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

import static com.app.dao.UserDaoImpl.*;

public class client {

	public static void main(String args[]) throws SQLException {
		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();

			while (true) {
				System.out.println("1.Display all");
				switch(sc.nextInt()) {
				case 1:
					userDao.dispAll();
					break;
				case 2:
					User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()), sc.next());
					userDao.insert(user);
					break;
				case 3:
					userDao.deleteuser(sc.nextInt());
				case 4:
					userDao.changePass(sc.next(),sc.next(),sc.next());
					break;
				}
			}
		}
	}
}

package com.app.tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.CandidatesDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

import static com.app.tester.UserSignedIn.*;

public class client {

	public static void main(String args[]) throws SQLException {
		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			CandidatesDaoImpl canDao = new CandidatesDaoImpl();

			while (true) {
				System.out.println("1.Display all voters\n2.insert voter\n3.sign in\n4.delete user\n"
						+ "5.display candidates\ngetvotes by party");
				switch (sc.nextInt()) {
				case 1:
					userDao.dispAll();
					break;
				case 2:
					System.out.println("enter all details");
					User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()),
							sc.next());
					userDao.insert(user);
					break;
				case 3:
					System.out.println("enter username and password");
					User user1 = userDao.userSign(sc.next(), sc.next());
					SignedIn(user1, userDao, canDao);
					break;
				case 4:
					System.out.println("enter voterid to delete");
					userDao.deleteuser(sc.nextInt());
					break;
				case 5:
					canDao.getCandidates();
					break;
				case 6:
					canDao.getVotesByParty();
					break;
				case 7:
					break;

				}
			}
		}
	}
}

package com.app.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.CandidatesDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.dao.userDao;
import com.app.entities.User;

public class UserSignedIn {

	public static void SignedIn(User user, UserDaoImpl userDao, CandidatesDaoImpl canDao) throws SQLException {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.vote\n2.change pass\n3.sign out");
			switch (sc.nextInt()) {
			case 1:
				if (user.isStatus() == false) {
					canDao.getCandidates();
					canDao.updateVotes(sc.nextInt());
					userDao.changeStatus(user.getEmail());
				} else
					System.out.println("already voted");
				break;
			case 2:
				System.out.println("enter new pass");
				userDao.changePass(user.getEmail(), user.getPass(), sc.next());
				break;
			case 3:
				return;
			}

		}
	}
}

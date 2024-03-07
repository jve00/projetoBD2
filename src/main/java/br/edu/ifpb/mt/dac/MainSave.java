package br.edu.ifpb.mt.dac;

import java.util.Date;

import br.edu.ifpb.mt.dac.dao.UserDAO;
import br.edu.ifpb.mt.dac.entities.User;

public class MainSave {

	public static void main(String[] args) throws DacException {
		UserDAO dao = new UserDAO();
		try {
			User user = new User();

			user.setBirthday(new Date());
			user.setEmail("email@gmail.com");
			user.setFirstName("Sicrano");
			user.setLastName("Silva");

			System.out.println(user);
			
			dao.save(user);

			System.out.println(user);
		} finally {
			dao.close();
		}
	}

}

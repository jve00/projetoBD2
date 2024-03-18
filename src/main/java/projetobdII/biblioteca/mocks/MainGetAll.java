package projetobdII.biblioteca.mocks;



import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.DaoException;

import java.util.List;

public class MainGetAll {

	public static void main(String[] args) throws DaoException {

		LivroDAO dao = new LivroDAO();
		try {
			List<LivroEntity> livroEntities = dao.getAll();

			for (LivroEntity l : livroEntities) {
				System.out.println(l);
			}

		} finally {
			dao.close();
		}
	}

}

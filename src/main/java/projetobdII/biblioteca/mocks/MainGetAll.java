package projetobdII.biblioteca.mocks;



import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.DacException;

import java.util.List;

public class MainGetAll {

	public static void main(String[] args) throws DacException {

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

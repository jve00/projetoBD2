package projetobdII.biblioteca.mocks;

import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.DacException;

import java.util.List;


public class MainDeleteAll {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {
			List<LivroEntity> livroEntities = dao.getAll();
			for (LivroEntity l : livroEntities) {
				dao.delete(l);
			}
		} finally {
			dao.close();
		}
	}

}

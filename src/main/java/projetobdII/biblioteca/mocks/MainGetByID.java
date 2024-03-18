package projetobdII.biblioteca.mocks;


import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.enuns.GeneroLivro;
import projetobdII.biblioteca.exceptions.DaoException;

import java.time.LocalDate;

public class MainGetByID {

	public static void main(String[] args) throws DaoException {
		LivroDAO dao = new LivroDAO();
		try {

			LivroEntity livroEntity = new LivroEntity();

			livroEntity.setNome("auto da compadecida");
			livroEntity.setGenero(GeneroLivro.ROMANCE);
			livroEntity.setAutor("Robson Caliban");
			livroEntity.setDataDePublicacao(LocalDate.now());

			dao.save(livroEntity);

			LivroEntity resultado = dao.getByID(livroEntity.getId());

		} finally {
			dao.close();
		}
	}

}

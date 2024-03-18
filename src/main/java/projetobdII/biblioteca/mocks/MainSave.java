package projetobdII.biblioteca.mocks;

import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.enuns.GeneroLivro;
import projetobdII.biblioteca.exceptions.DaoException;

import java.time.LocalDate;

public class MainSave {

	public static void main(String[] args) throws DaoException {
		LivroDAO dao = new LivroDAO();
		try {
			LivroEntity livroEntity = new LivroEntity();

			livroEntity.setNome("como perder o cabaço");
			livroEntity.setGenero(GeneroLivro.SUSPENSE);
			livroEntity.setAutor("Gabriel Laet");
			livroEntity.setDataDePublicacao(LocalDate.now());

			System.out.println(livroEntity);
			
			dao.save(livroEntity);

			System.out.println(livroEntity);
		} finally {
			dao.close();
		}
	}

}

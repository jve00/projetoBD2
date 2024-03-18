package projetobdII.biblioteca.mocks;

import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.enuns.GeneroLivro;
import projetobdII.biblioteca.exceptions.DaoException;

import java.time.LocalDate;

public class MainUpdate {

		public static void main(String[] args) throws DaoException {
			LivroDAO dao = new LivroDAO();
			try {

				LivroEntity livroEntity = dao.getByID(33);

				livroEntity.setNome("Ja perdi o cabaço, coomo consegui mais vezes");
				livroEntity.setGenero(GeneroLivro.SUSPENSE);
				livroEntity.setAutor("Gabriel Laet");
				livroEntity.setDataDePublicacao(LocalDate.now());

				//dao.save(livroEntity);

				System.out.println(livroEntity);

				livroEntity.setNome("Ja perdi o cabaço, coomo consegui mais vezes");

				dao.update(livroEntity);

				System.out.println(livroEntity);
			} finally {
				dao.close();
			}
		}

}

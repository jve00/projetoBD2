package projetobdII.biblioteca.mocks;

import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.enuns.GeneroLivro;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.DacException;

import java.time.LocalDate;

public class MainUpdate {

		public static void main(String[] args) throws DacException {
			LivroDAO dao = new LivroDAO();
			try {

				LivroEntity livroEntity = dao.getByID(22);

				livroEntity.setNome("cardio");
				livroEntity.setGenero(GeneroLivro.FICCAO_CIENTIFICA);
				livroEntity.setAutor("tony stark");
				livroEntity.setDataDePublicacao(LocalDate.now());

				//dao.save(livroEntity);

				System.out.println(livroEntity);

				livroEntity.setNome("allibaba e os 40 ladrões");

				dao.update(livroEntity);

				System.out.println(livroEntity);
			} finally {
				dao.close();
			}
		}

}

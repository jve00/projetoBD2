package projetobdII.biblioteca.mocks;

import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.enuns.GeneroLivro;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.DacException;

import java.time.LocalDate;

public class MainSave {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {
			LivroEntity livroEntity = new LivroEntity();

			livroEntity.setNome("livro teste");
			livroEntity.setGenero(GeneroLivro.FANTASIA);
			livroEntity.setAutor("jadson");
			livroEntity.setDataDePublicacao(LocalDate.now());

			System.out.println(livroEntity);
			
			dao.save(livroEntity);

			System.out.println(livroEntity);
		} finally {
			dao.close();
		}
	}

}

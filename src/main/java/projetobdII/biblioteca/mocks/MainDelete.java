package projetobdII.biblioteca.mocks;

import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.enuns.GeneroLivro;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.DacException;

import java.time.LocalDate;

;

public class MainDelete {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {
			// Primeiro salvar
			LivroEntity livroEntity = dao.getByID(22);

			livroEntity.setNome("exenplo");
			livroEntity.setGenero(GeneroLivro.ROMANCE);
			livroEntity.setAutor("Robson Caliban");
			livroEntity.setDataDePublicacao(LocalDate.now());

			System.out.println(dao.getAll().size());

			dao.delete(livroEntity);

			System.out.println(dao.getAll().size());
		} finally {
			dao.close();
		}
	}

}

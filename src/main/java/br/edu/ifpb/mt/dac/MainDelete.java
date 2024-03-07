package br.edu.ifpb.mt.dac;

import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.entities.Enuns.GeneroLivro;
import br.edu.ifpb.mt.dac.entities.Livro;

import java.time.LocalDate;

;

public class MainDelete {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {
			// Primeiro salvar
			Livro livro = new Livro();

			livro.setNome("exenplo");
			livro.setGenero(GeneroLivro.ROMANCE);
			livro.setAutor("Robson Caliban");
			livro.setDataDePublicacao(LocalDate.now());

			dao.save(livro);

			System.out.println(dao.getAll().size());

			// Depois apagar

			dao.delete(livro);

			System.out.println(dao.getAll().size());
		} finally {
			dao.close();
		}
	}

}

package br.edu.ifpb.mt.dac.mocks;

import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.enuns.GeneroLivro;
import br.edu.ifpb.mt.dac.entities.LivroEntity;
import br.edu.ifpb.mt.dac.exceptions.DacException;

import java.time.LocalDate;

;

public class MainDelete {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {
			// Primeiro salvar
			LivroEntity livroEntity = new LivroEntity();

			livroEntity.setNome("exenplo");
			livroEntity.setGenero(GeneroLivro.ROMANCE);
			livroEntity.setAutor("Robson Caliban");
			livroEntity.setDataDePublicacao(LocalDate.now());

			dao.save(livroEntity);

			System.out.println(dao.getAll().size());

			// Depois apagar

			dao.delete(livroEntity);

			System.out.println(dao.getAll().size());
		} finally {
			dao.close();
		}
	}

}

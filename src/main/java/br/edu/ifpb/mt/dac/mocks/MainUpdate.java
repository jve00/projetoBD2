package br.edu.ifpb.mt.dac.mocks;

import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.enuns.GeneroLivro;
import br.edu.ifpb.mt.dac.entities.classe.LivroEntity;
import br.edu.ifpb.mt.dac.exceptions.DacException;

import java.time.LocalDate;

public class MainUpdate {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {
			// Primeiro salvar
			LivroEntity livroEntity = new LivroEntity();

			livroEntity.setNome("exemplo");
			livroEntity.setGenero(GeneroLivro.ROMANCE);
			livroEntity.setAutor("Robson Caliban");
			livroEntity.setDataDePublicacao(LocalDate.now());

			dao.save(livroEntity);

			System.out.println(livroEntity);

			// Depois atualizar
			livroEntity.setNome("as tarnças do rei careca");

			dao.update(livroEntity);

			System.out.println(livroEntity);
		} finally {
			dao.close();
		}
	}

}

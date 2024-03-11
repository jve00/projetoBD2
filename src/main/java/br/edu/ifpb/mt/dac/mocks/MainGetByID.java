package br.edu.ifpb.mt.dac.mocks;


import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.enuns.GeneroLivro;
import br.edu.ifpb.mt.dac.entities.LivroEntity;
import br.edu.ifpb.mt.dac.exceptions.DacException;

import java.time.LocalDate;

public class MainGetByID {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {

			LivroEntity livroEntity = new LivroEntity();

			livroEntity.setNome("auto da compadecida");
			livroEntity.setGenero(GeneroLivro.ROMANCE);
			livroEntity.setAutor("Robson Caliban");
			livroEntity.setDataDePublicacao(LocalDate.now());

			dao.save(livroEntity);

			LivroEntity resultado = dao.getByID(livroEntity.getId());
			System.out.println(livroEntity.equals(resultado));
			System.out.println(livroEntity.getNome());


		} finally {
			dao.close();
		}
	}

}

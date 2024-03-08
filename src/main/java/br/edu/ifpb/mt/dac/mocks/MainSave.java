package br.edu.ifpb.mt.dac.mocks;

import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.enuns.GeneroLivro;
import br.edu.ifpb.mt.dac.entities.classe.LivroEntity;
import br.edu.ifpb.mt.dac.exceptions.DacException;

import java.time.LocalDate;

public class MainSave {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {
			LivroEntity livroEntity = new LivroEntity();

			livroEntity.setNome("exenplo");
			livroEntity.setGenero(GeneroLivro.ROMANCE);
			livroEntity.setAutor("Robson Caliban");
			livroEntity.setDataDePublicacao(LocalDate.now());

			System.out.println(livroEntity);
			
			dao.save(livroEntity);

			System.out.println(livroEntity);
		} finally {
			dao.close();
		}
	}

}

package br.edu.ifpb.mt.dac.mocks;

import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.enuns.GeneroLivro;
import br.edu.ifpb.mt.dac.entities.LivroEntity;
import br.edu.ifpb.mt.dac.exceptions.DacException;

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

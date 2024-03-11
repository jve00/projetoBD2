package br.edu.ifpb.mt.dac.mocks;

import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.entities.LivroEntity;
import br.edu.ifpb.mt.dac.exceptions.DacException;

import java.util.List;

public class MainGetAll {

	public static void main(String[] args) throws DacException {

		LivroDAO dao = new LivroDAO();
		try {
			List<LivroEntity> livroEntities = dao.getAll();

			for (LivroEntity l : livroEntities) {
				System.out.println(l);
			}

		} finally {
			dao.close();
		}
	}

}

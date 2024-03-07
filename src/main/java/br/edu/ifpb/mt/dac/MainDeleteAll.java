package br.edu.ifpb.mt.dac;

import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.entities.Livro;

import java.util.List;


public class MainDeleteAll {

	public static void main(String[] args) throws DacException {
		LivroDAO dao = new LivroDAO();
		try {
			List<Livro> livros = dao.getAll();
			for (Livro l : livros) {
				dao.delete(l);
			}
		} finally {
			dao.close();
		}
	}

}

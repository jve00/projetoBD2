package projetobdII.biblioteca.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import projetobdII.biblioteca.entities.LivroEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;
@Data
@AllArgsConstructor
public class LivroDAO extends DAO {

	public void save(LivroEntity livroEntity) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(livroEntity);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o livro.", pe);
		} finally {
			em.close();
		}
	}

	public LivroEntity update(LivroEntity livroEntity) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		LivroEntity resultado = livroEntity;
		try {
			resultado = em.merge(livroEntity);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar atualizar o livro.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(LivroEntity livroEntity) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			livroEntity = em.find(LivroEntity.class, livroEntity.getId());
			em.remove(livroEntity);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar remover o livro.", pe);
		} finally {
			em.close();
		}
	}

	public LivroEntity getByID(int livroId) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		LivroEntity resultado = null;
		try {
			resultado = em.find(LivroEntity.class, livroId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar o livro com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<LivroEntity> getAll() throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<LivroEntity> resultado = null;
		try {
			TypedQuery<LivroEntity> query = em.createQuery("SELECT l FROM LivroEntity l", LivroEntity.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os livros.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
}

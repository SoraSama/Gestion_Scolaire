package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.ClasseMatiereDao;
import gestionScolaire.metier.model.ClasseMatiere;

@Transactional
@Repository
public class ClasseMatiereDaoJpa implements ClasseMatiereDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	

	@Override
	public ClasseMatiere find(Long id) {
		return em.find(ClasseMatiere.class, id);

	}


	@Override
	public List<ClasseMatiere> findAll() {
		Query query = em.createQuery("from ClasseMatiere c");
		return query.getResultList();
	}

	@Override
	public void create(ClasseMatiere classeMatiere) {
		em.persist(classeMatiere);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public ClasseMatiere update(ClasseMatiere classeMatiere) {
		return em.merge(classeMatiere);

	}

	@Override
	public void delete(ClasseMatiere classeMatiere) {
		em.remove(em.merge(classeMatiere));
	}

	@Override
	public void delete(Long id) {
		ClasseMatiere classeMatiere = find(id);
		em.remove(em.merge(classeMatiere));
	}	
}
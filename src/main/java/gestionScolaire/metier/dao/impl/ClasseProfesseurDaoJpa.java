package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.ClasseProfesseurDao;
import gestionScolaire.metier.model.ClasseProfesseur;

@Transactional
@Repository
public class ClasseProfesseurDaoJpa implements ClasseProfesseurDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	

	@Override
	public ClasseProfesseur find(Long id) {
		return em.find(ClasseProfesseur.class, id);

	}


	@Override
	public List<ClasseProfesseur> findAll() {
		Query query = em.createQuery("from ClasseProfesseur c");
		return query.getResultList();
	}

	@Override
	public void create(ClasseProfesseur classeProfesseur) {
		em.persist(classeProfesseur);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public ClasseProfesseur update(ClasseProfesseur classeProfesseur) {
		return em.merge(classeProfesseur);

	}

	@Override
	public void delete(ClasseProfesseur classeProfesseur) {
		em.remove(em.merge(classeProfesseur));
	}

	@Override
	public void delete(Long id) {
		ClasseProfesseur classeProfesseur = find(id);
		em.remove(em.merge(classeProfesseur));
	}	
}
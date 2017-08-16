package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.ClasseSalleDao;
import gestionScolaire.metier.model.ClasseSalle;

@Transactional
@Repository
public class ClasseSalleDaoJpa implements ClasseSalleDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	

	@Override
	public ClasseSalle find(Long id) {
		return em.find(ClasseSalle.class, id);

	}


	@Override
	public List<ClasseSalle> findAll() {
		Query query = em.createQuery("from ClasseSalle c");
		return query.getResultList();
	}

	@Override
	public void create(ClasseSalle classeSalle) {
		em.persist(classeSalle);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public ClasseSalle update(ClasseSalle classeSalle) {
		return em.merge(classeSalle);
		

	}

	@Override
	public void delete(ClasseSalle classeSalle) {
			em.remove(em.merge(classeSalle));
	}

	@Override
	public void delete(Long id) {
		ClasseSalle classeSalle = find(id);
		em.remove(em.merge(classeSalle));
	}	
}
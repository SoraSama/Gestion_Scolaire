package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.EmploiDuTempsDao;
import gestionScolaire.metier.model.EmploiDuTemps;

@Transactional
@Repository
public class EmploiDuTempsDaoJpa implements EmploiDuTempsDao{

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
	// manager
	private EntityManager em;
	
	@Override
	public EmploiDuTemps find(Integer id) {
		return em.find(EmploiDuTemps.class, id);
	}
	
	@Override
	public List<EmploiDuTemps> findAll() {
		Query query = em.createQuery("from EmploiDuTemps e");
		return query.getResultList();
	}
	
	@Override
	public void create(EmploiDuTemps emploiDuTemps) {
		em.persist(emploiDuTemps);
	}
	
	@Override
	public EmploiDuTemps update(EmploiDuTemps emploiDuTemps) {
		return em.merge(emploiDuTemps);

	}
	
	@Override
	public void delete(EmploiDuTemps emploiDuTemps) {
		em.remove(em.merge(emploiDuTemps));

	}

	@Override
	public void delete(Integer id) {
		EmploiDuTemps emploiDuTemps = find(id);
		em.remove(em.merge(emploiDuTemps));
	}
}

package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.ClasseSalleDao;
import gestionScolaire.metier.dao.SalleDao;
import gestionScolaire.metier.model.ClasseSalle;
import gestionScolaire.metier.model.Salle;

@Transactional
@Repository
public class SalleDaoJpa implements SalleDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Autowired
	private ClasseSalleDao classeSalleDao;

	@Override
	public Salle find(Long id) {
		return em.find(Salle.class, id);

	}

	public Salle find(String name) {
		Query query = em.createQuery("from Salle s where s.nom = :nom");
		query.setParameter("nom", name);
		List<Salle> salles = query.getResultList();
		return salles.size() > 0 ? salles.get(0) : null;
	}

	public List<Salle> findEtab(Long idEtab) {
		Query query = em.createQuery("from Salle s where s.etablissement.id = :idE");
		query.setParameter("idE", idEtab);
		List<Salle> salles = query.getResultList();
		return salles.size() > 0 ? salles : null;
	}
	
	@Override
	public List<Salle> findAll() {
		Query query = em.createQuery("from Salle s");
		return query.getResultList();
	}

	@Override
	public void create(Salle salle) {
		em.persist(salle);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public Salle update(Salle salle) {
		return em.merge(salle);

	}

	@Override
	public void delete(Salle salle) {
		if(salle.getSalles() != null)
			for (ClasseSalle classeSalle : salle.getSalles()) {
				classeSalleDao.delete(classeSalle);
			}

		em.remove(em.merge(salle));

	}

	@Override
	public void delete(Long id) {
		Salle salle = find(id);
		if(salle.getSalles() != null)
			for (ClasseSalle classeSalle : salle.getSalles()) {
				classeSalleDao.delete(classeSalle);
			}

		em.remove(em.merge(salle));
	}	
}

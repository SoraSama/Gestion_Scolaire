package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.ClasseProfesseurDao;
import gestionScolaire.metier.dao.ProfesseurDao;
import gestionScolaire.metier.model.ClasseProfesseur;
import gestionScolaire.metier.model.Professeur;

@Transactional
@Repository
public class ProfesseurDaoJpa implements ProfesseurDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Autowired
	private ClasseProfesseurDao classeProfesseurDao;

	@Override
	public Professeur find(Long id) {
		return em.find(Professeur.class, id);

	}

	public List<Professeur> findEtab(Long idEtab) {
		Query query = em.createQuery("from Professeur p where p.etablissement.id = :idE");
		query.setParameter("idE", idEtab);
		List<Professeur> professeurs = query.getResultList();
		return professeurs.size() > 0 ? professeurs : null;
	}
	
	public Professeur find(String name) {
		Query query = em.createQuery("from Professeur p where p.nom = :nom");
		query.setParameter("nom", name);
		List<Professeur> professeurs = query.getResultList();
		return professeurs.size() > 0 ? professeurs.get(0) : null;
	}
	
	public Professeur find(String nameN, String nameP) {
		Query query = em.createQuery("from Professeur p where p.nom = :nom and "
				+ "p.prenom = :prenom");
		query.setParameter("nom", nameN);
		query.setParameter("prenom", nameP);
		List<Professeur> professeurs = query.getResultList();
		return professeurs.size() > 0 ? professeurs.get(0) : null;
	}

	@Override
	public List<Professeur> findAll() {
		Query query = em.createQuery("from Professeur p");
		return query.getResultList();
	}

	@Override
	public void create(Professeur professeur) {
		em.persist(professeur);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public Professeur update(Professeur professeur) {
		return em.merge(professeur);

	}

	@Override
	public void delete(Professeur professeur) {
		if(professeur.getProfesseurs() != null)
			for (ClasseProfesseur classeProfesseur : professeur.getProfesseurs()) {
				classeProfesseurDao.delete(classeProfesseur);
			}

		em.remove(em.merge(professeur));

	}

	@Override
	public void delete(Long id) {
		Professeur professeur = find(id);
		if(professeur.getProfesseurs() != null)
			for (ClasseProfesseur classeProfesseur : professeur.getProfesseurs()) {
				classeProfesseurDao.delete(classeProfesseur);
			}

		em.remove(em.merge(professeur));

	}	
}


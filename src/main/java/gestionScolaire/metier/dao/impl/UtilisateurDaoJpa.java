package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.UtilisateurDao;
import gestionScolaire.metier.model.Utilisateur;

@Transactional
@Repository
public class UtilisateurDaoJpa implements UtilisateurDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Override
	public Utilisateur find(Long id) {
		return em.find(Utilisateur.class, id);

	}

	public Utilisateur find(String log) {
		Query query = em.createQuery("from Utilisateur u where u.login = :login");
		query.setParameter("login", log);
		List<Utilisateur> utilisateurs = query.getResultList();
		return utilisateurs.size() > 0 ? utilisateurs.get(0) : null;
	}
	
	public Utilisateur find(String nameN, String nameP) {
		Query query = em.createQuery("from Utilisateur u where u.nom = :nom"
				+ " and u.prenom = :prenom");
		query.setParameter("nom", nameN);
		query.setParameter("prenom", nameP);
		List<Utilisateur> utilisateurs = query.getResultList();
		return utilisateurs.size() > 0 ? utilisateurs.get(0) : null;
	}
	
	public List<Utilisateur> findEtab(Long idEtab) {
		Query query = em.createQuery("from Utilisateur u where u.etablissement.id = :idE");
		query.setParameter("idE", idEtab);
		List<Utilisateur> utilisateurs = query.getResultList();
		return utilisateurs.size() > 0 ? utilisateurs : null;
	}

	@Override
	public List<Utilisateur> findAll() {
		Query query = em.createQuery("from Utilisateur u");
		return query.getResultList();
	}

	@Override
	public void create(Utilisateur utilisateur) {
		em.persist(utilisateur);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		return em.merge(utilisateur);
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		em.remove(em.merge(utilisateur));
	}

	@Override
	public void delete(Long id) {
		Utilisateur utilisateur = find(id);
		em.remove(em.merge(utilisateur));
	}	
}


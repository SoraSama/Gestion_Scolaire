package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.ClasseDao;
import gestionScolaire.metier.dao.EtablissementDao;
import gestionScolaire.metier.dao.MatiereDao;
import gestionScolaire.metier.dao.ProfesseurDao;
import gestionScolaire.metier.dao.SalleDao;
import gestionScolaire.metier.dao.UtilisateurDao;
import gestionScolaire.metier.model.Classe;
import gestionScolaire.metier.model.Etablissement;
import gestionScolaire.metier.model.Matiere;
import gestionScolaire.metier.model.Professeur;
import gestionScolaire.metier.model.Salle;
import gestionScolaire.metier.model.Utilisateur;

@Transactional
@Repository
public class EtablissementDaoJpa implements EtablissementDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Autowired
	private UtilisateurDao utilisateurDao;

	@Autowired
	private ClasseDao classeDao;
	
	@Autowired
	private ProfesseurDao professeurDao;
	
	@Autowired
	private SalleDao salleDao;
	
	@Autowired
	private MatiereDao matiereDao;
	

	@Override
	public Etablissement find(Long id) {
		return em.find(Etablissement.class, id);

	}

	public Etablissement find(String name) {
		Query query = em.createQuery("from Etablissement e where e.nom = :nom");
		query.setParameter("nom", name);
		List<Etablissement> etablissements = query.getResultList();
		return etablissements.size() > 0 ? etablissements.get(0) : null;
	}

	@Override
	public List<Etablissement> findAll() {
		Query query = em.createQuery("from Etablissement e");
		return query.getResultList();
	}

	@Override
	public void create(Etablissement etablissement) {
		em.persist(etablissement);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public Etablissement update(Etablissement etablissement) {
		return em.merge(etablissement);

	}

	@Override
	public void delete(Etablissement etablissement) {
		if(utilisateurDao.findEtab(etablissement.getId()) != null)
			for (Utilisateur utilisateur : utilisateurDao.findEtab(etablissement.getId())) {
				utilisateurDao.delete(utilisateur);
			}
		
		if(classeDao.findEtab(etablissement.getId()) != null)
			for (Classe classe : classeDao.findEtab(etablissement.getId())) {
				classeDao.delete(classe);
			}
			
		if(professeurDao.findEtab(etablissement.getId()) != null)
			for (Professeur professeur : professeurDao.findEtab(etablissement.getId())) {
				professeurDao.delete(professeur);
			}
		
		if(salleDao.findEtab(etablissement.getId()) != null)
			for (Salle salle : salleDao.findEtab(etablissement.getId())) {
				salleDao.delete(salle);
			}
		
//		if(etablissement.getUtilisateurs() != null)
//			for (Utilisateur utilisateur : etablissement.getUtilisateurs()) {
//				utilisateurDao.delete(utilisateur);
//			}
//		
//		if(etablissement.getClasses() != null)
//			for (Classe classe : etablissement.getClasses()) {
//				classeDao.delete(classe);
//			}
//		
//		if(etablissement.getProfesseurs() != null)
//			for (Professeur professeur : etablissement.getProfesseurs()) {
//				professeurDao.delete(professeur);
//			}
//		
//		if(etablissement.getSalles() != null)
//			for (Salle salle : etablissement.getSalles()) {
//				salleDao.delete(salle);
//			}
		
		//une matiere est indépendante des établissements
//		if(etablissement.getMatieres() != null)
//			for (Matiere matiere : etablissement.getMatieres()) {
//				matiereDao.delete(matiere);
//			}

		em.remove(em.merge(etablissement));

	}

	@Override
	public void delete(Long id) {
		Etablissement etablissement = find(id);
		if(etablissement.getUtilisateurs() != null)
			for (Utilisateur utilisateur : etablissement.getUtilisateurs()) {
				utilisateurDao.delete(utilisateur);
			}
		
		if(etablissement.getClasses() != null)
			for (Classe classe : etablissement.getClasses()) {
				classeDao.delete(classe);
			}
		
		if(etablissement.getProfesseurs() != null)
			for (Professeur professeur : etablissement.getProfesseurs()) {
				professeurDao.delete(professeur);
			}
		
		if(etablissement.getSalles() != null)
			for (Salle salle : etablissement.getSalles()) {
				salleDao.delete(salle);
			}
		
		if(etablissement.getMatieres() != null)
			for (Matiere matiere : etablissement.getMatieres()) {
				matiereDao.delete(matiere);
			}

		em.remove(em.merge(etablissement));
	}	
}
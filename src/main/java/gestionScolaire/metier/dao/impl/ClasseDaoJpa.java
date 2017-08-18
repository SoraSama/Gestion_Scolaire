package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.ClasseDao;
import gestionScolaire.metier.dao.ClasseMatiereDao;
import gestionScolaire.metier.dao.ClasseProfesseurDao;
import gestionScolaire.metier.dao.ClasseSalleDao;
import gestionScolaire.metier.model.Classe;
import gestionScolaire.metier.model.ClasseMatiere;
import gestionScolaire.metier.model.ClasseProfesseur;
import gestionScolaire.metier.model.ClasseSalle;


@Transactional
@Repository
public class ClasseDaoJpa implements ClasseDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Autowired
	private ClasseMatiereDao classeMatiereDao;

	@Autowired
	private ClasseProfesseurDao classeProfesseurDao;
	
	@Autowired
	private ClasseSalleDao classeSalleDao;
	

	@Override
	public Classe find(Long id) {
		return em.find(Classe.class, id);

	}

	public List<Classe> findEtab(Long idEtab) {
		Query query = em.createQuery("from Classe c where c.etablissement.id = :idE");
		query.setParameter("idE", idEtab);
		List<Classe> classes = query.getResultList();
		return classes.size() > 0 ? classes : null;
	}
	
	public Classe find(String name) {
		Query query = em.createQuery("from Classe c where c.nom = :nom");
		query.setParameter("nom", name);
		List<Classe> classes = query.getResultList();
		return classes.size() > 0 ? classes.get(0) : null;
	}

	@Override
	public List<Classe> findAll() {
		Query query = em.createQuery("from Classe a");
		return query.getResultList();
	}

	@Override
	public void create(Classe classe) {
		em.persist(classe);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public Classe update(Classe classe) {
		return em.merge(classe);

	}

	@Override
	public void delete(Classe classe) {
		for (ClasseMatiere classeMatiere : classe.getMatieres()) {
			classeMatiereDao.delete(classeMatiere);
		}
		for (ClasseProfesseur classeProfesseur : classe.getProfesseurs()) {
			classeProfesseurDao.delete(classeProfesseur);
		}
		for (ClasseSalle classeSalle : classe.getSalles()) {
			classeSalleDao.delete(classeSalle);
		}

		em.remove(em.merge(classe));

	}

	@Override
	public void delete(Long id) {
		Classe classe = find(id);
		for (ClasseMatiere classeMatiere : classe.getMatieres()) {
			classeMatiereDao.delete(classeMatiere);
		}
		for (ClasseProfesseur classeProfesseur : classe.getProfesseurs()) {
			classeProfesseurDao.delete(classeProfesseur);
		}
		for (ClasseSalle classeSalle : classe.getSalles()) {
			classeSalleDao.delete(classeSalle);
		}

		em.remove(em.merge(classe));
	}	
}
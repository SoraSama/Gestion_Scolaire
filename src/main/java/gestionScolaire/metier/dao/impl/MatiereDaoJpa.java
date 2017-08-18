package gestionScolaire.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionScolaire.metier.dao.ClasseMatiereDao;
import gestionScolaire.metier.dao.MatiereDao;
import gestionScolaire.metier.model.ClasseMatiere;
import gestionScolaire.metier.model.Matiere;

@Transactional
@Repository
public class MatiereDaoJpa implements MatiereDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Autowired
	private ClasseMatiereDao classeMatiereDao;

	@Override
	public Matiere find(Long id) {
		return em.find(Matiere.class, id);

	}
	
	public Matiere find(String name) {
		Query query = em.createQuery("from Matiere m where m.nom = :nom");
		query.setParameter("nom", name);
		List<Matiere> matieres = query.getResultList();
		return matieres.size() > 0 ? matieres.get(0) : null;
	}

	@Override
	public List<Matiere> findAll() {
		Query query = em.createQuery("from Matiere m");
		return query.getResultList();
	}

	@Override
	public void create(Matiere matiere) {
		em.persist(matiere);
	}

	// un objet r�cup�r� de la base est d�j� manag� donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public Matiere update(Matiere matiere) {
		return em.merge(matiere);

	}

	@Override
	public void delete(Matiere matiere) {
		if(matiere.getMatieres() != null)
			for (ClasseMatiere classeMatiere : matiere.getMatieres()) {
				classeMatiereDao.delete(classeMatiere);
			}

		em.remove(em.merge(matiere));

	}

	@Override
	public void delete(Long id) {
		Matiere matiere = find(id);
		if(matiere.getMatieres() != null)
			for (ClasseMatiere classeMatiere : matiere.getMatieres()) {
				classeMatiereDao.delete(classeMatiere);
			}

		em.remove(em.merge(matiere));

	}	
}

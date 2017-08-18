package gestionScolaire.metier.dao;

import java.util.List;

import gestionScolaire.metier.model.Professeur;

public interface ProfesseurDao extends Dao<Professeur, Long>{
	Professeur find(String name);
	List<Professeur> findEtab(Long idEtab);
	Professeur find(String nameN, String nameP);
}

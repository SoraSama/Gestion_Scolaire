package gestionScolaire.metier.dao;

import java.util.List;

import gestionScolaire.metier.model.Classe;

public interface ClasseDao extends Dao<Classe, Long>{
	Classe find(String name);
	List<Classe> findEtab(Long idEtab);
}

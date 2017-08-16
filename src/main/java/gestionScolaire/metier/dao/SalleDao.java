package gestionScolaire.metier.dao;

import java.util.List;

import gestionScolaire.metier.model.Salle;

public interface SalleDao extends Dao<Salle, Long>{
	public Salle find(String name);
	List<Salle> findEtab(Long idEtab);
}

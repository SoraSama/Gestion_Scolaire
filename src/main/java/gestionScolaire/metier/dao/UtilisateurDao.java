package gestionScolaire.metier.dao;

import java.util.List;

import gestionScolaire.metier.model.Utilisateur;

public interface UtilisateurDao extends Dao<Utilisateur, Long>{
	Utilisateur find(String log);
	Utilisateur find(String nameN, String nameP);
	List<Utilisateur> findEtab(Long idEtab);
	Utilisateur userConnecter(String userId, String password);
}
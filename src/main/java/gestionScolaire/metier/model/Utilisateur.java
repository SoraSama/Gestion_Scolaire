package gestionScolaire.metier.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String login;
	private String nom;
	private String prenom;
	private String motDePasseTemporaire;
	private boolean premConnect = true;
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "etablissement_id")
	private Etablissement etablissement;
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(Long id, String login, String nom, String prenom, String motDePasseTemporaire, boolean premConnect,
			Etablissement etablissement) {
		super();
		this.id = id;
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasseTemporaire = motDePasseTemporaire;
		this.premConnect = premConnect;
		this.etablissement = etablissement;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMotDePasseTemporaire() {
		return motDePasseTemporaire;
	}


	public void setMotDePasseTemporaire(String motDePasseTemporaire) {
		this.motDePasseTemporaire = motDePasseTemporaire;
	}


	public boolean getPremConnect() {
		return premConnect;
	}


	public void setPremConnect(boolean premConnect) {
		this.premConnect = premConnect;
	}


	public Etablissement getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
}
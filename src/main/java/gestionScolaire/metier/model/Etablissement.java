package gestionScolaire.metier.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;



@Entity
public class Etablissement {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String nom;
	@Enumerated(EnumType.STRING)
	@NotNull(message="Le type est obligatoire")
	private TypeEtablissement type;
	private String logo;
	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy="etablissement", fetch = FetchType.EAGER)
	private List<Utilisateur> utilisateurs;
	
	@OneToMany(mappedBy="etablissement", fetch = FetchType.EAGER)
	private List<Classe> classes;
	
	@OneToMany(mappedBy="etablissement", fetch = FetchType.EAGER)
	private List<Salle> salles;
	
	@OneToMany(mappedBy="etablissement", fetch = FetchType.EAGER)
	private List<Matiere> matieres;
	
	@OneToMany(mappedBy="etablissement", fetch = FetchType.EAGER)
	private List<Professeur> professeurs;

	
	
	public Etablissement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Etablissement(Long id, int version, String nom, TypeEtablissement type, String logo, List<Utilisateur> utilisateurs,
			List<Classe> classes, List<Salle> salles, List<Matiere> matieres, List<Professeur> professeurs) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.type = type;
		this.logo = logo;
		this.utilisateurs = utilisateurs;
		this.classes = classes;
		this.salles = salles;
		this.matieres = matieres;
		this.professeurs = professeurs;
	}










	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public TypeEtablissement getType() {
		return type;
	}



	public void setType(TypeEtablissement type) {
		this.type = type;
	}



	public String getLogo() {
		return logo;
	}



	public void setLogo(String logo) {
		this.logo = logo;
	}



	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}



	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}



	public List<Classe> getClasses() {
		return classes;
	}



	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}



	public List<Salle> getSalles() {
		return salles;
	}



	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}



	public List<Matiere> getMatieres() {
		return matieres;
	}



	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}



	public List<Professeur> getProfesseurs() {
		return professeurs;
	}



	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
	
}
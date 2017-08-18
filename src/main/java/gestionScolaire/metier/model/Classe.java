package gestionScolaire.metier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Classe {


	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	@Column(name="Nombre_Eleves")
	private int nbEleve;
	private String professeurPrincipal;
	private int version;
	
	@ManyToOne
	@JoinColumn(name = "etablissement_id")
	private Etablissement etablissement;
	
	@OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
	private List<ClasseMatiere> matieres;
	
	@OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
	private List<ClasseSalle> salles;
	
	@OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
	private List<ClasseProfesseur> professeurs;
	
	@OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
	private List<EmploiDuTemps> emploiDuTemps;
	
	public Classe() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nom", length = 100)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public int getNbEleve() {
		return nbEleve;
	}

	public void setNbEleve(int nbEleve) {
		this.nbEleve = nbEleve;
	}

	public List<EmploiDuTemps> getEmploiDuTemps() {
		return emploiDuTemps;
	}

	public void setEmploiDuTemps(List<EmploiDuTemps> emploiDuTemps) {
		this.emploiDuTemps = emploiDuTemps;
	}

	public String getProfesseurPrincipal() {
		return professeurPrincipal;
	}

	public void setProfesseurPrincipal(String professeurPrincipal) {
		this.professeurPrincipal = professeurPrincipal;
	}

	
	public List<ClasseMatiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<ClasseMatiere> matieres) {
		this.matieres = matieres;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<ClasseSalle> getSalles() {
		return salles;
	}

	public void setSalles(List<ClasseSalle> salles) {
		this.salles = salles;
	}

	public List<ClasseProfesseur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<ClasseProfesseur> professeurs) {
		this.professeurs = professeurs;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	
	
}
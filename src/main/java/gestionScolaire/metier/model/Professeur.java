package gestionScolaire.metier.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Professeur {

	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private int version;
	
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> matieresEnseignees = new ArrayList<String>();
	
	@ManyToOne
	@JoinColumn(name = "etablissement_id")
	private Etablissement etablissement;
	
	@OneToMany(mappedBy = "professeur", fetch = FetchType.EAGER)
	private List<ClasseProfesseur> professeurs;

	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professeur(Long id, int version, String nom, String prenom, Date dateDeNaissance, List<String> matieresEnseignees,
			Etablissement etablissement) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.matieresEnseignees = matieresEnseignees;
		this.etablissement = etablissement;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<String> getMatieresEnseignees() {
		return matieresEnseignees;
	}

	public void setMatieresEnseignees(List<String> matieresEnseignees) {
		this.matieresEnseignees = matieresEnseignees;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public List<ClasseProfesseur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<ClasseProfesseur> professeurs) {
		this.professeurs = professeurs;
	}
	
	
	
}
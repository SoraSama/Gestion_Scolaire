package gestionScolaire.metier.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Matiere {

	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private int version;
	
	private String nom;
	private String couleur;
	
	@ManyToOne
	@JoinColumn(name = "etablissement_id")
	private Etablissement etablissement;

	
	@OneToMany(mappedBy = "matiere", fetch = FetchType.EAGER)
	private List<ClasseMatiere> matieres;


	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matiere(Long id, int version, String nom, String couleur, Etablissement etablissement) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.couleur = couleur;
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

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	
	public List<ClasseMatiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<ClasseMatiere> matieres) {
		this.matieres = matieres;
	}
	
}
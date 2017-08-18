package gestionScolaire.metier.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Salle {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private int version;
	private String nom;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> matieresExclues = new ArrayList<String>();
	private int capacite;
	
	@ManyToOne
	@JoinColumn(name = "etablissement_id")
	private Etablissement etablissement;
	
	@OneToMany(mappedBy = "salle", fetch = FetchType.EAGER)
	private List<ClasseSalle> salles;

	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salle(Long id, int version, String nom, List<String> matieresExclues, int capacite,
			Etablissement etablissement) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.matieresExclues = matieresExclues;
		this.capacite = capacite;
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

	public List<String> getMatieresExclues() {
		return matieresExclues;
	}

	public void setMatieresExclues(List<String> matieresExclues) {
		this.matieresExclues = matieresExclues;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public List<ClasseSalle> getSalles() {
		return salles;
	}

	public void setSalles(List<ClasseSalle> salles) {
		this.salles = salles;
	}

	
	
}


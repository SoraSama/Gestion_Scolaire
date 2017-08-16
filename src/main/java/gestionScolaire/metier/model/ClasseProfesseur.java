package gestionScolaire.metier.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Classe_professeur")
public class ClasseProfesseur {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "professeur_id")
	private Professeur professeur;
	
	@ManyToOne
	@JoinColumn(name = "classe_id")
	private Classe classe;
	
	private int version;

	public ClasseProfesseur() {
	}

	public ClasseProfesseur(Professeur professeur, Classe classe) {
		super();
		this.professeur = professeur;
		this.classe = classe;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
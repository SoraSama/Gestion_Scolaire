package gestionScolaire.metier.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Classe_matiere")
public class ClasseMatiere {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "matiere_id")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name = "classe_id")
	private Classe classe;
	
	@Version
	private int version;

	public ClasseMatiere() {
	}

	public ClasseMatiere(Matiere matiere, Classe classe) {
		super();
		this.matiere = matiere;
		this.classe = classe;
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

	
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
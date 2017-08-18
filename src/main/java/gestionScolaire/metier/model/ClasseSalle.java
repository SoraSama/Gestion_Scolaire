package gestionScolaire.metier.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Classe_salle")
public class ClasseSalle {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "salle_id")
	private Salle salle;
	
	@ManyToOne
	@JoinColumn(name = "classe_id")
	private Classe classe;
	
	private int version;

	public ClasseSalle() {
	}

	public ClasseSalle(Salle salle, Classe classe) {
		super();
		this.salle = salle;
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

	
	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
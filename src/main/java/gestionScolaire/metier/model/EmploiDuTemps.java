package gestionScolaire.metier.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EmploiDuTemps {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="H_Debut")
	@Temporal(TemporalType.TIME)
	private Date dateDebut;
	@Column(name="H_Fin")
	@Temporal(TemporalType.TIME)
	private Date dateFin;
	private String text;
	@ManyToOne
	@JoinColumn(name = "classe_id") 
	private Classe classe;
	@ManyToOne
	@JoinColumn(name = "matiere_id") 
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name = "salle_id")
	private Salle salle;
	@ManyToOne
	@JoinColumn(name = "professeur_id")
	private Professeur professeur;
	private int version;
	
	public EmploiDuTemps(){
		super();
	}
	
	public EmploiDuTemps(Integer id, int version, Date dateDebut, Date dateFin,
			String text, Matiere matiere, Salle salle, Professeur professeur){
		super();
		this.id = id;
		this.version = version;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.text = text;
		this.matiere = matiere;
		this.salle = salle;
		this.professeur = professeur;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
}

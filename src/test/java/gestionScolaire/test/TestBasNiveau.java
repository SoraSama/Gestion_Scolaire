package gestionScolaire.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gestionScolaire.metier.dao.ClasseDao;
import gestionScolaire.metier.dao.ClasseMatiereDao;
import gestionScolaire.metier.dao.ClasseProfesseurDao;
import gestionScolaire.metier.dao.ClasseSalleDao;
import gestionScolaire.metier.dao.EmploiDuTempsDao;
import gestionScolaire.metier.dao.EtablissementDao;
import gestionScolaire.metier.dao.MatiereDao;
import gestionScolaire.metier.dao.ProfesseurDao;
import gestionScolaire.metier.dao.SalleDao;
import gestionScolaire.metier.dao.UtilisateurDao;
import gestionScolaire.metier.model.Adresse;
import gestionScolaire.metier.model.Classe;
import gestionScolaire.metier.model.ClasseMatiere;
import gestionScolaire.metier.model.ClasseProfesseur;
import gestionScolaire.metier.model.ClasseSalle;
import gestionScolaire.metier.model.Etablissement;
import gestionScolaire.metier.model.Matiere;
import gestionScolaire.metier.model.Professeur;
import gestionScolaire.metier.model.Salle;
import gestionScolaire.metier.model.TypeEtablissement;
import gestionScolaire.metier.model.Utilisateur;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBasNiveau {

	@Autowired
	private EtablissementDao etablissementDao;
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private ClasseDao classeDao;
	
	@Autowired
	private SalleDao salleDao;
	
	@Autowired
	private MatiereDao matiereDao;
	
	@Autowired
	private ProfesseurDao professeurDao;
	
	@Autowired
	private ClasseMatiereDao classeMatiereDao;
	
	@Autowired
	private ClasseProfesseurDao classeProfesseurDao;
	
	@Autowired
	private ClasseSalleDao classeSalleDao;
	
	@Autowired
	private EmploiDuTempsDao emploiDuTempsDao;
	
	/* Test Matiere */
	@Test
	public void testMatiere(){
		
		
		Matiere mat = new Matiere();
		mat.setNom("Math");
		mat.setCouleur("red");
		

		Matiere mat2 = new Matiere();
		mat2.setNom("Allemand");
		mat2.setCouleur("yellow");
		
		Matiere mat3 = new Matiere();
		mat3.setNom("Anglais");
		mat3.setCouleur("blue");
		
		Matiere mat4 = new Matiere();
		mat4.setNom("Arts Plastiques");
		mat4.setCouleur("white");
		
		Matiere mat5 = new Matiere();
		mat5.setNom("Biologie");
		mat5.setCouleur("green");
		
		Matiere mat6 = new Matiere();
		mat6.setNom("Economie");
		mat6.setCouleur("cyan");
		
		Matiere mat7 = new Matiere();
		mat7.setNom("EPS");
		mat7.setCouleur("gray");
		
		Matiere mat8 = new Matiere();
		mat8.setNom("Français");
		mat8.setCouleur("magenta");
		
		Matiere mat9 = new Matiere();
		mat9.setNom("Histoire-Geographie");
		mat9.setCouleur("orange");
		
		Matiere mat10 = new Matiere();
		mat10.setNom("Physique-Chimie");
		mat10.setCouleur("red");
		
		Matiere mat11 = new Matiere();
		mat11.setNom("Philosophie");
		mat11.setCouleur("black");
		
		Matiere mat12 = new Matiere();
		mat12.setNom("Statistique");
		mat12.setCouleur("green");
		
		Matiere mat13 = new Matiere();
		mat13.setNom("Espagnol");
		mat13.setCouleur("orange");
		
		matiereDao.create(mat);
		matiereDao.create(mat2);
		matiereDao.create(mat3);
		matiereDao.create(mat4);
		matiereDao.create(mat5);
		matiereDao.create(mat6);
		matiereDao.create(mat7);
		matiereDao.create(mat8);
		matiereDao.create(mat9);
		matiereDao.create(mat10);
		matiereDao.create(mat11);
		matiereDao.create(mat12);
		matiereDao.create(mat13);
		
		// Nombre de matière en base
		List<Matiere> matieres = matiereDao.findAll(); 
		assertEquals(13, matieres.size());
		
		// indice élement dans la table Matière
		assertEquals("Biologie", matiereDao.find("Biologie").getNom());
		
		assertEquals("Arts Plastiques", matiereDao.find("Arts Plastiques").getNom());
		
		assertEquals("Espagnol", matiereDao.find("Espagnol").getNom());
		
		
		// Modif 7e et 13e éléments
		Matiere matFind7 = matiereDao.find("EPS");
		Matiere matFind13 = matiereDao.find("Espagnol");
		
		assertEquals("EPS", matFind7.getNom());
		assertEquals("orange", matFind13.getCouleur());
		matFind7.setNom("Education-Physique-Sportive");
		matFind13.setCouleur("red");
		assertEquals("Education-Physique-Sportive", matFind7.getNom());
		assertEquals("red", matFind13.getCouleur());
		
		// Suppression d'éléments
		Matiere matFind12 = matiereDao.find(12L);
		
		matiereDao.delete(matFind12);
		matFind12 = matiereDao.find(matFind12.getId());
		assertNull(matFind12);
		
		matiereDao.delete(mat4);
		
		List<Matiere> matieresMAJ = matiereDao.findAll();
		assertEquals(2, matieres.size() - matieresMAJ.size());
	}
	
	
	/* */
	@Test
	public void testEtablissement(){
		
		Etablissement eta = new Etablissement();
		eta.setNom("Rene Cassin");
		eta.setType(TypeEtablissement.Lycee);
		Adresse adr = new Adresse();
		adr.setCodePostal("35000");
		adr.setPays("FRANCE");
		adr.setRue("7, rue de la république");
		adr.setVille("RENNES");
		eta.setAdresse(adr);
		
		Etablissement eta2 = new Etablissement();
		eta2.setNom("Jean Val Jean");
		eta2.setType(TypeEtablissement.College);
		Adresse adr2 = new Adresse();
		adr2.setCodePostal("56530");
		adr2.setPays("FRANCE");
		adr2.setRue("19, avenue Longchamp");
		adr2.setVille("Ville2");
		eta2.setAdresse(adr2);
		
		Etablissement eta3 = new Etablissement();
		eta3.setNom("Saint-Pierre");
		eta3.setType(TypeEtablissement.Lycee);
		Adresse adr3 = new Adresse();
		adr3.setCodePostal("91800");
		adr3.setPays("FRANCE");
		adr3.setRue("70, rue de Montgeron");
		adr3.setVille("Brunoy");
		eta3.setAdresse(adr3);
		
		Etablissement eta4 = new Etablissement();
		eta4.setNom("Ozar Hatorah");
		eta4.setType(TypeEtablissement.Lycee);
		Adresse adr4 = new Adresse();
		adr4.setCodePostal("94000");
		adr4.setPays("FRANCE");
		adr4.setRue("2, Voie Félix Eboué");
		adr4.setVille("Creteil");
		eta4.setAdresse(adr4);
		
		Etablissement eta5 = new Etablissement();
		eta5.setNom("François Rabelais");
		eta5.setType(TypeEtablissement.Lycee);
		Adresse adr5 = new Adresse();
		adr5.setCodePostal("75018");
		adr5.setPays("FRANCE");
		adr5.setRue("9, rue Francis de Croisset");
		adr5.setVille("Paris");
		eta5.setAdresse(adr5);
		
		Etablissement eta6 = new Etablissement();
		eta6.setNom("Wolfgang Amadeus Mozart");
		eta6.setType(TypeEtablissement.Lycee);
		Adresse adr6 = new Adresse();
		adr6.setCodePostal("93150");
		adr6.setPays("FRANCE");
		adr6.setRue("10, avenue Charles de Gaulle");
		adr6.setVille("Le Blanc-Mesnil");
		eta6.setAdresse(adr6);
		
		Etablissement eta7 = new Etablissement();
		eta7.setNom("Carcado Saisseval");
		eta7.setType(TypeEtablissement.Lycee);
		Adresse adr7 = new Adresse();
		adr7.setCodePostal("75006");
		adr7.setPays("FRANCE");
		adr7.setRue("121, boulevard Raspail");
		adr7.setVille("Paris");
		eta7.setAdresse(adr7);
		
		etablissementDao.create(eta);
		etablissementDao.create(eta2);
		etablissementDao.create(eta3);
		etablissementDao.create(eta4);
		etablissementDao.create(eta5);
		etablissementDao.create(eta6);
		etablissementDao.create(eta7);
		
		Etablissement etafind6 = etablissementDao.find("Wolfgang Amadeus Mozart");
		assertEquals("93150", etafind6.getAdresse().getCodePostal());
	}
	
	
	/* */
	@Test
	public void testProfesseur(){
		Date dateNaiss;
		Calendar cal;
		
		Professeur prof = new Professeur();
		prof.setNom("Davis");
		prof.setPrenom("Lauren");
		cal = GregorianCalendar.getInstance();
		cal.set(1971, Calendar.NOVEMBER, 30);
		dateNaiss = cal.getTime();
		prof.setDateDeNaissance(dateNaiss);
		prof.getMatieresEnseignees().add("Histoire-Geographie");
		prof.getMatieresEnseignees().add("Anglais");
		
		Professeur prof2 = new Professeur();
		prof2.setNom("Senate");
		prof2.setPrenom("Harry");
		cal = GregorianCalendar.getInstance();
		cal.clear();
		cal.set(1970, Calendar.MAY, 11);
		dateNaiss = cal.getTime();
		prof2.setDateDeNaissance(dateNaiss);
		prof2.getMatieresEnseignees().add("Litterature");
		prof2.getMatieresEnseignees().add("Francais");
		
		
		Professeur prof3 = new Professeur();
		prof3.setNom("Hendricks");
		prof3.setPrenom("Marla");
		cal = GregorianCalendar.getInstance();
		cal.set(1949, Calendar.AUGUST, 21);
		dateNaiss = cal.getTime();
		prof3.setDateDeNaissance(dateNaiss);
		prof3.getMatieresEnseignees().add("Etude Sociale");
		prof3.getMatieresEnseignees().add("Philosophie");
		
		professeurDao.create(prof);
		professeurDao.create(prof2);
		professeurDao.create(prof3);
		
		
		assertEquals(2, prof2.getMatieresEnseignees().size());
		
		Professeur profFind = professeurDao.find("Senate"); 
		profFind.getMatieresEnseignees().remove("Litterature");  
		professeurDao.update(profFind);
		
		assertEquals(1, professeurDao.find("Senate","Harry").getMatieresEnseignees().size());
	}
	
	/* */
	@Test
	public void testSalle(){
		Salle salle = new Salle();
		salle.setNom("001");
		salle.setCapacite(25);
		salle.getMatieresExclues().add("Musique");
		salle.getMatieresExclues().add("Economie");
		
		Salle salle2 = new Salle();
		salle2.setNom("002");
		salle2.setCapacite(30);
		
		Salle salle3 = new Salle();
		salle3.setNom("101");
		salle3.setCapacite(15);
		salle3.getMatieresExclues().add("Musique");
		
		Salle salle4 = new Salle();
		salle4.setNom("102");
		salle4.setCapacite(30);
		salle4.getMatieresExclues().add("Math");
		salle4.getMatieresExclues().add("Economie");
		salle4.getMatieresExclues().add("Physique-Chimie");
		salle4.getMatieresExclues().add("Statistique");
		
		Salle salle5 = new Salle();
		salle5.setNom("201");
		salle5.setCapacite(28);
		
		salleDao.create(salle);
		salleDao.create(salle2);
		salleDao.create(salle3);
		salleDao.create(salle4);
		salleDao.create(salle5);
		
		assertNull(salleDao.find("301"));
		assertEquals(30, salleDao.find("002").getCapacite());
		
		salleDao.delete(salle);
		
		assertNull(salleDao.find("001"));
		assertEquals(true, salleDao.find("102").getMatieresExclues().contains("Economie"));
		
		Salle salleFind = salleDao.find("201");
		salleFind.getMatieresExclues().add("EPS");
		salleDao.update(salleFind);
		assertEquals(1, salleDao.find("201").getVersion());
	}
	
	/* */
	@Test
	public void testUtilisateur(){
		Utilisateur util = new Utilisateur();
		util.setLogin("Spencer");
		util.setNom("POWELL");
		util.setPrenom("Axel");
		util.setMotDePasseTemporaire("54za5fQS");
		Adresse adr7 = new Adresse();
		adr7.setCodePostal("75009");
		adr7.setPays("FRANCE");
		adr7.setRue("9, rue Rougemont");
		adr7.setVille("Paris");
		util.setAdresse(adr7);
		
		Utilisateur util2 = new Utilisateur();
		util2.setLogin("Scarlett");
		util2.setNom("HARDY");
		util2.setPrenom("Julie");
		util2.setMotDePasseTemporaire("45sQRer0");
		Adresse adr8 = new Adresse();
		adr8.setCodePostal("75007");
		adr8.setPays("FRANCE");
		adr8.setRue("9, rue Rougemont");
		adr8.setVille("Paris");
		util2.setAdresse(adr8);
		
		utilisateurDao.create(util);
		utilisateurDao.create(util2);
		
		Utilisateur utilFind = utilisateurDao.find("Sora"); 
		assertNull(utilFind);
		
		utilFind = utilisateurDao.find("HARDY", "Julie");
		utilFind.getAdresse().setRue("7, chemin du Moulin Rouge");
		utilisateurDao.update(utilFind);
		assertEquals(1, utilisateurDao.find("Scarlett").getVersion());
		
		utilFind = utilisateurDao.find("Spencer");
		utilFind.setNom("HIMURA");
		utilFind.setPrenom("Kenshin");
		utilFind.setMotDePasseTemporaire("b4tt0s41");
		utilisateurDao.update(utilFind);
		
		utilFind = utilisateurDao.find("HARDY", "Julie");
		utilFind.setLogin("Agathe");
		utilisateurDao.update(utilFind);
		assertEquals(2, utilisateurDao.find("Agathe").getVersion());
	}
	
	/* */
	@Test
	public void testClasse(){
		Classe classe = new Classe();
		classe.setNbEleve(31);
		classe.setNom("Seconde A");
		classe.setProfesseurPrincipal("LeGrand"); /*  En sorte que la prof princ. soit
		 											  dans la liste des profs	*/
		Classe classe2 = new Classe();
		classe2.setNbEleve(24);
		classe2.setNom("Premiere B");
		classe2.setProfesseurPrincipal("Senate");
		
		Classe classe3 = new Classe();
		classe3.setNbEleve(20);
		classe3.setNom("Terminale C");
		classe3.setProfesseurPrincipal("Davis");
		
		Classe classe4 = new Classe();
		classe4.setNbEleve(34);
		classe4.setNom("Seconde B");
		classe4.setProfesseurPrincipal("Kid");
		
		classeDao.create(classe);
		classeDao.create(classe2);
		classeDao.create(classe3);
		
		Classe classeFind = classeDao.find("Terminale C");
		assertEquals(0, classeFind.getProfesseurs().size());
		assertEquals("Davis", classeFind.getProfesseurPrincipal());
		
		classeFind = classeDao.find("Seconde A");
		classeFind.setNom("Seconde 1");
		classeFind.setNbEleve(27);
		classeDao.update(classeFind);
		
		classeDao.create(classe4);
		
		classeFind = classeDao.find("Premiere B");
		classeDao.delete(classeFind);
		assertNull(classeDao.find("Premiere B"));
	}
	
	@Test
	public void testXDonnees(){
		Etablissement eta = etablissementDao.find("François Rabelais");
		Classe cla1 = classeDao.find("Terminale C");
		Classe cla2 = classeDao.find("Seconde 1");
		Classe cla3 = classeDao.find("Seconde B");
		cla1.setEtablissement(eta);
		cla2.setEtablissement(eta);
		//cla3.setEtablissement(eta);
		
		classeDao.update(cla1);
		classeDao.update(cla2);
		//classeDao.update(cla3);
		
		assertEquals(2, classeDao.findEtab(eta.getId()).size());
		
		//Salle salle1 = salleDao.find("002");
		Salle salle2 = salleDao.find("101");
		Salle salle3 = salleDao.find("102");
		//Salle salle4 = salleDao.find("201");
		
		salle2.setEtablissement(eta);
		salle3.setEtablissement(eta);
		salleDao.update(salle2);
		salleDao.update(salle3);
		
		Professeur prof = professeurDao.find("Davis");
		Professeur prof2 = professeurDao.find("Senate");
		
		prof.setEtablissement(eta);
		prof2.setEtablissement(eta);
		professeurDao.update(prof);
		professeurDao.update(prof2);
		
		ClasseMatiere classeMat = new ClasseMatiere(matiereDao.find("Allemand"),cla1);
		ClasseMatiere classeMat2 = new ClasseMatiere(matiereDao.find("Allemand"),cla2);
		ClasseMatiere classeMat3 = new ClasseMatiere(matiereDao.find("EPS"), cla1);
		ClasseMatiere classeMat4 = new ClasseMatiere(matiereDao.find("Philosophie"), cla1);
		ClasseMatiere classeMat5 = new ClasseMatiere(matiereDao.find("Français"),cla1);
		ClasseMatiere classeMat6 = new ClasseMatiere(matiereDao.find("EPS"), cla2);
		ClasseMatiere classeMat7 = new ClasseMatiere(matiereDao.find("Philosophie"),cla2);
		ClasseMatiere classeMat8 = new ClasseMatiere(matiereDao.find("Français"),cla2);
		ClasseMatiere classeMat9 = new ClasseMatiere(matiereDao.find("Anglais"), cla2);
		ClasseMatiere classeMat10 = new ClasseMatiere(matiereDao.find("Biologie"), cla2);
		
		classeMatiereDao.create(classeMat);
		classeMatiereDao.create(classeMat2);
		classeMatiereDao.create(classeMat3);
		classeMatiereDao.create(classeMat4);
		classeMatiereDao.create(classeMat5);
		classeMatiereDao.create(classeMat6);
		classeMatiereDao.create(classeMat7);
		classeMatiereDao.create(classeMat8);
		classeMatiereDao.create(classeMat9);
		classeMatiereDao.create(classeMat10);
		
		
		ClasseSalle classeSal = new ClasseSalle();
		ClasseSalle classeSal2 = new ClasseSalle();
		classeSal.setClasse(cla1);
		classeSal.setSalle(salle2);
		
		classeSal2.setClasse(cla2);
		classeSal2.setSalle(salle3);
		classeSalleDao.create(classeSal);
		classeSalleDao.create(classeSal2);
		
		classeSal2.setSalle(salle2);
		classeSal.setSalle(salle3);
		
		classeSalleDao.update(classeSal);
		classeSalleDao.update(classeSal2);
		
		
		ClasseProfesseur classeProf = new ClasseProfesseur(professeurDao.find("Davis"),cla2);
		ClasseProfesseur classeProf2 = new ClasseProfesseur(professeurDao.find("Senate"),cla2);
		
		classeProfesseurDao.create(classeProf);
		classeProfesseurDao.create(classeProf2);
		
		long val = classeDao.find("Seconde 1").getProfesseurs().get(1).getProfesseur().getId();
		assertEquals(26, val);
		
		Utilisateur utilFind = utilisateurDao.find("Agathe");
		utilFind.setEtablissement(eta);
		utilisateurDao.update(utilFind);
		
		val = utilisateurDao.findEtab(9L).get(0).getId();
		assertEquals(34, val);
		
		Classe clafind = classeDao.find("Seconde 1");
		assertEquals(6, clafind.getMatieres().size());
		
		// ** //
//		classeDao.delete(clafind);
//		salleDao.delete(salleDao.find("102"));
//		
//		clafind = classeDao.find("Terminale C");
//		classeDao.delete(clafind);
//		
//		/* SUPPRIMER LES CLASSES D'UN ETABLISSEMENT AVANT L'ETABLISSEMENT !!!! */
//		Etablissement etaFind = etablissementDao.find("François Rabelais");		
//		etablissementDao.delete(etaFind);
//		assertEquals(1, classeDao.findAll().size());
//		
		// ** //
	}
		
}

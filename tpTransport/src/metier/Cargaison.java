package metier;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeCargaison")
@XmlRootElement
@XmlSeeAlso({ CargaisonAerienne.class, CargaisonRoutiere.class })
public class Cargaison {

	/**
	 * attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idReference;
	private int distance;
	private Date dateLivraison = new Date();

	/**
	 * attribut de relation
	 */
	// xmltransient sur le getter pour casser un boucle infinie
	@OneToMany(mappedBy = "cargaison")
	private List<Marchandise> marchandises;

	public long getIdReference() {
		return idReference;
	}

	public void setIdReference(long idReference) {
		this.idReference = idReference;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	// permet de casser une boucle infinie d'imbrication lors du passage en xml
	@XmlTransient
	public List<Marchandise> getMarchandises() {
		return marchandises;
	}

	public void setMarchandises(List<Marchandise> marchandises) {
		this.marchandises = marchandises;
	}

}

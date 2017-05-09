package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Cargaison;
import metier.Marchandise;

/**
 * Session Bean implementation class Transport
 */
@Stateless
//@LocalBean
public class Transport implements ITransportRemote, ITransportLocal {

	@PersistenceContext(name = "transport-pu")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public Transport() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCargaison(Cargaison c) {

		em.persist(c);

	}

	@Override
	public void addMarchandise(Marchandise m, long cargaisonId) {

		m.setCargaison(em.find(Cargaison.class, cargaisonId));
		em.persist(m);

	}

	@Override
	public List<Cargaison> getAllCargaison() {

		@SuppressWarnings("unchecked")
		List<Cargaison> allCargaisons = em.createQuery("SELECT c FROM Cargaison c").getResultList();

		return allCargaisons;
	}

	@Override
	public List<Marchandise> getMarchandiseParMC(String mc) {

		Query q = em.createQuery("SELECT m FROM Marchandise m WHERE m.nom LIKE :mc");
		q.setParameter("mc", "%" + mc + "%");

		@SuppressWarnings("unchecked")
		List<Marchandise> marchandises = q.getResultList();

		return marchandises;
	}

	@Override
	public void deleteMarchandise(long numero) {
		
		em.remove(em.find(Marchandise.class, numero));

	}

}

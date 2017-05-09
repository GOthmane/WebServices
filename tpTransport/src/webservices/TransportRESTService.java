package webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ITransportLocal;
import metier.Cargaison;
import metier.CargaisonAerienne;
import metier.CargaisonRoutiere;
import metier.Marchandise;

@Stateless
@Path("/TransportREST")
public class TransportRESTService {

	// injection de la dao
	@EJB
	ITransportLocal it;

	@POST
	@Path("/addCargaisonRoutiere/{distance}/{temp}")
	public void addCargaisonRoutiere(@PathParam("distance") int distance, @PathParam("temp") double temp) {

		System.out.println("TEST");
		
		CargaisonRoutiere c = new CargaisonRoutiere();
		c.setDistance(distance);
		c.setTemperatureConservation(temp);

		it.addCargaison(c);
	}

	@POST
	@Path("/addCargaisonAeriene/{distance}/{poids}")
	public void addCargaisonAeriene(@PathParam("distance") int distance, @PathParam("poids") double poids) {

		CargaisonAerienne c = new CargaisonAerienne();
		c.setDistance(distance);
		c.setPoidsMax(poids);

		it.addCargaison(c);
	}

	@POST
	@Path("/addMarchandise/{nom}/{poids}/{volume}/{cargaisonId}")
	public void addMarchandise(@PathParam("nom") String nom, @PathParam("poids") double poids,
			@PathParam("volume") double volume, @PathParam("cargaisonId") long cargaisonId) {

		Marchandise m = new Marchandise();
		m.setNom(nom);
		m.setPoids(poids);
		m.setVolume(volume);

		it.addMarchandise(m, cargaisonId);
	}

	@GET
	@Path("/getAllCargaison")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargaison> getAllCargaison() {
		return it.getAllCargaison();
	}

//	public List<Marchandise> getMarchandiseParMC(@WebParam(name = "mc") String mc) {
//		return it.getMarchandiseParMC(mc);
//	}
//
//	public void deleteMarchandise(@WebParam(name = "numero") long numero) {
//		it.deleteMarchandise(numero);
//	}

}

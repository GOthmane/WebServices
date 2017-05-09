package webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dao.ITransportLocal;
import dao.Transport;
import metier.Cargaison;
import metier.Marchandise;

@WebService(serviceName="TransportSOAP")
@Stateless
public class TransportSOAPService {
	
	//injection de la dao
	@EJB
	ITransportLocal it;
	
	@WebMethod(operationName="addCargaison")
	public void addCargaison(@WebParam(name="cargaison") Cargaison c){
		it.addCargaison(c);
	}

	@WebMethod(operationName="addMarchandise")
	public void addMarchandise(@WebParam(name="marchandise")Marchandise m, @WebParam(name="cargaisonId") long cargaisonId){
		it.addMarchandise(m, cargaisonId);
	}

	@WebMethod(operationName="getAllCargaison")
	public List<Cargaison> getAllCargaison(){
		return it.getAllCargaison();
	}

	@WebMethod(operationName="getMarchandiseParMC")
	public List<Marchandise> getMarchandiseParMC(@WebParam(name="mc") String mc){
		return it.getMarchandiseParMC(mc);		
	}

	@WebMethod(operationName="deleteMarchandise")
	public void deleteMarchandise(@WebParam(name="numero") long numero){
		it.deleteMarchandise(numero);
	}
}

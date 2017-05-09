package ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.Compte;

@WebService(serviceName="BanqueWS")
public class BanqueService{
	
	@WebMethod(operationName="ConversionED")
	public double conversionEuroDollar(@WebParam(name="mt")double montant){
		return montant*1.09;
	}
	
	@WebMethod
	public Compte getCompte(int code){
		Compte c = new Compte();
		c.setCode(code);
		c.setSolde(10000);
		c.setDateCreation(new Date());
		return c;
	}
	
	@WebMethod
	public List<Compte> getComptes(){
		
		List<Compte> cptes = new ArrayList<Compte>();
		
		Compte c1 = new Compte();
		c1.setCode(2);
		c1.setSolde(2000);
		c1.setDateCreation(new Date());
		
		Compte c2 = new Compte();
		c2.setCode(3);
		c2.setSolde(3000);
		c2.setDateCreation(new Date());
		cptes.add(c1);cptes.add(c2);
		return cptes;
	}

}

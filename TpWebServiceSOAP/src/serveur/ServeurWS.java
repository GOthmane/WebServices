package serveur;

import javax.xml.ws.Endpoint;

import ws.BanqueService;

public class ServeurWS {

	public static void main(String[] args) {
		
		// 1 - Cr�ation du serveur
		// Adresse ou est deploye le web service
		String url = "http://localhost:8585/";
		// 2 - Publication du web service
		Endpoint.publish(url, new BanqueService());
		System.out.println(url);

	}

}

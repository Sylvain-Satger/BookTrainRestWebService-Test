package test.BookTrain;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import junit.framework.Assert;
import test.utils.HttpUtils;
import test.utils.XMLUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static org.junit.Assert.*;

public class FindTrain {
	public static int httpResponseCode;
	String villeDepart="";
	String villeArrivee="";

	@Given("^Il y a uniquement des trains reliant Lyon a Avignon$")
	public void Il_y_a_uniquement_des_trains_reliant_Lyon_a_Avignon() {
	    //Rien à faire
	}

	@When("^Je recherche les trains au depart de (.*),$")
	public void Je_recherche_les_trains_au_depart_de(String villeD) {
		villeDepart=villeD;
	}

	@When("^allant a (.*).$")
	public void allant_a(String villeA) {
		villeArrivee=villeA;
	}

	@Then("^Je recois une liste de trains.$")
	public void Je_recois_une_liste_de_trains() throws Exception {
		//Envoi requête et vérification code retour
		HttpUtils httpUtils = new HttpUtils();
		httpResponseCode = -999;
		String url = "http://localhost:9992/rest/trains/search?departure=" + villeDepart + "&arrival=" + villeArrivee;
		System.out.println(url);
		String reponse = httpUtils.sendGet(url);
		Assert.assertEquals(httpResponseCode, 200);

		// Vérification du contenu de la réponse XML
		XMLUtils xmlUtils = new XMLUtils();
		Document doc = xmlUtils.parseXML(reponse);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("train");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				Assert.assertEquals("Lyon", eElement.getElementsByTagName("villeDepart").item(0).getTextContent());
				Assert.assertEquals("Avignon", eElement.getElementsByTagName("villeArrivee").item(0).getTextContent());
			}
		}	
	}

	@Then("^Je recois une liste de trains vide.$")
	public void Je_recois_une_liste_de_trains_vide() throws Exception {
		//Envoi requête et vérification code retour
		HttpUtils httpUtils = new HttpUtils();
		httpResponseCode = -999;
		String url = "http://localhost:9992/rest/trains/search?departure=" + villeDepart + "&arrival=" + villeArrivee;
		System.out.println(url);
		String reponse = httpUtils.sendGet(url);
		Assert.assertEquals(httpResponseCode, 200);

		// Vérification du contenu de la réponse XML
		XMLUtils xmlUtils = new XMLUtils();
		Document doc = xmlUtils.parseXML(reponse);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("train");
		if(nList.getLength()==0){
			Assert.assertTrue(true);			
		}
		else
		{
			Assert.assertTrue(false);
		}	
	}
}


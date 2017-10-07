package test.BookTrain;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import junit.framework.Assert;
import test.utils.HttpUtils;
import test.utils.VarGlobales;
import test.utils.XMLUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static org.junit.Assert.*;

public class BookTrain {
			
	@Given("^Il y a des trains reliant Lyon a Avignon disponibles$")
	public void Il_y_a_des_trains_reliant_Lyon_a_Avignon_disponibles() {
	    //Rien à faire
	}

	@When("^Je valide une reservation pour (\\d+) personnes sur le train de (\\d+)h(\\d+),$")
	public void Je_valide_une_reservation_pour_personnes_sur_le_train_de_h_(int nbPersonne, int heure, int minute) throws Exception {
		//Envoi requête et vérification code retour
		HttpUtils httpUtils = new HttpUtils();
		VarGlobales.httpResponseCode = -999;
		String url = "http://localhost:9992/rest/trains/booktrains?numTrain=" + FindTrain.numTrain + "&numberPlaces=" + nbPersonne;
		httpUtils.sendGet(url);
		Assert.assertEquals(VarGlobales.httpResponseCode, 200);
	}

	@When("^que je fais une recherche sur ma reservation$")
	public void que_je_fais_une_recherche_sur_ma_reservation() {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^Je visualise ma reservation.$")
	public void Je_visualise_ma_reservation() {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}


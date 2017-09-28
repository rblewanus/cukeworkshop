package cuke.common.steps;

import cucumber.api.java.nl.*;
import cuke.common.implementation.LeningImpl;

/**
 * Created on 28-2-2017.
 */
public class LeningSteps {

    @Gegeven("^de klant wil informatie over een lening$")
    public void deKlantWilInformatieOverEenLening() {
        LeningImpl.gaNaarBddWorkshopPagina();
    }

}

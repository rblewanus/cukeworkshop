package cuke.common.model;

/**
 * Created on 27-2-2017.
 *
 * Een "Klant" object, die gebruikt kan worden in een test. Bevat alle onderdelen die ingevuld moeten worden in het BDD formulier met persoonsgegevens.
 */
public class Klant {

    private String naam;
    private String geslacht;
    private String geboortedatum;
    private String adres;
    private String telefoonnummer;
    private String aantal_kinderen;
    private String rekeningnummer;
    private String datum_indiensttreding;
    private String bruto_inkomen;
    private String woonlasten;
    private String woonsituatie;
    private String burgerlijke_staat;
    private String type_inkomen;
    private Lening lening;

    public Klant(String naam, String geslacht, String geboortedatum, String adres, String telefoonnummer, String aantal_kinderen, String rekeningnummer, String datum_indiensttreding, String bruto_inkomen, String woonlasten, String woonsituatie, String burgerlijke_staat, String type_inkomen, Lening lening) {
        this.naam = naam;
        this.geslacht = geslacht;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
        this.telefoonnummer = telefoonnummer;
        this.aantal_kinderen = aantal_kinderen;
        this.rekeningnummer = rekeningnummer;
        this.datum_indiensttreding = datum_indiensttreding;
        this.bruto_inkomen = bruto_inkomen;
        this.woonlasten = woonlasten;
        this.woonsituatie = woonsituatie;
        this.burgerlijke_staat = burgerlijke_staat;
        this.type_inkomen = type_inkomen;
        this.lening = lening;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getAantal_kinderen() {
        return aantal_kinderen;
    }

    public void setAantal_kinderen(String aantal_kinderen) {
        this.aantal_kinderen = aantal_kinderen;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public String getDatum_indiensttreding() {
        return datum_indiensttreding;
    }

    public void setDatum_indiensttreding(String datum_indiensttreding) {
        this.datum_indiensttreding = datum_indiensttreding;
    }

    public String getBruto_inkomen() {
        return bruto_inkomen;
    }

    public void setBruto_inkomen(String bruto_inkomen) {
        this.bruto_inkomen = bruto_inkomen;
    }

    public String getWoonlasten() {
        return woonlasten;
    }

    public void setWoonlasten(String woonlasten) {
        this.woonlasten = woonlasten;
    }

    public String getWoonsituatie() {
        return woonsituatie;
    }

    public void setWoonsituatie(String woonsituatie) {
        this.woonsituatie = woonsituatie;
    }

    public String getBurgerlijke_staat() {
        return burgerlijke_staat;
    }

    public void setBurgerlijke_staat(String burgerlijke_staat) {
        this.burgerlijke_staat = burgerlijke_staat;
    }

    public String getType_inkomen() {
        return type_inkomen;
    }

    public void setType_inkomen(String type_inkomen) {
        this.type_inkomen = type_inkomen;
    }

    public Lening getLening() {
        return lening;
    }

    public void setLening(Lening lening) {
        this.lening = lening;
    }
}

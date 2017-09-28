package cuke.common.model;

/**
 * Created on 27-02-2017.
 *
 * Een lening object die gebruikt kan worden in de testen. In plaats van 2 "private static String" wordt dan een "private static Lening" gemaakt en gebruikt in de test.
 */
public class Lening {

    private String leningtype;
    private String bedrag;

    public Lening(String leningtype, String bedrag) {
        this.leningtype = leningtype;
        this.bedrag = bedrag;
    }

    public String getLeningtype() {
        return leningtype;
    }

    public void setLeningtype(String leningtype) {
        this.leningtype = leningtype;
    }

    public String getBedrag() {
        return bedrag;
    }

    public void setBedrag(String bedrag) {
        this.bedrag = bedrag;
    }
}

import java.time.LocalDate;

public final class Dom extends Budynek {
    private int powierzchniaDzialki;
    public Dom(String ulica, int numer, String miejscowosc, String kod, int powierzchnia, double cena, LocalDate data, int powierzchniaDzialki) {
        super(ulica,numer,miejscowosc,kod,powierzchnia,cena,data);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }
    @Override
    public String toString() {
        return super.toString() + "Powierzchnia działki: " + powierzchniaDzialki;
    }
}

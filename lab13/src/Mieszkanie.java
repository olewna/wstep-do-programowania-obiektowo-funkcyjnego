import java.time.LocalDate;

public final class Mieszkanie extends Budynek {
    private int numerMieszkania;
    private int numerPietra;
    public Mieszkanie(String ulica, int numer, String miejscowosc, String kod, int powierzchnia, double cena, LocalDate data, int numerMieszkania, int numerPietra) {
        super(ulica, numer, miejscowosc, kod, powierzchnia, cena, data);
        this.numerMieszkania = numerMieszkania;
        this.numerPietra = numerPietra;
    }
    public int getNumerPietra() {
        return this.numerPietra;
    }
    @Override
    public String toString() {
        return super.toString() + "Numer mieszkania: " + numerMieszkania + " Numer pietra: " +  numerPietra;
    }
}

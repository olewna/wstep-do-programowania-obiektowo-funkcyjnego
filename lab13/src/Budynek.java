import java.time.LocalDate;

public abstract sealed class Budynek permits Dom, Mieszkanie {
    protected String ulica;
    protected int numerDomu;
    protected String miejscowosc;
    protected String kodPocztowy;
    protected int powierzchnia;
    protected double cena;
    protected LocalDate dataOferty;
    public Budynek(String ulica,int numer,String miejscowosc,String kod,int powierzchnia,double cena,LocalDate data){
        this.ulica = ulica;
        this.numerDomu = numer;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kod;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataOferty = data;
    }
    public LocalDate getData() {
        return this.dataOferty;
    }
    public String getMiejscowosc() {
        return this.miejscowosc;
    }
    public int getPowierzchnia() {
        return this.powierzchnia;
    }
    public double getCena() {
        return this.cena;
    }
    @Override
    public String toString() {
        return "Ulica: " + ulica + " Numer domu: " + numerDomu + " Miejscowość: " + miejscowosc + " Kod pocztowy: " + kodPocztowy + " Powierzchnia domu: " + powierzchnia + " Cena: " + cena + " Data obowiązywania oferty: " + dataOferty + " ";
    };
}

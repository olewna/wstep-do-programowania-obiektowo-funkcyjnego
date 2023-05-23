import java.time.LocalTime;
public abstract sealed class Wydarzenie permits Zadanie, Spotkanie{
    protected String opis;
    protected LocalTime poczatek;
    protected LocalTime koniec;
    public Wydarzenie(String opis, LocalTime poczatek, LocalTime koniec) {
        this.opis = opis;
        this.poczatek = poczatek;
        this.koniec = koniec;
    }
    public LocalTime getStart(){ return this.poczatek; }
    public LocalTime getKoniec(){ return this.koniec; }
    @Override
    public String toString() {
        return "Opis: " + opis + " Rozpoczęcie : " + poczatek.toString() + " Zakończenie : " + koniec.toString();
    };
}

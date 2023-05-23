import java.time.LocalTime;
public final class Spotkanie extends Wydarzenie {
    private String priorytet;
    public static final LocalTime NAJWCZESNIEJ = LocalTime.of(7,0);
    public Spotkanie(String opis, LocalTime start, LocalTime koniec, String priorytet){
        super(opis,start,koniec);
        this.priorytet = priorytet;
    }
    public String getPriorytet() { return this.priorytet; }
    @Override
    public String toString(){
        return super.toString() + " Priorytet: " + priorytet;
    }
}

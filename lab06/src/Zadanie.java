import java.time.LocalTime;
public final class Zadanie extends Wydarzenie{
    private String status;
    public static final LocalTime NAJWCZESNIEJ = LocalTime.of(6,0);
    public Zadanie(String opis, LocalTime poczatek, LocalTime koniec, String status) {
        super(opis, poczatek, koniec);
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return super.toString() + " Status: " + status;
    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private final ArrayList<Budynek> listaOfert;
    public ListaOfert() {
        this.listaOfert = new ArrayList<>();
        this.listaOfert.add(new Dom("gdanska",7,"Gdansk","83-201",120,300000.99, LocalDate.now(),1000));
        this.listaOfert.add(new Dom("cicha",1,"Kartuzy","83-332",80,500000.99, LocalDate.parse("2023-12-27"),500));
        this.listaOfert.add(new Dom("dluga",119,"Gdansk","88-201",95,420420.99, LocalDate.parse("2023-02-20"),300));
        this.listaOfert.add(new Dom("wysockiego",32,"Gdansk","88-201",110,420420.99, LocalDate.parse("2024-02-10"),300));
        this.listaOfert.add(new Mieszkanie("belgraua",175,"Gdansk","88-201",22,420420.99, LocalDate.parse("2023-07-24"),53,7));
        this.listaOfert.add(new Mieszkanie("sojowa",120,"Gdansk","88-201",50,4000.99, LocalDate.now(),40, 3));
        this.listaOfert.add(new Mieszkanie("krotka",14,"Kartuzy","83-332",30,4200.69, LocalDate.parse("2023-10-20"),12, 1));
        this.listaOfert.add(new Mieszkanie("glowna",72,"Gdansk","88-201",44,2500.00, LocalDate.parse("2023-06-20"),21, 2));
    }

    public void dodaj(Budynek x) {
        this.listaOfert.add(x);
    }
    public ArrayList<Budynek> wyswietl(Predicate<Budynek> pred) {
        ArrayList<Budynek> nowaListaOfert = new ArrayList<>();
        for (Budynek oferta : listaOfert) {
            if (pred.test(oferta)) {
                nowaListaOfert.add(oferta);
            }
        }
        return nowaListaOfert;
    }
}

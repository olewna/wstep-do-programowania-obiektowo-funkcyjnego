import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static ListaOfert listaOfert;
    private static boolean run = true;
    private static int wybor;
    private static LocalDate dzisiaj = LocalDate.now();
    public static void main(String[] args) {
        System.out.println("Program obsługujący oferte sprzedaży mieszkań i domów.");
        listaOfert = new ListaOfert();
        while(run) {
            opcje();
            switcher();
        }
    }
    public static void opcje() {
        System.out.println("""
                Wybierz opcję:
                1. Dodanie domu.
                2. Dodanie mieszkania.
                3. Wyswietl aktualne oferty domow.
                4. Wyswietl aktualne oferty mieszkan.
                5. Wyswietl aktualne oferty domow z miejscowoscia i powierzchnia nie mniejsza niz podana.
                6. Wyswietl aktualne oferty mieszkan z miejscowoscia, cena nie wieksza niz podana oraz pietrem wyzszym lub podanym.
                7. Wyjscie.
                """);
        wybor = SCANNER.nextInt();
    }
    public static void switcher() {
        switch (wybor) {
            case 1 -> dodajDom();
            case 2 -> dodajMieszkanie();
            case 3 -> pokazDomy();
            case 4 -> pokazMieszkania();
            case 5 -> pokazDomyZParametrami();
            case 6 -> pokazMieszkaniaZParametrami();
            case 7 -> run = false;
            default -> System.out.println("Prosze podac odpowiednia opcje.\n");
        }
    }
    public static void dodajDom() {
        System.out.println("Ulica: ");
        SCANNER.nextLine();
        String ulica = SCANNER.nextLine();

        System.out.println("Numer domu: ");
        int numerDomu = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.println("Miejscowosc: ");
        String miejscowosc = SCANNER.nextLine();

        System.out.println("Kod pocztowy: ");
        String kodPocztowy = SCANNER.nextLine();

        System.out.println("Powierzchnia: ");
        int powierzchnia = SCANNER.nextInt();

        System.out.println("Cena: ");
        double cena = SCANNER.nextDouble();
        SCANNER.nextLine();

        System.out.println("Powierzchnia dzialki: ");
        int powierzchniaDzialki = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.println("Data obowiązywania oferty: (YYYY-MM-DD)");
        String x = SCANNER.nextLine();
        LocalDate data = LocalDate.parse(x);

        Dom dom = new Dom(ulica,numerDomu,miejscowosc,kodPocztowy,powierzchnia,cena,data,powierzchniaDzialki);
        listaOfert.dodaj(dom);
    }
    public static void dodajMieszkanie() {
        System.out.println("Ulica: ");
        SCANNER.nextLine();
        String ulica = SCANNER.nextLine();

        System.out.println("Numer domu: ");
        int numerDomu = SCANNER.nextInt();

        System.out.println("Numer mieszkania: ");
        int numerMieszkania = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.println("Miejscowosc: ");
        String miejscowosc = SCANNER.nextLine();

        System.out.println("Kod pocztowy: ");
        String kodPocztowy = SCANNER.nextLine();

        System.out.println("Powierzchnia: ");
        int powierzchnia = SCANNER.nextInt();

        System.out.println("Numer pietra: ");
        int numerPietra = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.println("Cena: ");
        double cena = SCANNER.nextDouble();
        SCANNER.nextLine();

        System.out.println("Data obowiązywania oferty: (YYYY-MM-DD)");
        String x = SCANNER.nextLine();
        LocalDate data = LocalDate.parse(x);

        Mieszkanie mieszkanie = new Mieszkanie(ulica,numerDomu,miejscowosc,kodPocztowy,powierzchnia,cena,data,numerMieszkania,numerPietra);
        listaOfert.dodaj(mieszkanie);
    }

    public static void pokazDomy() {
        Predicate<Budynek> pred = x -> {
            if (x instanceof Dom) {
                return x.getData().isAfter(dzisiaj) || x.getData().equals(dzisiaj);
            }
            return false;
        };

        printOrEmpty(pred);
    }
    public static void pokazMieszkania() {
        Predicate<Budynek> pred = x -> {
            if (x instanceof Mieszkanie) {
                return x.getData().isAfter(dzisiaj) || x.getData().equals(dzisiaj);
            }
            return false;
        };

        printOrEmpty(pred);
    }
    public static void pokazDomyZParametrami() {
        SCANNER.nextLine();
        System.out.println("Podaj miejscowość: ");
        String miejsce = SCANNER.nextLine();

        System.out.println("Podaj powierzchnie: ");
        int powierzchnia = SCANNER.nextInt();

        Predicate<Budynek> pred = x -> {
            if (x instanceof Dom ) {
                return (x.getData().isAfter(dzisiaj) || x.getData().equals(dzisiaj)) && x.getPowierzchnia() >= powierzchnia && x.getMiejscowosc().equals(miejsce);
            }
            return false;
        };

        printOrEmpty(pred);
    }
    public static void pokazMieszkaniaZParametrami() {
        SCANNER.nextLine();
        System.out.println("Podaj miejscowość: ");
        String miejsce = SCANNER.nextLine();

        System.out.println("Podaj cene: ");
        double cena = SCANNER.nextDouble();

        System.out.println("Podaj pietro: ");
        int pietro = SCANNER.nextInt();

        Predicate<Budynek> pred = x -> {
            if (x instanceof Mieszkanie ) {
                return (x.getData().isAfter(dzisiaj) || x.getData().equals(dzisiaj)) && x.getMiejscowosc().equals(miejsce) && x.getCena() <= cena && ((Mieszkanie) x).getNumerPietra() >= pietro;
            }
            return false;
        };

        printOrEmpty(pred);
    }
    public static void printOrEmpty(Predicate<Budynek> p) {
        ArrayList<Budynek> lista = listaOfert.wyswietl(p);
        if(lista.isEmpty()){
            System.out.println("Brak ofert.");
            return;
        }
        for (Budynek oferta : lista) {
            System.out.println(oferta.toString());
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------TEST---------------");
        Walec walec = new Walec();
        walec.ustawPromien(10);
        walec.ustawWysokosc(10);
        System.out.println("Pole podstawy: " + walec.polePodstawy() + "\nPole boczne: " + walec.poleBoczne() + "\nPole calkowite: " + walec.poleCalkowite() + "\nObjetość: " + walec.objetosc());
        walec = new Walec(1,1);
        System.out.println("Pole podstawy: " + walec.polePodstawy() + "\nPole boczne: " + walec.poleBoczne() + "\nPole calkowite: " + walec.poleCalkowite() + "\nObjetość: " + walec.objetosc());
        System.out.println("------------END OF TEST------------\n\n\n");

        System.out.println("Program wyliczający pola powierzchni i objętośc walca.");
        Scanner scanner = new Scanner(System.in);
        walec = new Walec();
        double nowyPromien;
        double nowaWysokosc;


        boolean dziala = true;
        while (dziala) {
            System.out.println("""
                    Wybierz opcję:
                    1. Wyświetl wartości walca.
                    2. Zmiana wartości walca.
                    3. Wyliczenie i wyświetlenie pól powierzchni oraz objetości walca.
                    4. Wyjście z programu.
                    """);
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1 -> System.out.println("Promień wynosi: " + walec.podajPromien() + ", a wysokość: " + walec.podajWysokosc() + "\n");
                case 2 -> {
                    System.out.println("Podaj nową wartość promienia walca: ");
                    nowyPromien = scanner.nextDouble();
                    walec.ustawPromien(nowyPromien);
                    System.out.println("Podaj nową wartość wysokości walca: \n");
                    nowaWysokosc = scanner.nextDouble();
                    walec.ustawWysokosc(nowaWysokosc);
                }
                case 3 -> System.out.println("Pole podstawy: " + walec.polePodstawy() + "\nPole boczne: " + walec.poleBoczne() + "\nPole calkowite: " + walec.poleCalkowite() + "\nObjetość: " + walec.objetosc() + "\n");
                case 4 -> dziala = false;
                default -> System.out.println("Prosze podac odpowiednia opcje.\n");
            }
        }
    }
}

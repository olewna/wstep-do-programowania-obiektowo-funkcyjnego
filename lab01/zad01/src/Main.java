import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean dziala = true;
        while (dziala) {
            Scanner opt = new Scanner((System.in));
            System.out.println("Podaj opcje: obliczanie silni (1), obliczanie 2^n (2), wyjscie (exit): ");
            String option = opt.nextLine();
            switch (option) {
                case "1" -> {
                    Scanner num = new Scanner((System.in));
                    System.out.println("Proszę podać liczbę, aby wyliczyć z niej silnie lub exit, aby wyjsc: ");
                    String input = num.nextLine();
                    if (input.equals("exit")) {
                        System.out.println("Koniec");
                        dziala = false;
                    } else {
                        int liczba = Integer.parseInt(input);

                        if (liczba < 0) {
                            System.out.println("Wartość jest mniejsza niż zero.");
                        } else {
                            long wynik = silnia(liczba);

                            System.out.println("Wartość silni z podanej liczby: " + wynik);
                        }
                    }
                }
                case "2" -> {
                    Scanner number = new Scanner(System.in);
                    System.out.println("Prosze podać potęge, do której chcesz podnieść liczbe 2 lub exit, aby wyjsc: ");
                    String input2 = number.nextLine();
                    if (input2.equals("exit")) {
                        System.out.println("Koniec");
                        dziala = false;
                    } else {
                        int liczba = Integer.parseInt(input2);

                        if (liczba < 0) {
                            System.out.println("Wartość jest mniejsza niż zero.");
                        } else {
                            long wynik = dwaDoN(liczba);

                            System.out.println("Wartość 2 do podanej potęgi: " + wynik);
                        }
                    }
                }
                case "exit" -> {
                    System.out.println("Koniec");
                    dziala = false;
                }
                default -> System.out.println("Zła opcja.");
            }


        }
    }

    public static long silnia(int n) {
        long wynik = 1;
        for (int i = 1; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }

    public static long dwaDoN(int n) {
        long wynik = 2;
        for (int i = 1; i <= n; i++){
            wynik *= 2;
        }
        return wynik;
    }
}
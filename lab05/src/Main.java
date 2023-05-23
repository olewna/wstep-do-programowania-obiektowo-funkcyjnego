import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Program zarządzający ocenami studentów.");
        Scanner scanner = new Scanner(System.in);
        GradeList grades = new GradeList();
        double newGrade;

        boolean run = true;
            while (run) {
            System.out.println("""
                        Wybierz opcję:
                        1. Dodaj ocenę.
                        2. Wyliczenie średniej.
                        3. Wypisanie największej oceny cząstkowej.
                        4. Wypisanie najniższej oceny cząstkowej.
                        5. Wyjście z programu.
                        """);
            int pick = scanner.nextInt();

            switch (pick) {
                case 1 -> {
                    System.out.println("Podaj ocenę: ");
                    newGrade = scanner.nextDouble();
                    if(newGrade>=2 && newGrade<=5 && newGrade%0.5==0) grades.addGrade(newGrade);
                    else System.out.println("Prosze podać prawidłową ocenę.");
                }
                case 2 -> {
                    if (grades.averageGrade()==-1) System.out.println("Brak ocen do wyliczenia średniej.");
                    else System.out.println("Średnia ocen: " + String.format("%.2f",grades.averageGrade()));
                }
                case 3 -> {
                    if ((grades.getBestGrade() != -1)) System.out.println("Najwyższa ocena: " + String.format("%.1f", grades.getBestGrade()));
                    else System.out.println("Brak ocen w bazie danych.");
                }
                case 4 -> {
                    if (grades.getWorstGrade()==-1) System.out.println("Brak ocen w bazie danych.");
                    else System.out.println("Najniższa ocena: " + String.format("%.1f",grades.getWorstGrade()));
                }
                case 5 -> run = false;
                default -> System.out.println("Prosze podac odpowiednia opcje.\n");
            }
        }
    }
}

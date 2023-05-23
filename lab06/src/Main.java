import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int pick;
    private static boolean run = true;
    private static int day;
    private static String priority;
    private static final String[] VALUES = {"niski", "sredni", "wysoki"};
    private static final String[] STATUS = {"planowane", "potwierdzone", "realizowane", "wykonane"};
    private static String desc;
    private static LocalTime start;
    private static LocalTime end;
    private static Kalendarz calendar;

    public static void main(String[] args) {
        System.out.println("Program obsługujący kalendarz.");
        calendar = new Kalendarz();
        while (run) {
            opt();
            switcher();
        }
    }

    public static void opt() {
        System.out.println("""
                Wybierz opcję:
                1. Dodanie spotkania na wybrany dzień.
                2. Dodanie zadania na wybrany dzień.
                3. Usunięcie spotkania.
                4. Usunięcie zadania.
                5. Wyswietl spotkania w dniu.
                6. Wyswietl zadania w dniu.
                7. Wyswietl spotkania z priorytetem.
                8. Wyswietl zadania ze statusem.
                9. Wyswietl spotkania z priorytetem i czasem.
                10. Wyswietl zadania ze statusem i czasem.
                11. Wyjście z programu.
                """);
        pick = SCANNER.nextInt();
    }

    public static void switcher() {
        switch (pick) {
            case 1 -> createMeeting();
            case 2 -> createTask();
            case 3 -> removeMeeting();
            case 4 -> removeTask();
            case 5 -> showAllMeetings();
            case 6 -> showAllTasks();
            case 7 -> showPrior();
            case 8 -> showStatus();
            case 9 -> showPriorityAndTime();
            case 10 -> showStatusAndTime();
            case 11 -> run = false;
            default -> System.out.println("Prosze podac odpowiednia opcje.\n");
        }
    }

    public static void createMeeting() {
        System.out.println("Opis spotkania: ");
        SCANNER.nextLine();
        desc = SCANNER.nextLine();

        System.out.println("Początek spotkania: (HH:MM)");
        String time = SCANNER.nextLine();
        if (Spotkanie.NAJWCZESNIEJ.isAfter(LocalTime.parse(time))) {
            System.out.println("Podano za wczesną godzine");
            return;
        }
        start = LocalTime.parse(time);

        System.out.println("Koniec spotkania: (HH:MM)");
        time = SCANNER.nextLine();
        end = LocalTime.parse(time);

        System.out.println("Priorytet: (niski,sredni,wysoki)");
        String temp = SCANNER.nextLine();
        if (!Arrays.asList(VALUES).contains(temp)) {
            System.out.println("Podano zły priorytet");
            return;
        }
        priority = temp;
        addMeeting();
    }

    public static void addMeeting() {
        System.out.println("Podaj dzień tygodnia: (1-7)");
        day = SCANNER.nextInt();
        if (day > 0 && day <= 7) {
            Spotkanie meeting = new Spotkanie(desc, start, end, priority);
            calendar.dodaj(meeting, day);
        } else System.out.println("Podano nieprawidłowy dzien");
    }

    public static void createTask() {
        System.out.println("Opis zadania: ");
        SCANNER.nextLine();
        desc = SCANNER.nextLine();

        System.out.println("Początek zadania: (HH:MM)");
        String time = SCANNER.nextLine();
        if (Zadanie.NAJWCZESNIEJ.isAfter(LocalTime.parse(time))) {
            System.out.println("Podano za wczesną godzine");
            return;
        }
        start = LocalTime.parse(time);

        System.out.println("Koniec zadania: (HH:MM)");
        time = SCANNER.nextLine();
        end = LocalTime.parse(time);

        System.out.println("Status: (planowane, potwiedzone, realizowane, wykonane)");
        String temp = SCANNER.nextLine();
        if (!Arrays.asList(STATUS).contains(temp)) {
            System.out.println("Podano zły status");
            return;
        }
        priority = temp;
        addTask();
    }

    public static void addTask() {
        System.out.println("Podaj dzień tygodnia: (1-7)");
        day = SCANNER.nextInt();
        if (day > 0 && day <= 7) {
            Zadanie task = new Zadanie(desc, start, end, priority);
            calendar.dodaj(task, day);
        } else System.out.println("Podano nieprawidłowy dzien");
    }

    public static void removeMeeting() {
        System.out.println("Podaj dzień oraz numer spotkania, które chcesz usunąć: ");
        day = SCANNER.nextInt();
        int id = SCANNER.nextInt();
        Predicate<Wydarzenie> p = x -> x instanceof Spotkanie;
        if (calendar.wyswietl(day, p).isEmpty()) {
            System.out.println("Podany dzień nie ma żadnych spotkań");
        } else if (calendar.wyswietl(day, p).size() < id) {
            System.out.println("Nie ma spotkania o podanym numerze");
        } else {
            calendar.usun(day, id, p);
        }
    }
    public static void removeTask(){
        System.out.println("Podaj dzień oraz numer zadania, które chcesz usunąć: ");
        day = SCANNER.nextInt();
        int id = SCANNER.nextInt();
        Predicate<Wydarzenie> p = x -> x instanceof Zadanie;
        if(calendar.wyswietl(day,p).isEmpty()){
            System.out.println("Podany dzień nie ma żadnych zadań");
        } else if(calendar.wyswietl(day,p).size() < id){
            System.out.println("Nie ma zadania o podanym numerze");
        } else{
            calendar.usun(day, id, p);
        }
    }
    public static void showAllMeetings(){
        Predicate<Wydarzenie> p = x -> x instanceof Spotkanie;
        if(!chooseDay(p)){
            return;
        }
        ArrayList<Wydarzenie> kal = calendar.wyswietl(day,p);
        for (Wydarzenie meet : kal) {
            System.out.println(meet.toString());
        }
    }
    public static void showAllTasks(){
        Predicate<Wydarzenie> p = x -> x instanceof Zadanie;
        if(!chooseDay(p)){
            return;
        }
        ArrayList<Wydarzenie> kal = calendar.wyswietl(day,p);
        for (Wydarzenie task : kal) {
            System.out.println(task.toString());
        }
    }
    public static void showPrior(){
        Predicate<Wydarzenie> p = x -> x instanceof Spotkanie;
        if(!chooseDay(p)){
            return;
        }
        System.out.println("Podaj priorytet, żeby wyświetlić wszystkie spotkania z podanym priorytetem.");
        SCANNER.nextLine();
        String pr = SCANNER.nextLine();
        if(!Arrays.asList(VALUES).contains(pr)){
            System.out.println("Podano zły priorytet");
            return;
        }

        Predicate<Wydarzenie> check = meet -> {
            if(meet instanceof Spotkanie) {
                Spotkanie meeting = (Spotkanie) meet;
                return meeting.getPriorytet().equals(pr);
            }
            return false;
        };
        printOrEmpty(check);
    }
    public static void showStatus(){
        Predicate<Wydarzenie> p = x -> x instanceof Zadanie;
        if(!chooseDay(p)){
            return;
        }
        System.out.println("Podaj status, żeby wyświetlić wszystkie zadania z podanym statusem.");
        SCANNER.nextLine();
        String pr = SCANNER.nextLine();
        if(!Arrays.asList(STATUS).contains(pr)){
            System.out.println("Podano zły status");
            return;
        }

        Predicate<Wydarzenie> check = meet -> {
            if(meet instanceof Zadanie) {
                Zadanie meeting = (Zadanie) meet;
                return meeting.getStatus().equals(pr);
            }
            return false;
        };
        printOrEmpty(check);
    }
//    public static void showFromTime(){
//        if(!chooseDay()){
//            return;
//        }
//        System.out.println("Podaj godzine, od której chcesz wyświetlić spotkania w formacie HH:MM.");
//        SCANNER.nextLine();
//        LocalTime czas = LocalTime.parse(SCANNER.nextLine());
//
//        Predicate<Spotkanie> check = meet -> meet.getStart().isAfter(czas) || meet.getStart().equals(czas);
//        printOrEmpty(check);
//    }
//    public static void showBetweenTime(){
//        if(!chooseDay()){
//            return;
//        }
//
//        SCANNER.nextLine();
//        System.out.println("Podaj godzine, od której chcesz wyświetlić spotkania w formacie HH:MM.");
//        LocalTime s = LocalTime.parse(SCANNER.nextLine());
//        System.out.println("Podaj godzine, do której chcesz wyświetlić spotkania w formacie HH:MM.");
//        LocalTime k = LocalTime.parse(SCANNER.nextLine());
//
//        Predicate<Spotkanie> check = meet -> (meet.getStart().isAfter(s) || meet.getStart().equals(s)) && (meet.getKoniec().isBefore(k) || meet.getKoniec().equals(k));
//        printOrEmpty(check);
//    }
    public static void showPriorityAndTime(){
        Predicate<Wydarzenie> p = x -> x instanceof Spotkanie;
        if(!chooseDay(p)){
            return;
        }

        System.out.println("Podaj priorytet, żeby wyświetlić wszystkie spotkania z podanym priorytetem.");
        SCANNER.nextLine();
        String pr = SCANNER.nextLine();
        if(!Arrays.asList(VALUES).contains(pr)){
            System.out.println("Podano zły priorytet");
            return;
        }

        System.out.println("Podaj godzine, od której chcesz wyświetlić spotkania w formacie HH:MM.");
        LocalTime czas = LocalTime.parse(SCANNER.nextLine());

        Predicate<Wydarzenie> check = meet -> {
            if(meet instanceof Spotkanie) {
                Spotkanie meeting = (Spotkanie) meet;
                return (meeting.getStart().isAfter(czas) || meeting.getStart().equals(czas)) && meeting.getPriorytet().equals(pr);
            }
            return false;

        };
        printOrEmpty(check);
    }
    public static void showStatusAndTime(){
        Predicate<Wydarzenie> p = x -> x instanceof Zadanie;
        if(!chooseDay(p)){
            return;
        }

        System.out.println("Podaj status, żeby wyświetlić wszystkie zadania z podanym statusem.");
        SCANNER.nextLine();
        String pr = SCANNER.nextLine();
        if(!Arrays.asList(STATUS).contains(pr)){
            System.out.println("Podano zły status");
            return;
        }

        System.out.println("Podaj godzine, do której chcesz wyświetlić zadania w formacie HH:MM.");
        LocalTime czas = LocalTime.parse(SCANNER.nextLine());

        Predicate<Wydarzenie> check = meet -> {
            if(meet instanceof Zadanie) {
                Zadanie meeting = (Zadanie) meet;
                return (meeting.getKoniec().isBefore(czas) || meeting.getKoniec().equals(czas)) && meeting.getStatus().equals(pr);
            }
            return false;
        };
        printOrEmpty(check);
    }
    public static boolean chooseDay(Predicate<Wydarzenie> p) {
        System.out.println("Podaj dzień, z którego chcesz wyświetlić spotkania: ");
        day = SCANNER.nextInt();
        if(day < 1 || day > 7) {
            System.out.println("Podano nieprawidłowy wartość");
            return false;
        } else if (calendar.wyswietl(day,p).size()==0){
            System.out.println("Brak spotkań w podanym dniu.");
            return false;
        }
        return true;
    }
    public static void printOrEmpty(Predicate<Wydarzenie> p) {
        ArrayList<Wydarzenie> kal = calendar.wyswietl(day,p);
        if(kal.isEmpty()){
            System.out.println("Brak spotkań lub zadań w podanym dniu.");
            return;
        }
        for (Wydarzenie spotkanie : kal) {
            System.out.println(spotkanie.toString());
        }
    }
}
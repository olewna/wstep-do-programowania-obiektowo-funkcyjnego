import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;
public class Kalendarz {
    private final ArrayList<Wydarzenie>[] kalendarz;
    public Kalendarz(){
        this(7);
    }
    public Kalendarz(int day){
        kalendarz = new ArrayList[day];
        for (int i = 0; i < day; i++) {
            kalendarz[i] = new ArrayList<>();
        }
        this.kalendarz[1].add(new Spotkanie("s1",LocalTime.parse("09:00:00"), LocalTime.parse("10:00:00"),"wysoki"));
        this.kalendarz[1].add(new Spotkanie("s2",LocalTime.parse("10:00:00"), LocalTime.parse("11:00:00"),"niski"));
        this.kalendarz[1].add(new Spotkanie("s3",LocalTime.parse("11:00:00"), LocalTime.parse("12:00:00"),"sredni"));
        this.kalendarz[1].add(new Spotkanie("s4",LocalTime.parse("12:00:00"), LocalTime.parse("13:00:00"),"wysoki"));
        this.kalendarz[1].add(new Zadanie("z1",LocalTime.parse("13:00:00"), LocalTime.parse("14:00:00"),"realizowane"));
        this.kalendarz[1].add(new Zadanie("z2",LocalTime.parse("14:00:00"), LocalTime.parse("15:00:00"),"planowane"));
        this.kalendarz[1].add(new Zadanie("z3",LocalTime.parse("15:00:00"), LocalTime.parse("16:00:00"),"potwierdzone"));
        this.kalendarz[1].add(new Zadanie("z3",LocalTime.parse("10:00:00"), LocalTime.parse("12:00:00"),"potwierdzone"));
    }
    public void dodaj(Spotkanie meet, int day){
        this.kalendarz[day-1].add(meet);
    }
    public void dodaj(Zadanie meet, int day){
        this.kalendarz[day-1].add(meet);
    }
    public void usun(int day, int meetNumber, Predicate<Wydarzenie> p ){
        ArrayList<Wydarzenie> cal = new ArrayList<>();
        for (Wydarzenie meet : this.kalendarz[day-1]) {
            if (p.test(meet)){
                cal.add(meet);
            }
        }
        Wydarzenie x = cal.get(meetNumber);
        int num = this.kalendarz[day-1].indexOf(x);
        this.kalendarz[day-1].remove(num);
    }
    public ArrayList<Wydarzenie> wyswietl(int day, Predicate<Wydarzenie> p) {
        ArrayList<Wydarzenie> calendar = new ArrayList<>();
        ArrayList<Wydarzenie> thisDay = kalendarz[day-1];
        for (Wydarzenie meet : thisDay) {
                if (p.test(meet)) {
                    calendar.add(meet);
            }
        }
//        ArrayList<Spotkanie> calendar = new ArrayList(kalendarz[day-1].stream().filter(p).collect(Collectors.toList()));
        return calendar;
    }
}

public class Main {
    public static void main(String[] args) {
        Walec myWalec = new Walec();
        Walec myWalec1 = new Walec(10,10);
        Walec myWalec2 = new Walec(20,30);
        myWalec.ustawPromien(5);
        myWalec.ustawWysokosc(5);
        System.out.println(myWalec.poleBoczne());
    }
}

public class Walec {
    private double promien;
    private double wysokosc;
    public void ustawPromien(double r) {
        this.promien = r;
    }
    public void ustawWysokosc(double h) {
        this.wysokosc = h;
    }
    public double podajPromien(){
        return promien;
    }
    public double podajWysokosc() {
        return wysokosc;
    }
    public Walec(double r, double h){
        promien = r;
        wysokosc = h;
    }
    public Walec(){
    }
    public double polePodstawy(){
        return Math.PI * Math.pow(promien,2);
    }
    public double poleBoczne(){
        return Math.PI * 2 * promien * wysokosc;
    }
    public double poleCalkowite() {
        return 2 * polePodstawy() * poleBoczne();
    }
    public double objetosc() {
        return polePodstawy() * wysokosc;
    }

}

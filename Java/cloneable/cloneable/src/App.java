public class App extends Araba{
    public static void main(String[] args) throws CloneNotSupportedException{
        System.out.println("Hello, World!");

        Araba araba1 = new Araba();
        Araba araba2 = (Araba)araba1.clone();
        System.out.println(araba1);
        System.out.println(araba2);
    }
}
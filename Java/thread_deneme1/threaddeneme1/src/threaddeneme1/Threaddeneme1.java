package threaddeneme1;

public class Threaddeneme1 {

    public static void main(String[] args) {
        Printer p1 = new Printer("Printer 1");
        Printer p2 = new Printer("Printer 2");
        
        p1.start();
        p2.start();
    }
    
}

package thread_deneme2;

public class Thread_deneme2 {
    public static void main(String[] args) {
        Thread printer1 = new Thread(new Printer("printer 1"));
        Thread printer2 = new Thread(new Printer("printer 2"));
        
        printer1.start();
        printer2.start();
        
    }
}

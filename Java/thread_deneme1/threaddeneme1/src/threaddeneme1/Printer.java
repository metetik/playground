package threaddeneme1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Printer extends Thread{
    private String isim;

    public Printer(String isim) {
        this.isim = isim;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(isim + " çalışıyor...");
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Thread kesintiye uğradı.");
            }
        }
    }
}

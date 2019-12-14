package thread_deneme4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_deneme4 {
    private int count = 0;
    
    synchronized void arttir(){
        count++;
    }
    
    public void threadleri_calistir(){
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    arttir();
                }
            }
        });
        
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    arttir();
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            System.out.println("Thread kesintiye uğradı.");
        }
        
        System.out.println("count : "+Integer.toString(count));
    }
    
    public static void main(String[] args) {
        Thread_deneme4 obje = new Thread_deneme4();
        
        obje.threadleri_calistir();
    }
    
}
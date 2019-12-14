package thread_deneme5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_deneme5 {

    public static void main(String[] args) {
        ListWorker worker = new ListWorker();
        
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                worker.degerAta();
            }
        });
        
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                worker.degerAta();
            }
        });
        
        long baslangic = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            System.out.println("Thread kesintiye uğradı");
        }
        
        long bitis = System.currentTimeMillis();
        
        System.out.println("list1 boyut : "+worker.list1.size()
                +"\nlist2 boyut : "+worker.list2.size()+"\nSüre : "+(bitis-baslangic));
    }
    
}

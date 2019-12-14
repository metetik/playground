package thread_deneme5;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListWorker {
    Random rand = new Random();
    
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    
    Object lock1 = new Object();
    Object lock2 = new Object();
    
    
    public void list1DegerEkle(){
        synchronized(lock1){
            try {
                Thread.sleep(1);
                list1.add(rand.nextInt(100));
            } catch (InterruptedException ex) {
                Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void list2DegerEkle(){
        synchronized(lock2){
            try {
                Thread.sleep(1);
                list2.add(rand.nextInt(100));
            } catch (InterruptedException ex) {
                Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void degerAta(){
        for (int i = 0; i < 1000; i++) {
            list1DegerEkle();
            list2DegerEkle();
        }
    }
}

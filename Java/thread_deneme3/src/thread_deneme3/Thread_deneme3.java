package thread_deneme3;

public class Thread_deneme3 {
    public static void main(String[] args) {
        Thread printer1 = new Thread(new Runnable(){
            String isim = "printer 1";
            
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
        });
        
        Thread printer2 = new Thread(new Runnable(){
            String isim = "printer 2";
            
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
        });
        
        /////////////////////////////////////////
        ////////BU ŞEKİLDE DE YAPILABİLİR\\\\\\\\
        //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        new Thread(new Runnable(){
            String isim = "printer 3";
            
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
        }).start();
        
        printer1.start();
        printer2.start();
    }
}

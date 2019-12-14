import java.util.Random;

class Main{
    int counter = 0;
    int buffer_size = 9;
    int[] buffer = new int[10];
    
    public static void main(String[] args) {
        Main m = new Main();

        for(int i = 0;i<10;i++){
            m.buffer[i] = -1;
        }

        new Thread(new Runnable(){
            @Override
            public void run() {
                Random random = new Random();

                while(true){
                    while(m.counter == m.buffer_size);//Eğer counter buffer size'a eşitse bekle
                    
                    int uretilen_sayi = random.nextInt(10);
        
                    m.buffer[++m.counter] = uretilen_sayi;
        
                    System.out.println("Üretildi : "+(m.counter)+", "+ (m.buffer[m.counter]));
                }
            }
        }).start();
        
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    while(m.counter == 0);//Eğer m.counter 0'a eşitse bekle
        
                    m.buffer[--m.counter] = -1;
        
                    System.out.println("Tüketildi : "+m.counter+","+m.buffer[m.counter]);
                }
            }
        }).start();
    }
}
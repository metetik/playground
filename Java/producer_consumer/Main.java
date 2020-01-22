//  ilkel çözüm deadlock oluyor..
//  1 : dolu , 2 : boş 

class Main{
    public static int counter = 0;
    public static int buffer_size = 9;
    public static int[] buffer = new int[10];
    
    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            buffer[i] = 0;
        }

        new Thread(new Runnable(){//uretici
            @Override
            public void run() {
                while(true){
                    while(counter == buffer_size);
                    
                    buffer[counter] = 1;
                    
                    counter++;
                    
                    System.out.println("Üretildi \n"
                                    +  "Counter : "+counter
                                    +  "\tBuffer : "+buffer[0]+buffer[1]+buffer[2]+buffer[3]+buffer[4]
                                    +   buffer[5]+buffer[6]+buffer[7]+buffer[8]+buffer[9]);
                }
            }
        }).start();
        
        new Thread(new Runnable(){//tüketici
            @Override
            public void run() {
                while(true){
                    while(counter == 0);
                    
                    buffer[counter] = 0;

                    counter--;

                    System.out.println("Tüketildi\n"
                                    +   "Counter : "+counter
                                    +  "\tBuffer : "+buffer[0]+buffer[1]+buffer[2]+buffer[3]+buffer[4]
                                    +   buffer[5]+buffer[6]+buffer[7]+buffer[8]+buffer[9]);
                }
            }
        }).start();
    }
}
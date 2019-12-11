package uretici_tuketici;

public class ThreadWashCar implements Runnable{
    Thread t;
    CarQueue carQ;
    
    public ThreadWashCar(CarQueue carQ){
        t = new Thread(this);
        this.carQ = carQ;
        t.start();
    }
            
    @Override
    public void run() {
        try{
            while(true)
                carQ.washCar();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

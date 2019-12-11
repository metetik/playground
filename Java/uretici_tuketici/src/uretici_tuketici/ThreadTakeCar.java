package uretici_tuketici;

import java.util.Random;

public class ThreadTakeCar implements Runnable{
    Thread t;
    CarQueue carQ;

    public ThreadTakeCar(CarQueue carQ) {
        this.carQ = carQ;
        t = new Thread(this);
        t.start();
    }
    
    public Car generate(){
        Random random = new Random();
        String name = null;
        String color = null;
        
        switch(random.nextInt(5)){
            case 0:
                name = "BMW";
                color = "Black";
                break;
            case 1:
                name = "Mercedes";
                color = "Red";
                break;
            case 2:
                name = "Opel";
                color = "Blue";
                break;
            case 3:
                name = "Peugeot";
                color = "White";
                break;
            default:
                name = "Ferrari";
                color = "Gray";
        }
        return new Car(name,color);
    }
    
    @Override
    public void run() {
        try{
            while(true){
                Car car = this.generate();
                carQ.takeCar(car);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

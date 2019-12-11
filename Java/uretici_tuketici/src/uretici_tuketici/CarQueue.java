package uretici_tuketici;

class CarQueue{
    private Car car;
    private boolean isWash;

    public CarQueue() {
        isWash = false;
    }

    synchronized void takeCar(Car car) throws InterruptedException{
        if(isWash)
            this.wait();
        
        this.car = car;
        isWash = true;
        System.out.println("Yeni araç geldi\tİsim : "+car.getName()
                +"\tRenk : "+car.getColor());
        this.notify();
    }
    synchronized Car washCar() throws InterruptedException{
        if(!isWash)
            this.wait();
        
        isWash = false;
        this.notify();
        System.out.println("Araç yıkandı.\tİsim : "+car.getName()
                +"\tRenk : "+car.getColor());
        return car;
    }
}
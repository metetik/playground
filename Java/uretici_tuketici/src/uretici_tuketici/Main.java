package uretici_tuketici;

class Main{
    public static void main(String[] args) {
        CarQueue carQ = new CarQueue();
        new ThreadTakeCar(carQ);
        new ThreadWashCar(carQ);
    }
}

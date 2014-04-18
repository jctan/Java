public class TestCar{

    public static final void main(String [] args){

        
        Car a = new Car(2013);
        Car b = new Car(2013, "Porsche");
        Car c = new Car(2013, "Porsche", "911 Carrera 4S");
        
        c.start();
        System.out.println("The car went " + c.milage() + " miles.");
        c.moveForward(6);
        System.out.println("The car went " + c.milage() + " miles.");
        c.moveBackward(2);
        System.out.println("The car went " + c.milage() + " miles.");
        c.moveForward(4);
        System.out.println("The car went " + c.milage() + " miles.");
        c.stop();
        System.out.println("The car went " + c.milage() + " miles.");
        
        System.out.println("The make of the car is: " + c.getMake());
        System.out.println("The model of the car is: " + c.getModel());
        System.out.println("The year of the car is: " + c.getYear());

    }

}

class Car{
    
    private String make;
    private String model;
    private int year;
    private int speed;
    private boolean isStarted;
    private boolean isStopped;
    private String statement;
    
    
    //constructor with year parameter
    public Car(int year){
        this.year = year;
    }
    
    //constructor with year and make parameter
    public Car(int year, String make){
        this.year = year;
        this.make = make;
    }
    
    //constructor with year, make, and model paramter
    public Car(int year, String make, String model){
        
        this.make = make;
        this.model = model;
        this.year = year;
        speed = 0;
        isStarted = false;
        isStopped = true;
        
    }
    
    
    public int getYear(){
        return year;
    }
    
    public String getMake(){
        return make;
    }
    
    public String getModel(){
        return model;
    }
    
    public void moveForward(int pushgas){
        
            speed += pushgas;

    }
    
    public void moveBackward(int pushgas){
        
            speed -= pushgas;

    }
    
    public void start(){
        
        if(isStarted == false){
            isStopped = false;
            isStarted = true;
            System.out.println("The car started");
        }
        else{
            System.out.println("you cannot start a car that is already started.");
        }
    }
    
    public void stop(){
        
        if(isStarted == true){
            isStarted = false;
            isStopped = true;
            System.out.println("The car stopped");
        }
        else{
            System.out.println("you cannot stop a car that is not started");
        }
      
    }
    
    public String statement(){
        if(isStarted){
            statement = "Started";
        }
        else if(isStopped){
            statement = "Stopped";
        }
        return statement;
    }
    
    public int milage(){
        
        return speed;
    }
    
}


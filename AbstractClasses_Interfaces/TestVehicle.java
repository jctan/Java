public class TestVehicle{
    
    public static final void main(String [] args){
        
        
        Car c = new Car(2013, "Porsche", "911 Carrera 4S");
        System.out.println("The car is: " + c.getMake() + " " + c.getModel() + " " + c.getYear());
        
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
        
        
        System.out.println();
        
        Boat b = new Boat(2013, "Sperry");
        System.out.println("The boat is: " + b.getMake() + " " + b.getYear());
        
        b.start();
        System.out.println("The boat went " + b.milage() + " miles.");
        b.moveForward(6);
        System.out.println("The boat went " + b.milage() + " miles.");
        b.moveForward(4);
        System.out.println("The boat went " + b.milage() + " miles.");
        b.stop();
        System.out.println("The boat went " + b.milage() + " miles.");
        
        System.out.println("The make of the boat is: " + b.getMake());
        System.out.println("The year of the boat is: " + b.getYear());

    }

}

abstract class Vehicle{

    
    public abstract void moveForward(int pushgas);
    
    public abstract void start();
        
    public abstract void stop();
        
    public abstract String statement();
    
    public abstract int getYear();
    public abstract String getMake();
    
}


class Car extends Vehicle{

    private String make;
    private String model;
    private int year;
    private int speed;
    private boolean isStarted;
    private boolean isStopped;
    private String statement;
    
    
    //function overloading
    
    public Car(int year){
        this.year = year;
        speed = 0;
        isStarted = false;
        isStopped = true;
    }

    public Car(int year, String make){
        this.year = year;
        this.make = make;
        speed = 0;
        isStarted = false;
        isStopped = true;
    }
    

    public Car(int year, String make, String model){
        this.year = year;
        this.make = make;
        this.model = model;
        speed = 0;
        isStarted = false;
        isStopped = true;
        
    }//
    
    //function overriding
    public int getYear(){
        return year;
    }
    
    //function overriding
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
    
    //function overriding

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
    
    //function overriding
    public void stop(){
            
        if(isStarted){
            isStarted = false;
            isStarted = true;
            System.out.println("The car stopped");
        }
        else{
            System.out.println("you cannot stop a car that is not started");
        }
    }
     
    
    //function overriding
    public String statement(){
        if(isStarted){
            statement = "Started";
        }
        else if(isStopped){
            statement = "Stopped";
        }
        return statement;
    }
    
     
    //function overriding
    public final int milage(){
        return speed;
    }
    
}

class Boat extends Vehicle{

    private String make;
    private int year;
    private int speed;
    private double nautical_mile;
    private final double mile_to_nautical_mile = 0.868976;
    private boolean isStarted;
    private boolean isStopped;
    private String statement;
    
    public Boat(int year, String make){
        this.make = make;
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
    

    public void moveForward(int pushgas){
        
        speed += pushgas;
    }
    
    
    
    public void start(){
        
        if(isStarted == false){
            isStopped = false;
            isStarted = true;
            System.out.println("The boat started");
        }
        else{
            System.out.println("you cannot start a boat that is already started.");
        }
    }


    public void stop(){
        
        if(isStarted){
            isStarted = false;
            isStopped = true;
            System.out.println("The boat stopped");
        }
        else{
            System.out.println("you cannot stop a boat that is not started");
        }
        
    }
     
    
    public String statement(){
        if(isStarted){
            statement = "Started";
        }
        else if(isStarted){
            statement = "Stopped";
        }
        return statement;
    }
    
    
     public final double milage(){
        nautical_mile = speed * mile_to_nautical_mile;
        return nautical_mile;
    }

}
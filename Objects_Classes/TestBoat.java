public class TestBoat{

    public static final void main(String [] args){

        Boat b = new Boat(2013, "Sperry");
        
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

class Boat{
    
    //instance variables
    private String make;
    private int year;
    private int speed;
    private double nautical_mile;
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
        
        if(isStarted == true){
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
        else if(isStopped){
            statement = "Stopped";
        }
        return statement;
    }
    
    public double milage(){
        nautical_mile = speed * 0.868976;
        return nautical_mile;
    }





}
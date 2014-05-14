public class TestBicycle{

    public static void main(String [] args){

        Bicycle hisBike = new Bicycle(30);
        System.out.println("His Bike");
        System.out.println("The Gear is : " + hisBike.getCadence() + "\n");
        
        Bicycle herBike = new Bicycle(30,0);
        System.out.println("Her Bike");
        System.out.println("The Cadence is: " + herBike.getCadence());
        System.out.println("The Speed is : " + herBike.getSpeed() + "\n");
        
        Bicycle myBike = new Bicycle(30,0,8);
        System.out.println("My Bike");
        System.out.println("The Cadence is: " + myBike.getCadence());
        System.out.println("The Speed is: " + myBike.getSpeed());
        System.out.println("The Gear is : " + myBike.getGear() + "\n");
        
        Bicycle baby = new babyBicycle();
        System.out.println("Baby Bicycle");
        System.out.println("Cadence of Baby Bicycle: " + baby.getCadence());
        System.out.println("Speed of Baby Bicycle: " + baby.getSpeed());
        System.out.println("Gear of Baby Bicycle: " + baby.getGear() + "\n");
        
        Bicycle baby2 = new babyBicycle(10,20,100);
        System.out.println("Baby Bicycle");
        System.out.println("Cadence of Baby Bicycle: " + baby2.getCadence());
        System.out.println("Speed of Baby Bicycle: " + baby2.getSpeed());
        System.out.println("Gear of Baby Bicycle: " + baby2.getGear());


    }
}

class Bicycle{
    
    private int gear;
    private int cadence;
    private int speed;
    
    
    public Bicycle(int cadence){
        this.cadence = cadence;
    }
    
    public Bicycle(int startCadence, int startSpeed){
        this(startCadence,startSpeed,0);
        
    }

    
    protected Bicycle(int startCadence, int startSpeed, int startGear){
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
    
    public int getGear(){
        return gear;
    }
    
    public int getCadence(){
        return cadence;
    }
    
    public int getSpeed(){
        return speed;
    }
}

class babyBicycle extends Bicycle{
    
    
    public babyBicycle(){
        super(11,22,33);
        
    }

    public babyBicycle(int startCadence, int startSpeed, int startGear){
        super(startCadence,startSpeed,startGear);
        
    }

}
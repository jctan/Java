public class Geometry{

    public static final void main(String args[]){

	
        Square s = new Square();
        s.setLength(6);
        s.setWidth(4);
        s.setHeight(5);
        s.setSides(4);
        System.out.println("The area of the Square is: " + s.area());
        System.out.println("The perimeter of the Square is: " + s.perimeter());
        System.out.println("The number of sides in the Square is: " + s.num_sides());
        System.out.println("The volume of the Square is: " + s.volume());
        
        System.out.println();
        
        Circle c = new Circle();
        c.setRadius(10);
        System.out.println("The area of the circle is: " + c.area());
        System.out.println("The circumference of the circle is: " + c.circumference());
        System.out.println("The radius of the circle is: " + c.radius());
        System.out.println("The diameter of the circle is: " + c.diameter());
        
        System.out.println();
        
        //instance variables can be shared without creating an object
        System.out.println("The PI: " + MathConstant.PI);
        System.out.println("The E: " + MathConstant.E);
        System.out.println("The NAUTICAL MILE: " + MathConstant.NAUTICAL_MILE);
        System.out.println("The GOLDEN RATIO: " + MathConstant.GOLDEN_RATIO);


    }


}// End Geometry class

//has functions required by regular polygons
interface PolygonsShape{
    
    public int area();
    public int perimeter();
    public int volume();
    public int num_sides();
    
}

//has functions required by Circles
interface CircleShape{
    
    public double area();
    public double volume();
    public double circumference();
    
}

//has all the geometry constants(PI, E)
interface MathConstant{
    
    public final double PI = 3.14159;
    public final double E = 2.718281828459;
    public final double NAUTICAL_MILE = 0.868976;
    public final double GOLDEN_RATIO = 1.61803398875;
}

class Square implements PolygonsShape{

    public int length = 0;
    public int width = 0;
    public int height = 0;
    public int sides = 0;
    
    public void setLength(int l){
        length = l;
    }

    public void setWidth(int w){
        width = w;
    }
    
    public void setHeight(int h){
        height = h;
    }
    
    public void setSides(int s){
        sides = s;
    }
    
    public int num_sides(){
        return sides;
    }
    
    public int volume(){
        return length * width * height;
    }

    public int area(){
        return length * width;
    }

    public int perimeter(){
        return (2 * length) + (2 * width);
    }

}

class Circle implements MathConstant, CircleShape{
    
    private int radius = 0;
    
    public void setRadius(int r){
        radius = r;
    }
    
    public int radius(){
        return radius;
    }
    
    public double area(){
        return PI * radius * radius;
    }
    
    public double diameter(){
        return radius * 2;
    }
    
    public double circumference(){
        return 2 * PI * radius;
        
    }
    
    public double volume(){
        return 4/3 * PI * (radius * radius * radius);
    }

}


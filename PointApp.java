import java.io.*;
import java.util.Scanner;
import java.util.*;


public class PointApp {

    public static void main(String[] args) throws IOException {

        File myfile = new File("points.txt");
        Scanner infile = new Scanner(myfile);

        Point p1 = Point.read(infile);
        while (p1 != null) {
            Point p2 = Point.read(infile);

            System.out.printf("p1: %s (quadrant %d) / p2: %s (quadrant %d)\n",
                    p1.toString(), p1.quadrant(),
                    p2.toString(), p2.quadrant());
            System.out.println("p1+p2: " + p1.add(p2) + " (quadrant " + p1.add(p2).quadrant() + ")"); 

            if (p1.xReflection().equals(p2)) {
                System.out.println("p1 and p2 are reflections across the x-axis");
            }
            if (p1.yReflection().equals(p2)) {
                System.out.println("p1 and p2 are reflections across the y-axis");
            }
             if (p1.originReflection().equals(p2)) {
                System.out.println("p1 and p2 are reflections through the origin");
            }
                if (p1.distance(new Point()) == p2.distance(new Point())) {
                System.out.println("p1 and p2 are equidistant from the origin");
            }
           
    
           System.out.println("The distance between " + p1.toString() + " and "+
                             p2.toString() + " is " + p1.distance(p2)); 

     
          
            
            System.out.println();

            p1 = Point.read(infile);
        }
    }
}



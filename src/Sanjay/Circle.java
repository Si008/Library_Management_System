package Sanjay;
import java.awt.*;


public class Circle {
    Point center ;
    double radius;
    Circle(){}
    Circle(Point center , double radius){
        this.center = center;
        this.radius = radius;
    }
     double getPerimeter(){
        return 2 * Math.PI * radius;
     }
    double getArea(){
        return Math.PI * radius * radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
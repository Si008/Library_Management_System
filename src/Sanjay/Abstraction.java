package Sanjay;


abstract class Mother{
    abstract void cry();
    abstract void eat();
}
class Child extends Mother{
    void cry(){
        System.out.println("Child is crying.");
    }
    void eat(){
        System.out.println("Child is eating.");
    }
}


public class Abstraction {
    public static void main(String[] args){
        Mother m = new Child();
        m.cry();
        m.eat();
    }
}

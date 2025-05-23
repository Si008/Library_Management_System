package Sanjay;

public class SINGLE {
     private static SINGLE instance;
     private SINGLE(){

    }
    public static SINGLE getInstance(){
         if(instance == null){
             instance = new SINGLE();
         }
         return instance;
    }
    public int num()
    {
        return 34;
    }



}
class Main{
    public static void main(String[] args){
        SINGLE s = SINGLE.getInstance();
        SINGLE s1 = SINGLE.getInstance();

        System.out.println(s );
        System.out.println(s1);
        System.out.println(s1.num());
    }
}

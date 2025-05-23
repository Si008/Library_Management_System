package Sanjay;

class  Singleton{
    private static Singleton obj;

    private Singleton(){

    }
    public static Singleton getObj(){
        if(obj == null){
            obj = new Singleton();
        }
        return obj;
    }
}
class SingletonDes{
    public static void main(String[] args){
        Singleton obj = Singleton.getObj();
        Singleton obj2 = Singleton.getObj();
        System.out.println(obj );
        System.out.println(obj2 );
    }
}
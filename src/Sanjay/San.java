package Sanjay;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//class San{
//    public static void main(String[] args){
//       ArrayList<Account> accounts = new ArrayList<>();
//       Client client = new Client(1,"Sanjay", "6374413628");
//        accounts.add(new Account(1,1000,1.5,client));
//        accounts.add(new Account(2,2000,2.5,client));
//        accounts.get(0).withdraw(200);
//        accounts.get(0).withdraw(100);
//        accounts.get(0).deposit(2000);
//
//        accounts.get(1).withdraw(2000);
//        accounts.get(1).deposit(200);
//        accounts.get(1).withdraw(20);
//
//        for(Account account : accounts){
//            System.out.println("Account : " + account.getId() );
//            System.out.println("W : " + account.countTransactions('W') );
//            System.out.println("D : " + account.countTransactions('D') );
//        }
//        System.out.println(" " + accounts.get(0).toString());
//
//
//
//
//    }
//}

//import java.awt.*;                        ----/ PRODUCT AND ADMIN VALIDATION OF PRICE
//import java.util.Scanner;
//
//class Product{
//    Scanner s = new Scanner(System.in);
//    String desc;
//    private double price;
//    String quality;
//    Product(String desc , double price, String quality){
//        this.desc = desc;
//        this.price = price;
//        this.quality = quality;
//    }
//    public double getPrice(){
//        return price;
//    }
//    public void setPrice(double price , Admin admin ){
//
//        System.out.println("Enter name : ");
//        String name = s.nextLine();
//        System.out.println("Enter password :");
//        String pass = s.nextLine();
//
//
//        if(admin.username.equals(name ) && admin.pass.equals(pass)){
//            this.price = price;
//            System.out.println("Price updated to : " + price );
//        }
//        else {
//            System.out.println("Enter valid username and password");
//        }
//    }
//}
//class Admin {
//    String username;
//    String pass;
//    Admin(){
//
//    }
//    Admin(String username , String pass){
//        this.username = username;
//        this.pass = pass;
//    }
//
//}
//class San{
//        public static void main(String[] args){
//                    Admin a = new Admin("Selvaraj","Sanjayselva54@");
//                    Product p = new Product("Used to drink",1050,"Nice");
//                    System.out.println(p.getPrice());
//                    p.setPrice(1100.50,a);
//
//        }
//}                         ---- //END OF PROGRAM


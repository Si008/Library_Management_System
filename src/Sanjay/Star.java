package Sanjay;

import java.util.Scanner;

public class Star {
    public static void main(String args[]){
        Scanner inp = new Scanner (System.in);
        int  n = inp.nextInt();
        for(int i = n ; i>= 1 ; i--){
            for(int j = 1 ; j<=n ; j++ ){
                if(j>=i)
                 System.out.print("* ");
                else
                    System.out.print(" ");
            }

            System.out.println(" ");
        }
      //  for(int i = n ; i>=1 ; i--){
         //   for(int j = n ; j>=1 ; j-- ){
           //     if(j<i){
             //       System.out.print("* ");
               // }
              //  else{
                //    System.out.print(" ");
               // }

           // }
            System.out.println(" ");

       // }

    }
}

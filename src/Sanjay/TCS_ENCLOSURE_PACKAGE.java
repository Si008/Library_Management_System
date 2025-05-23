package Sanjay;

import java.util.Scanner;

public class TCS_ENCLOSURE_PACKAGE {


        public static void main(String[] args){

            Scanner inp = new Scanner(System.in);
            System.out.println("Enter a String :");
            String s = inp.nextLine();
            int sum = count(s);

            System.out.println("The number of enclosure is:" + sum);

        }
        public static int count(String s){
            int w = 0;
            for(int i = 0; i< s.length(); i++) {

                char c = s.charAt(i);
                if(c == 'B' ){
                    w+=2;}
                else if(c =='D' ){
                    w+=1;}
                else if(c =='O'){
                    w+=1;}
                else if(c =='P'){
                    w+=1;}
                else if(c =='Q'){
                    w+=1;}
                else if(c =='R'){
                    w+=1;}
                else
                    w += 0;

            }
            return w;

        }
    }



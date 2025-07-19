package Librarymanagementsystem;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class User {

        protected  String name;
        protected  String dept;
        protected  String ph_no;


        User(String name, String dept, String ph_no) {
            this.name = name;
            this.dept = dept;
            this.ph_no = ph_no;

        }

        public  void displayUser() {
            System.out.println("Name: " + name);
            System.out.println("Dept: " + dept);
            System.out.println("Phone: " + ph_no);
            String type;
            if(this instanceof Student){
                type = "student";
            }
            else if(this instanceof Teacher){
                type = "teacher";
            }
            else
                type = "unknown type user";

            System.out.println("Type:" + type);

        }

        public int getMaxBooksAllowed() {
            return 0; // To be overridden
        }


        }








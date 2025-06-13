package Librarymanagementsystem;



import java.awt.print.Book;
import java.util.Date;
import java.util.*;
import java.sql.*;


class Main {
    public static void main(String[] args) throws ClassCastException {
       BooksDAO booksDAO = new BooksDAO();
        booksDAO.getBookDetails("Think");




    }
}









//___________________________________
//        Book b1 = new Book("The Psychology of Money", "Finance", "JS10034");
//        Book b2 = new Book("The Power of Your Subconscious Mind", "Psychology", "PS123");
//        Book b3 = new Book("Think and Grow Rich", "Life", "GH567");
//        Book b4 = new Book("Atomic Habits", "Habits", "AT324");
//        Book b5 = new Book("A", "Habits", "AT328");

//        Library lib = new Library();

//        lib.addBook(b1);
//        lib.addBook(b2);
//        lib.addBook(b3);
//        lib.addBook(b4);
//        lib.addBook(b5);
//
//        users.add(new Student("Sanjay", "CSE", "6374413628", "21258"));
//        users.add(new Student("Panner", "CSE", "8925173074", "21260"));
//        users.add(new Teacher("Vanitha Shebha", "CSE", "9840938563", "54421"));
//
//        // Issue books to test validation
//        lib.issueBook(users.get(0), b1); // Sanjay gets 1st book
//        lib.issueBook(users.get(0), b2); // Sanjay gets 2nd book
//        lib.issueBook(users.get(0), b3); // Exceeds limit (should fail)
//
//        System.out.println("_______________________");
//
//        lib.issueBook(users.get(2), b3); // Teacher borrows 1 book
//
//        System.out.println("_______________________");
//        lib.returnBook(b3,users.get(2));
//        lib.issueBook(users.get(0),b3);


//        System.out.println(users.get(0).borrowedBooks.toString());




//    }
//}

// Issue is there " We can borrow books using user class it makes exception in limit we should make borrow book  to be  access only  by using Library class issue book method "

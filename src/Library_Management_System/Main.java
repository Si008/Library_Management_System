package Library_Management_System;


import java.util.*;

// Book class
class Book {
    String title;
    String genre;
    String bookid;
    Date dateIssued;
    boolean isIssued;

    Book(String title, String genre, String bookid) {
        this.title = title;
        this.genre = genre;
        this.bookid = bookid;
        this.dateIssued = null;
        this.isIssued = false;
    }
    public String toString(){
        return "[" + title + "|" + genre + "|" + dateIssued +"|" + bookid+ "]";

    }
}

// User base class
class User {
    protected  String name;
    protected  String dept;
    protected  String ph_no;
    protected  List<Book> borrowedBooks = new ArrayList<>();

    User(String name, String dept, String ph_no) {
        this.name = name;
        this.dept = dept;
        this.ph_no = ph_no;
    }

    public  void displayUser() {
        System.out.println("Name: " + name);
        System.out.println("Dept: " + dept);
        System.out.println("Phone: " + ph_no);
    }

    public int getMaxBooksAllowed() {
        return 0; // To be overridden
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed: " + book.title + " on " + new Date());
    }

}

// Student class
class Student extends User {
    String stdid;

    Student(String name, String dept, String ph_no, String stdid) {
        super(name, dept, ph_no);
        this.stdid = stdid;
    }

    @Override
    public int getMaxBooksAllowed() {
        return 2;
    }
}

// Teacher class
class Teacher extends User {
    String teaid;

    Teacher(String name, String dept, String ph_no, String teaid) {
        super(name, dept, ph_no);
        this.teaid = teaid;
    }

    @Override
    public int getMaxBooksAllowed() {
        return 5;
    }
}

// Library class
class Library {
    private List<Book> books = new ArrayList<>();

//    Library(Book b) {
//        books.add(b);
//    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isIssued) {
                System.out.println(book.title + " | " + book.genre);
            }
        }
    }

    public void issueBook(User user, Book b) {
        for (Book book : books) {
            if (book.bookid.equals(b.bookid)) {
                if (book.isIssued) {
                    System.out.println("Book '" + book.title + "' is already issued.");
                    return;
                }
                if (user.borrowedBooks.size() >= user.getMaxBooksAllowed()) {
                    System.out.println(user.name + " has reached the borrow limit (" + user.getMaxBooksAllowed() + ").");
                    return;
                }
                // Issue the book
                book.isIssued = true;
                book.dateIssued = new Date();
                user.borrowBook(book);
                System.out.println("Issued on: " + book.dateIssued);
                return;
            }
        }
        System.out.println("Book not found in library.");
    }
    public void returnBook(Book b , User user){
        if(user.borrowedBooks.contains(b)){
            addBook(b);
            System.out.println(user.name + " returned " + b.title + " on " + new Date());
            b.isIssued = false;
            user.borrowedBooks.remove(b);
        }
        else
            System.out.println("The user didn't issued that book");
    }
}

class Main{
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        Book b1 = new Book("The Psychology of Money", "Finance", "JS10034");
        Book b2 = new Book("The Power of Your Subconscious Mind", "Psychology", "PS123");
        Book b3 = new Book("Think and Grow Rich", "Life", "GH567");

        Library lib = new Library();

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        users.add(new Student("Sanjay", "CSE", "6374413628", "21258"));
        users.add(new Student("Panner", "CSE", "8925173074", "21260"));
        users.add(new Teacher("Vanitha Shebha", "CSE", "9840938563", "54421"));

        // Issue books to test validation
        lib.issueBook(users.get(0), b1); // Sanjay gets 1st book
        lib.issueBook(users.get(0), b2); // Sanjay gets 2nd book
        lib.issueBook(users.get(0), b3); // Exceeds limit (should fail)

        System.out.println("_______________________");

        lib.issueBook(users.get(2), b3); // Teacher borrows 1 book

        System.out.println("_______________________");
        lib.returnBook(b3,users.get(2));
        lib.issueBook(users.get(0),b3);


        System.out.println(users.get(0).borrowedBooks.toString());




    }
}

// Issue is there " We can borrow books using user class it makes exception in limit we should make borrow book  to be  access only  by using Library class issue book method "

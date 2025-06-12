package Librarymanagementsystem;


import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

// Library class
public class Library {
    private List<Books> books = new ArrayList<>();
    Scanner inp = new Scanner(System.in);

//    Library(Book b) {
//        books.add(b);
//    }

    public void addBook() {
        String sql = "INSERT into books (Book_id,Title,Genre,Bookcreated,Isissued) values (?,?,?,?,?)";
        Date date = new Date();
        boolean isIssued = false ;

        try{
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("Enter the book id ");
            ps.setString(1,inp.next());
            inp.nextLine();
            System.out.println("Enter the  title ");
            String Title = inp.nextLine();
            ps.setString(2,Title);

            System.out.println("Enter the Genre ");
            ps.setString(3,inp.nextLine());


//            java.sql.Date sqldate = new java.sql.Date(b.bookcreated.getTime());

            java.sql.Date sqldate  =  new java.sql.Date(date.getTime());
            ps.setDate(4,sqldate);
            ps.setBoolean(5,isIssued);

            ps.executeUpdate();

            System.out.println("Book added to database " + Title  );
        } catch ( SQLException e) {
            e.printStackTrace();

        }
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        String query = "Select Title from books where Isissued = false";
        try{
            Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("Title"));
            }

        }
        catch ( SQLException e){
            e.printStackTrace();
        }

//        for (Books book : books) {
//            if (!book.isIssued) {
//                System.out.println(book.title + " | " + book.genre);
//            }
//        }
    }

    public void issueBook(User user, Books b) {
        for (Books book : books) {
            if (book.bookid.equals(b.bookid)) {
                if (book.isIssued) {
                    System.out.println(" Book " + book.title + " is already issued.");
                    return;
                }
                if (user.borrowedBooks.size() >= user.getMaxBooksAllowed()) {
                    System.out.println(user.name + " has reached the borrow limit (" + user.getMaxBooksAllowed() + ").");
                    return;
                }
                // Issue the book
                book.isIssued = true;
//                book.dateIssued = new Date();
                user.borrowBook(book);
                System.out.println("Issued on: " + book.dateIssued);
                return;
            }
        }
        System.out.println("Book not found in library.");
    }
    public void returnBook(Books b , User user){
        if(user.borrowedBooks.contains(b)){
//            addBook(b);
//            System.out.println(user.name + " returned " + b.title + " on " + new Date());
            b.isIssued = false;
            user.borrowedBooks.remove(b);
        }
        else
            System.out.println("The user didn't issued that book");
    }
}


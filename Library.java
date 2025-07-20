package Librarymanagementsystem;



import java.sql.*;
import java.util.Scanner;
import java.util.Date;

// Library class (BooksDAO)
public class Library {

    UserDAO userdao = null;
    Library lib = null;
    Scanner inp = new Scanner(System.in);



        public Books getBookDetails(String bookId )  {
            String query = "Select * from books where Book_id = ? " ;

            Books book = null;

            try {
                Connection conn = DBconnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, bookId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()){
                    book = new Books(rs.getString("Book_id"),rs.getString("Title"),rs.getString("Genre"));
                    book.bookcreated = rs.getTimestamp("Bookcreated");
                    book.isIssued = rs.getBoolean("Isissued");
                }
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return book ;
        }



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

    }

    // Constraints cant be used for duplicate users.

    public void issueBook( String name , String bookId) {
            lib = new Library();
            userdao = new UserDAO();
        User user = userdao.getUser(name);
        Books book = lib.getBookDetails(bookId);

        if(user == null || book == null ) {
            System.out.println("User or Book is not found");
            return;
        }

        if(book.isIssued) {
            System.out.println("Book " + book.title + " is already issued ");
            return;
        }

        String userid = (user instanceof  Student)? ((Student)user).stdid : ((user instanceof Teacher)? ((Teacher)user).teaid : "Unknown");


        if(user.getMaxBooksAllowed() <= userdao.getCountOfUserBorrowedBooks(userid) ){
            System.out.println("User :"+ user.name + " has reached the borrow limits");
            return ;
        }

        try(Connection conn = DBconnection.getConnection()){

            String sql1 = "Update books set Isissued = ? where Book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setBoolean(1,true);
            ps.setString(2,book.bookid);
             ps.executeUpdate();

             String sql2 ="Insert into borrowed_books(user_id,book_id,date_issued) values (?,?,?)";
             PreparedStatement ps1 = conn.prepareStatement(sql2);
             ps1.setString(1,userid);
             ps1.setString(2,book.bookid);
             java.sql.Date  date =  new java.sql.Date( new java.util.Date().getTime());
             ps1.setDate(3,date);
             int rows = ps1.executeUpdate();
            System.out.println("Rows updated : " + rows);

            System.out.println("Book :" + book.title + " is borrowed to User :" + user.name );
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void returnBook(String userId , String bookId){
        String query1 = "Delete from Borrowed_books  where user_Id = ?  and book_id = ?" ;
        String query2 = "update books set isIssued = ? where Book_id = ?";

        try (Connection conn = DBconnection.getConnection()) {

            try {
                PreparedStatement ps = conn.prepareStatement(query1);
                ps.setString(1,userId);
                ps.setString(2,bookId);
                ps.executeUpdate();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            try {
                PreparedStatement ps = conn.prepareStatement(query2);
                ps.setBoolean(1, false);
                ps.setString(2,bookId);

                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("The book " + "bookId" + "is returned to library by " + userId);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


































































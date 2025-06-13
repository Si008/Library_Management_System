package Librarymanagementsystem;


import java.sql.*;

public class BooksDAO {
    public void getBookDetails(String name )  {
        String query = "Select * from books where Title = ? " ;

        Books book = null;

        Connection conn = DBconnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
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

        System.out.println( "Book title : " + book.title + "\n"
                             + "Book id : " + book.bookid +" \n"
                             + "Book Genre :" + book.genre + "\n"
                             + "Book created :" + book.bookcreated + "\n"
                             + "Book isIssued :" +book.isIssued);
    }


}

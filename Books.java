package Librarymanagementsystem;

import java.util.Date;

public class Books {

        String bookid;
        String title;
        String genre;
        Date dateIssued;
        Date bookcreated;
        boolean isIssued;



        Books(String bookid, String title, String genre ) {
            this.title = title;
            this.genre = genre;
            this.bookid = bookid;
            this.bookcreated= new Date();
            this.isIssued = false;
        }



    }


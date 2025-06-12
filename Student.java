package Librarymanagementsystem;

public class Student extends Librarymanagementsystem.User {
    // Student class

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


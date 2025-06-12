package Librarymanagementsystem;

// Teacher class
public class Teacher extends Librarymanagementsystem.User {
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

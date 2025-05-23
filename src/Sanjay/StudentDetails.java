package Sanjay;

class StudentDetails {
     String name;
     int age;
     int rollno ;

    StudentDetails(){

    }
    StudentDetails(String name, int age , int rollno){
        this.name =name;
        this.age =age;
        this.rollno =rollno;
    }

//    public String getName(){
//        return name;
//    }
//    public int getAge(){
//        return age;
//    }


//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setAge(int age){
//        this.age = age;
//    }
    public void displayDetails(){
        System.out.println("Name :" + name);
        System.out.println("age :" + age);
        System.out.println("rollno :" + rollno);
    }
}

public class Main {
//any method executions happens in stack
    public static void main(String[] args) {
        System.out.println("*****************************Student Management System*****************************");
        System.out.println("***********************Welcome************************");

        /*(whenever we created an object, class is loaded into memory, instance variables are created in heap memory,
        constructors will be called)*/

        Student s1=new Student("Priya",24,"S-101");
        s1.enrollCourse("Java");
        s1.enrollCourse("Physics");
        s1.enrollCourse("DSA");
        s1.printStudentInfo();

        Student s2=new Student("Abhi",31,"S-102");

        s2.enrollCourse("Devops");
        s2.printStudentInfo();

        Student s3=new Student("Priyanka",32,"S-103");
        s3.enrollCourse("Devops");
        s3.printStudentInfo();


    }
}

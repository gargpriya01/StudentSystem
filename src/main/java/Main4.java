import java.sql.SQLOutput;
import java.util.*;

public class Main4 {
//any method executions happens in stack

    private static List<Student> studentList;
    private static Scanner scanner;

    public static void main(String[] args) {

        System.out.println("*****************************Student Management System*****************************");
        System.out.println("***********************Welcome************************");

        /*(whenever we created an object, class is loaded into memory, instance variables are created in heap memory,
        constructors will be called)*/

        studentList = new ArrayList<Student>();

        scanner = new Scanner(System.in);
        while(true){
            System.out.println("--------------Welcome----------------");
        System.out.println("Select an Option.......");
        System.out.println("1. Register a Student");
        System.out.println("2. Find a student with studentId");
        System.out.println("3. List all Student information");
        System.out.println("4. List Student Information in sorted order");
        System.out.println("5. Exit");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                enrollStudent(scanner);
                break;
            case 2:
                findStudentById(scanner);
                break;
            case 3:
                printAllStudentData();
                break;
            case 4:
                sortByName();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Invalid option selected. Please try again.");


        }}}

    private static void printAllStudentData() {
        if(studentList.size()>0) {
            System.out.println("============Print all student data======================");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
            System.out.println("--------------*****************************-----------------------");
        }
        else{
            System.out.println("No students found. Please enroll students first.");
        }
    }


    private static void findStudentById(Scanner scanner){

        Student studentFound = null;
        System.out.println("Enter the student id to be searched");
        String studentId=scanner.next();
        try {
            studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst().orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        } catch (RuntimeException e) {
            System.err.println("Student not found with id: " + studentId);
        }
studentFound.printStudentInfo();
        }

        private static void enrollStudent (Scanner scanner){
            System.out.println("Enter the student name");
            String studentName=scanner.next();

            System.out.println("Enter the student age");
            int studentAge=scanner.nextInt();

            System.out.println("Enter the student id");
            String studentId=scanner.next();

            Student newStudent= new Student(studentName, studentAge, studentId);
            studentList.add(newStudent);
            while(true) {
                System.out.println("Enter the course to be enrolled...!!Type Done to exit");
                String courseName = scanner.next();
                if(courseName.equalsIgnoreCase("done")){
                    break;
                }
                newStudent.enrollCourse(courseName);
            }

    newStudent.printStudentInfo();

        }



    private static void exit() {
        System.exit(0);
    }

        private static void sortByName () {

            Comparator<Student> studentNameComparator = (s1, s2) -> s1.getName().compareTo(s2.getName());

        /*Comparator<Student> studentNameComparator=new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };*/
            Collections.sort(studentList, studentNameComparator);
            System.out.println(studentList);
        }

        public static Student findStudentById (String studentId){
            Student result = null;
            try {
                result = studentList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                        .findFirst().orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
                return result;
            } catch (RuntimeException e) {
                System.err.println("Student not found with id: " + studentId);
            }
            return result;

        }



    }




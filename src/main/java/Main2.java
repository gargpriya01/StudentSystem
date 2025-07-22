import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
//any method executions happens in stack

    private static List<Student> studentList;
    public static void main(String[] args) {

        System.out.println("*****************************Student Management System*****************************");
        System.out.println("***********************Welcome************************");

        /*(whenever we created an object, class is loaded into memory, instance variables are created in heap memory,
        constructors will be called)*/

        studentList = new ArrayList<Student>();


        Student s1 = new Student("Priya", 24, "S-101");
        s1.enrollCourse("Java");
        //s1.enrollCourse("Physics");
        s1.enrollCourse("DSA");


        Student s2 = new Student("Abhi", 31, "S-102");

        s2.enrollCourse("Devops");


        Student s3 = new Student("Priyanka", 32, "S-103");
        s3.enrollCourse("Devops");

        Student s4 = new Student("Tarun", 35, "S-104");
        s4.enrollCourse("Java");


        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        Student result=findStudentById("S-102");
        System.out.println("Result"+result);
        sortByName();
    }

    private static void sortByName(){

        Comparator<Student> studentNameComparator= (s1,s2)->s1.getName().compareTo(s2.getName());

        /*Comparator<Student> studentNameComparator=new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };*/
        Collections.sort(studentList, studentNameComparator);
        System.out.println(studentList);
    }

        public static Student findStudentById(String studentId){
        Student result=null;
        try {
            result = studentList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst().orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
            return result;
        }
        catch (RuntimeException e){
            System.err.println("Student not found with id: " + studentId);
        }
        return result;

            }

        }







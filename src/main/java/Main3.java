import java.util.*;

public class Main3 {
//any method executions happens in stack

    private static List<Student> studentList;
    public static void main(String[] args) {

        System.out.println("*****************************Student Management System*****************************");
        System.out.println("***********************Welcome************************");

        /*(whenever we created an object, class is loaded into memory, instance variables are created in heap memory,
        constructors will be called)*/

        studentList = new ArrayList<Student>();
        //read input from terminal
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name=scanner.next(); //if you want to read input in string format you will use next() method
        System.out.println("You have entered the name:"+name);

        //to read integer values from the console/terminal
        //the readInt();
        System.out.println("Enter Student Age: ");
        int age=scanner.nextInt();  //if you want to read input in int format you will use nextInt() method
        System.out.println("The Student age is:"+age);





    }

    private static void sortByName(){

        Comparator<Student> studentNameComparator= (s1,s2)->s1.getName().compareTo(s2.getName());

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







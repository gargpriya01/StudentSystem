import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    //instance variables are always private , stored in heap memory, always initialised with default values
    //you must add validation checks for instance variables
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    private String studentId;
    private List<String> courses;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }



   public Student(String name,int age,String studentId) {
       super(); //is used to call the parent class constructor. its calling constructor of Object class
       if(validateAge(age) && validateName(name) && validateStudentId(studentId)) {
           this.age = age;
       this.name = name;
       this.age = age;
       this.studentId = studentId;
       courses = new ArrayList<String>();  //initialization of courses !!
   }}

    public void enrollCourse(String course){
       if(validateCourse(course)){
       if(!courses.contains(course)){
           courses.add(course);
           System.out.println("Student is enrolled to "+course+" successfully");
       }
       else{
           System.out.println("Student is already enrolled to "+course);
       }}}

       public void printStudentInfo(){
           System.out.println("==================Student Information=================");
           System.out.println("Student's name is "+name);
           System.out.println("Student's age is "+age);
           System.out.println("Student's studentId is "+studentId);
           System.out.println("Enrolled for "+ courses);
       }

       //Validation methods
    public boolean validateAge(int age){
       if(age>=19 && age<=35){
           return true;
       } else {
           System.err.println("Invalid age. Age should be between 19 and 35.");
           return false;
       }
    }

    public boolean validateName(String name){
       String nameRegex="^[a-zA-Z\\s]+$"; //regex pattern for name validation
        Pattern namePattern=Pattern.compile(nameRegex);
        Matcher nameMatcher=namePattern.matcher(name);
       if(nameMatcher.matches()){
           return true;
       } else {
           System.err.println("Invalid name. Please enter alphabets only ");
           return false;
       }}

        public boolean validateStudentId(String studentId) {
            String idRegex = "S-\\d+$"; //regex pattern for name validation
            Pattern idPattern = Pattern.compile(idRegex);
            Matcher idMatcher = idPattern.matcher(studentId);
            if (idMatcher.matches()) {
                return true;
            } else {
                System.err.println("Invalid student id. Use format S-132");
                return false;
            }
        }

        public boolean validateCourse(String course) {

            if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops")) {
                return true;
            } else {
                System.err.println("Invalid course name!! Please select courses from the list: Java, DSA, Devops");
                return false;
            }
        }


    }

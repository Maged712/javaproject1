import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Course implements StudentManagement{
    Course a = new Course("m", 2 ,"22");
    public Admin(String course, String studentName, int id, String passWord) {
        super(course, studentName, id, passWord);
    }
    @Override
    public void getGrades() {
        ArrayList<String> oldVersion = new ArrayList<>();
        oldVersion.add("Old Chemistry");
        oldVersion.add("Old Physics");
        oldVersion.add("Old Programming");
        setOldCourses(oldVersion);
//        for( String str : oldVersion){
//            JOptionPane.showMessageDialog(null ,
//                      count + str + " Grade is 90 "   );
//            count++;
//        }
            String str="";
            String answer="All Grades  \n";
            int count=0;
            int c = 50;
            for (String counter : oldVersion) {
                str=" "+ "Course "+count+": "+oldVersion.get(count)+ "Grade is "+c+
                        "\n";
                answer+=str;
                count++;
                c = c +20;
            }
            JOptionPane.showMessageDialog(null,answer);
        }

    public boolean noSpecialCharacters(String str){
        for (char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                return true;
            }
        }
        return false;
    }

    public  void displayCourses(List<Course> courses) {

        String str="";
        String answer="All Courses  \n";
        int count=1;
        for (Course course : courses) {
            str=" "+ "Course"+count+": "+course.getCourse()+"\n";
            answer+=str;
            count++;
        }
        JOptionPane.showMessageDialog(null,answer);
    }
    public  void displayStudents(List<Student> students) {

        String str="";
        String answer="All Students  \n";
        int count=1;
        for (Student student : students) {
            str=" "+ "Student "+count+": std name:"+student.getStudentName()+" Std id:"+
            student.getId() + "\n";
            answer+=str;
            count++;
        }
        JOptionPane.showMessageDialog(null,answer);
    }

    @Override
    public void addCourse() {


        String course = JOptionPane.showInputDialog("Physics,Chemistry,Programming","Programming");
        if(course != null && !course.isBlank() && !course.isEmpty() && noSpecialCharacters(course)) {
                Course newCourse = new Course(course, getStudentName(), getId(),getPassWord());
                addCourse(newCourse);
                JOptionPane.showMessageDialog(null, "Course is added SUCCESSFULLY");
        }else{
            JOptionPane.showMessageDialog(null, "Invalid input!","ERROR" , JOptionPane.ERROR_MESSAGE);
            relogIn();
        }
        displayCourses(getCourses());
    }



    public void addInformation() {
        String studentName = JOptionPane.showInputDialog("Put Your Name");
        if(studentName != null && !studentName.isEmpty() && !studentName.isBlank() &&noSpecialCharacters(studentName)){
            String id =  JOptionPane.showInputDialog("Enter Your ID");
            if(id != null && !id.isBlank() && !id.isEmpty() && noSpecialCharacters(id)){
                String passWord = JOptionPane.showInputDialog("Put a Strong Password");
                if(passWord != null && !passWord.isEmpty() && !passWord.isBlank() ){
                Student newStudent = new Student(studentName , Integer.parseInt( id), passWord);
                addStudent(newStudent);
                JOptionPane.showMessageDialog(null,"Your information is added successfully");

            } else{
                JOptionPane.showMessageDialog(null, "Invalid input!","ERROR" , JOptionPane.ERROR_MESSAGE);
                runStudent();
            }
            } else{
                JOptionPane.showMessageDialog(null, "Invalid input!","ERROR" , JOptionPane.ERROR_MESSAGE);
                runStudent();
            }
            } else{
            JOptionPane.showMessageDialog(null, "Invalid input!","ERROR" , JOptionPane.ERROR_MESSAGE);
            runStudent();
        }
        displayStudents(getStudents());
        runStudent();

    }



    public void deleteAndUpdateStudent(){
        String studentName = JOptionPane.showInputDialog("Please write your old name");
        String id = JOptionPane.showInputDialog("Please write your old id");
        String passWord = JOptionPane.showInputDialog("Please write your old password");
        Student studentToDelete = findStudentByNameAndPassword(studentName , passWord  , Integer.parseInt(id));
        if(studentToDelete != null){
            getStudents().remove(studentToDelete);
            String studentNameNew = JOptionPane.showInputDialog("Please write your New name");
            String studentIdNew = JOptionPane.showInputDialog("Please write your new Id ");
            String studentPasswordNew = JOptionPane.showInputDialog("Please write your new password");
            Student newDataStudent  = new Student(studentNameNew , Integer.parseInt(studentIdNew) , studentPasswordNew);
            addStudent(newDataStudent);
            displayStudents(getStudents());


        }else{
            JOptionPane.showMessageDialog(null, "Student not found");
            relogIn();
        }
    }

    public void deleteCourse(){
        String courseName = JOptionPane.showInputDialog("Please write the name of the course you want to Delete");
        Course courseToDelete = findCourseByName(courseName);
        if(courseToDelete != null){
            getAllCourses().remove(courseToDelete);
            JOptionPane.showMessageDialog(null,"Course is Deleted Successfully");
            displayCourses(getCourses());
        }else{
            JOptionPane.showMessageDialog(null, "Course not found");
            relogIn();
        }
    }

    public Student findStudentByNameAndPassword(String studentName , String passWord , int id){
                for (int i = 0; i < getStudents().size(); i++) {
                    Student modifiedStudent = getStudents().get(i);
                    if (modifiedStudent.getStudentName().equals(studentName) && modifiedStudent.getPassWord().equals(passWord) && modifiedStudent.getId() == id) {
                        return modifiedStudent;
                    }

                }
        return null;
    }
    public Course findCourseByName(String course){
        if(course != null &&!course.isBlank() && !course.isEmpty()&& noSpecialCharacters(course)){
            for(int i = 0 ; i < getAllCourses().size(); i++){
                Course deletedCourse = getAllCourses().get(i);
                if(deletedCourse.getCourse().equals(course)){
                    return deletedCourse;
                }
            }
        }
        return null;
    }

    public List<Course> getAllCourses(){
        return getCourses();
    }

    public void run(){
        String[] options = {"Select from the Choices Below", "Student" , "Admin"};
        String choice = (String) JOptionPane.showInputDialog(null,
                "Select one of Options",
                "Student Management System",
                JOptionPane.DEFAULT_OPTION,
                null,
                options,
                options[0]);
        switch(choice) {
            case "Select from the Choices Below" :
                JOptionPane.showMessageDialog(null,
                        "Please select one of valid options",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                run();
            case "Admin" :
                JOptionPane.showMessageDialog(null , "I was kidding just select Student's option xD",
                        "wasn't assigned to make admin interface!",
                        JOptionPane.ERROR_MESSAGE);
                run();
            case "Student" :
                String[] choiceOfStudent = {"Select from the Choices Below" , "Log In","Add My Information","Back to main"};
                String studentChoice = (String) JOptionPane.showInputDialog(null,
                        "Select one of the Options",
                        "Student's Interface",
                        JOptionPane.DEFAULT_OPTION,
                        null,
                        choiceOfStudent,
                        choiceOfStudent[0]);
                switch (studentChoice) {
                    case "Select from the Choices Below":
                        JOptionPane.showMessageDialog(null, "select a choice ", " ERROR", JOptionPane.ERROR_MESSAGE);
                        runStudent();
                    case "Add My Information":
                        addInformation();
                        runStudent();
                    case "Log In":
                        login();
                    case "Back to main":
                        run();
                    default:
                        System.exit(0);  //when press exits doesn't give an error!!!!
                        break;
                }
        }
    }
    public void runStudent() {
        String[] choiceOfStudent = {"Select from the Choices Below" , "Log In","Add My Information","Back to main"};
        String studentChoice = (String) JOptionPane.showInputDialog(null,
                "Select one of the Options",
                "Student's Interface",
                JOptionPane.DEFAULT_OPTION,
                null,
                choiceOfStudent,
                choiceOfStudent[0]);
        if(studentChoice == "Select from the Choices Below"){
            JOptionPane.showMessageDialog(null, "select a choice ", " ERROR", JOptionPane.ERROR_MESSAGE);
            runStudent();
        } else if (studentChoice == "Add My Information") {
            addInformation();
        }else if (studentChoice == "Log In") {
            login();
        }
        else if(studentChoice == "Back to main"){
            run();
        }else{
            System.exit(0);  //when press exits doesn't give an error!!!!
        }
    }
    private boolean isAlreadyAuthenticated = false;
    public void login() {
        if (!isAlreadyAuthenticated) {
            String studentName = JOptionPane.showInputDialog("Enter Your Name");
            if(studentName != null && !studentName.isEmpty() && !studentName.isBlank() &&noSpecialCharacters(studentName)) {
                String passWord = JOptionPane.showInputDialog("Enter Your Password");
                if (passWord != null && !passWord.isEmpty() && !passWord.isBlank()) {

                    boolean isAuthenticated = false;
                    for (Student student : getStudents()) {
                        if (student.getStudentName().equals(studentName) && student.getPassWord().equals(passWord)) {
                            isAuthenticated = true;
                            break;
                        }
                    }

                    if (!isAuthenticated) {
                        JOptionPane.showMessageDialog(null, "Invalid login", "ERROR", JOptionPane.ERROR_MESSAGE);
                        run();
                    }

                }else{              JOptionPane.showMessageDialog(null, "Invalid login", "ERROR", JOptionPane.ERROR_MESSAGE);
                    run();}

                String[] options = {"Add Courses", "Get my Grades", "Delete Course", "Update my Information", "Back to main"};
                String choice = (String) JOptionPane.showInputDialog(
                        null,
                        "Select one of Options",
                        "Student Management System",
                        JOptionPane.DEFAULT_OPTION,
                        null,
                        options,
                        options[0]);

                if (choice == null) {
                    System.exit(0);
                }

                switch (choice) {
                    case "Add Courses":
                        addCourse();
                        relogIn();
                    case "Get my Grades":
                        getGrades();
                        relogIn();
                    case "Delete Course":
                        deleteCourse();
                        relogIn();
                    case "Update my Information":
                        deleteAndUpdateStudent();
                        relogIn();
                    case "Back to main":
                        run();
                    default:
                        System.exit(0);
                        break;
                }
            }else {                JOptionPane.showMessageDialog(null, "Invalid login", "ERROR", JOptionPane.ERROR_MESSAGE);
                    run();
            }
        }else{                JOptionPane.showMessageDialog(null, "Invalid login", "ERROR", JOptionPane.ERROR_MESSAGE);
                run();
        }
    }
    public void relogIn(){
        String[] options = {"Add Courses", "Get my Grades", "Delete Course","Update my Information" ,"Back to main"};
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Select one of Options",
                "Student Management System",
                JOptionPane.DEFAULT_OPTION,
                null,
                options,
                options[0]);

        if (choice == null) {
            System.exit(0);
        }

        switch (choice) {
            case "Add Courses":
                addCourse();
                relogIn();
            case "Get my Grades":
                getGrades();
                relogIn();
            case "Delete Course":
                deleteCourse();
                relogIn();
            case "Update my Information" :
                deleteAndUpdateStudent();
                relogIn();
            case "Back to main":
                run();
            default:
                System.exit(0);
                break;
        }
    }

}

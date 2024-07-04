import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Course{




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
            case "Student" :
                String[] choiceOfStudent = {"Select from the Choices Below" , "Add My Information", "Add Courses", "Get my Grades","Delete Course", "Back to System"};
                String studentChoice = (String) JOptionPane.showInputDialog(null,
                        "Select one of the Options",
                        "Student's Interface",
                        JOptionPane.DEFAULT_OPTION,
                        null,
                        choiceOfStudent,
                        choiceOfStudent[0]);
                if(studentChoice == "Select from the Choices Below"){
                    JOptionPane.showMessageDialog(null, "select a choice ", " ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (studentChoice == "Add My Information") {

                } else if (studentChoice == "Add Courses") {
                    addCourse();
                } else if (studentChoice == "Get my Grades") {

                } else if (studentChoice == "Delete Course") {
                    deleteCourse();
                } else if (studentChoice == "Back to System") {
                    run();
                }else{
                    System.exit(0);  //when press exits doesn't give an error!!!!
                }
        }
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

    public void addCourse() {


        String course = JOptionPane.showInputDialog("Physics,Chemistry,Programming","Programming");
        if(course != null && !course.isBlank() && !course.isEmpty() && noSpecialCharacters(course)) {
                Course newCourse = new Course(course);
                addCourse(newCourse);
                JOptionPane.showMessageDialog(null, "Course is added SUCCESSFULLY");
        }else{
            JOptionPane.showMessageDialog(null, "Invalid input!","ERROR" , JOptionPane.ERROR_MESSAGE);
            run();
        }
        displayCourses(getCourses());
        run();
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
        }
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
}

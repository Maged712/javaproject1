import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Student  implements StudentManagement {
    ArrayList<Course> courses = new ArrayList<>();
    Course course = new Course();
    Admin admin = new Admin();

    @Override
    public void addCourse() {

    }
    //    public void displayCourses() {
//        if (courses.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "No courses available.");
//            return;
//        }
//
//        // Using simple string concatenation to build the message
//        String message = "Courses:\n";
//        for (Course course : courses) {
//            message += course.getCourses() + "\n";
//        }
//
//        // Display the courses using JOptionPane
//        JOptionPane.showMessageDialog(null, message, "Course List", JOptionPane.INFORMATION_MESSAGE);
//    }

    @Override
    public void addInformation() {

    }

    @Override
    public void deleteCourse() {

    }

    @Override
    public void getGrades() {

    }
}

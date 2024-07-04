import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Course  {
    private String course;




    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Course(String course) {
        this.course = course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public String getCourse(){
        return course;
    }
    public Course(){

    }

    public void addCourse(Course course) {
        courses.add(course);
    }


}

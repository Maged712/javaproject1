import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Course  extends Student{
    private String course;
    Student student = new Student(getStudentName() , getId() , getPassWord());


    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Course(String course, String studentName, int id , String passWord) {
        super(studentName,id,passWord);
        this.course = course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public String getCourse(){
        return course;
    }
    public Course(String studentName, int id , String passWord){
    super(studentName,id,passWord);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }


}

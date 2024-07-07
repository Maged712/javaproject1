import java.util.ArrayList;

public class Course  extends Student{
    private String course;
    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<String> getOldCourses() {
        return this.oldCourses;
    }
    public void setOldCourses(ArrayList<String> oldCourses) {
        this.oldCourses = oldCourses;
    }
    private ArrayList<String> oldCourses = new ArrayList<String>();


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

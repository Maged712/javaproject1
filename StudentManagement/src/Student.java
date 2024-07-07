import java.util.ArrayList;
import java.util.List;

public class Student  {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    private String student;
    private String studentName;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    private int id;
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public Student(String studentName , int id , String passWord) {
        this.studentName = studentName;
        this.id = id;
        this.passWord = passWord;
    }
    public Student(String studentName  , String passWord) {
        this.studentName = studentName;
        this.passWord = passWord;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}

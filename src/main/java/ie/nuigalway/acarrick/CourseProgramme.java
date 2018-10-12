import org.joda.time.DateTime;
import java.util.ArrayList;

public class CourseProgramme {
  public String courseName;
  public ArrayList<Module> modules;
  public ArrayList<Student> enrolledStudents;
  public DateTime startDate;
  public DateTime endDate;

  public CourseProgramme(String courseName, DateTime startDate, DateTime endDate){
    this.courseName = courseName;
    this.startDate = startDate;
    this.endDate = endDate;
    modules = new ArrayList<Module>();
    enrolledStudents = new ArrayList<Student>();
  }

  public void addModule(Module m){
    if(!modules.contains(m)){
      modules.add(m);
      if(!m.hasCourse(this)){
        m.addCourse(this);
      }
    }
  }

  public void removeModule(Module m){
    modules.remove(m);
    if(m.hasCourse(this)){
      m.removeCourse(this);
    }
  }

  protected void addStudent(Student s){
    if(!enrolledStudents.contains(s)){
      enrolledStudents.add(s);
    }
  }

  protected void removeStudent(Student s){
    enrolledStudents.remove(s);
  }

  public boolean hasModule(Module m){
    if(modules.contains(m)){
      return true;
    }
    return false;
  }

}

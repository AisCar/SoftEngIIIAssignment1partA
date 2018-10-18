import org.joda.time.DateTime;
import java.util.ArrayList;

public class CourseProgramme {
  private String courseName;
  private ArrayList<Module> modules;
  private ArrayList<Student> enrolledStudents;
  private DateTime startDate;
  private DateTime endDate;

  /*
  Constructor
  */
  public CourseProgramme(String courseName, DateTime startDate, DateTime endDate){
    this.courseName = courseName;
    this.startDate = startDate;
    this.endDate = endDate;
    modules = new ArrayList<Module>();
    enrolledStudents = new ArrayList<Student>();
  }


  /*
  Mutator methods
  */
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

  public ArrayList<Module> getModules(){
    return this.modules;
  }

  public void addStudent(Student s){
    if(!enrolledStudents.contains(s)){
      enrolledStudents.add(s);
    }
  }

  public void removeStudent(Student s){
    enrolledStudents.remove(s);
  }

  public ArrayList<Student> getStudents(){
    return this.enrolledStudents;
  }

  public String getName(){
    return this.courseName;
  }

  public void setName(String name){
    this.courseName = name;
  }

  public DateTime getStartDate(){
    return this.startDate;
  }

  public void setStartDate(DateTime dt){
    this.startDate = dt;
  }

  public DateTime getEndDate(){
    return this.endDate;
  }

  public void setEndDate(DateTime dt){
    this.endDate = dt;
  }

  /*
  Methods for checking membership
  */

  public boolean hasModule(Module m){
    return modules.contains(m);
  }

  public boolean hasStudent(Student s){
    return enrolledStudents.contains(s);
  }

}

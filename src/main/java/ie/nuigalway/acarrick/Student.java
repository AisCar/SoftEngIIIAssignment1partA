import org.joda.time.DateTime;
import java.util.ArrayList;

public class Student {
  private String name;
  private int age;
  private DateTime dob;
  private ArrayList<Module> modules;
  private CourseProgramme course;

  /*
  Constructor
  */
  public Student(String name, int age, DateTime dob, CourseProgramme course){
    this.name = name;
    this.age = age;
    this.dob = dob;
    this.course = course;
    course.addStudent(this);
    modules = new ArrayList<Module>();
  }

  /*
  getUsername method concatenates name and age of student
  */

  public String getUsername(){
    String username = "";
    for(String substring : name.split(" ")){
      username = username + substring;
    }
    username = username + age;
    return username;
  }

  /*
  Mutator Methods
  */

  public String getName(){
    return this.name;
  }

  public void setName(String newName){
    this.name = newName;
  }

  public void addModule(Module m){
    //Student can only join module if it is part of their course
    if(course.hasModule(m)){
      //Add module to student
      modules.add(m);
      //Add student to module
      if(!m.hasStudent(this)){
        m.addStudent(this);
      }
    }

  }

  public void removeModule(Module m){
    //Remove module from student
    modules.remove(m);
    //Remove student from module
    if(m.hasStudent(this)){
      m.removeStudent(this);
    }
  }

  public ArrayList<Module> getModules(){
    return this.modules;
  }

  public void setCourse(CourseProgramme newCourse){
    course.removeStudent(this);
    course = newCourse;
    course.addStudent(this);
    for(Module m : modules) this.removeModule(m);
  }

  public CourseProgramme getCourse(){
    return this.course;
  }

  /*
  Methods for checking membership
  */
  public boolean isInModule(Module m){
    return modules.contains(m);
  }

  public boolean isInCourse(CourseProgramme c){
    return course.equals(c);
  }


}

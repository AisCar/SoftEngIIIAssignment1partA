import org.joda.time.DateTime;
import java.util.ArrayList;

public class Student {
  protected String name;
  protected int age;
  protected DateTime dob;
  protected ArrayList<Module> modules;
  protected CourseProgramme course;

  public Student(String name, int age, DateTime dob, CourseProgramme course){
    this.name = name;
    this.age = age;
    this.dob = dob;
    this.course = course;
    course.addStudent(this);
    modules = new ArrayList<Module>();
  }

  public String getUsername(){
    String username = name + age;
    return username;
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

  public void switchCourse(CourseProgramme newCourse){
    course.removeStudent(this);
    course = newCourse;
    course.addStudent(this);
    //TODO: Remove modules as well? For now, leave alone.
  }

  public boolean isInCourse(CourseProgramme c){
    return course.equals(c);
  }

  public boolean isInModule(Module m){
    return modules.contains(m);
  }

}

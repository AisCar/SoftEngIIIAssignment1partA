import org.joda.time.DateTime;
import java.util.List;

public class Student {
  protected String name;
  protected int age;
  protected DateTime dob;
  protected List<Module> modules;
  protected CourseProgramme course;

  public Student(String name, int age, DateTime dob, CourseProgramme course){
    this.name = name;
    this.age = age;
    this.dob = dob;
    this.course = course;
    //TODO: Decide on registration workflow
  }

  public String getUsername(){
    String username = name + age;
    return username;
  }

}

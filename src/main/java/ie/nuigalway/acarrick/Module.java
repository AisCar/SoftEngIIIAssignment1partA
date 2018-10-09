import java.util.List;

public class Module {
  public String name;
  public String id;
  public List<Student> students;
  public List<CourseProgramme> courses;

  public Module(String name, String id){
    this.name = name;
    this.id = id;
    //TODO: Decide on registration workflow
  }

}

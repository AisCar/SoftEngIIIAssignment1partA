import org.joda.time.DateTime;
import java.util.List;

public class CourseProgramme {
  public String courseName;
  public List<Module> modules;
  public List<Student> enrolledStudents;
  public DateTime startDate;
  public DateTime endDate;

  public CourseProgramme(String courseName, DateTime startDate, DateTime endDate){
    this.courseName = courseName;
    this.startDate = startDate;
    this.endDate = endDate;
    //TODO: Decide on registration workflow
  }

}

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.joda.time.DateTime;
import java.util.List;

public class Assignment1Test {

  @Test
  public void getUsernameTest(){
    //Dates are all set to current time. Maybe make some more effort later.
    //Not what I'm testing though.
    CourseProgramme testCourse = new CourseProgramme("CS&IT", new DateTime(), new DateTime());
    Student student = new Student("AliceSmith", 20, new DateTime(), testCourse);
    String username = student.getUsername();
    assertEquals("AliceSmith20", username);
  }


}

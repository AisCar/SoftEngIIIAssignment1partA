import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.joda.time.DateTime;
import java.util.ArrayList;

public class Assignment1Test {


  @Test
  public void getUsernameTest(){
    //Dates are all set to today, but doesn't cause any issues with testing
    CourseProgramme testCourse = new CourseProgramme("CS&IT", new DateTime(), new DateTime());
    Student student = new Student("Alice Smith", 20, new DateTime(), testCourse);
    String username = student.getUsername();
    assertEquals("AliceSmith20", username);
  }

  @Test
  public void testModuleRegistration(){//TODO break up / make more tests - have poor coverage
    Module m1 = new Module("Software Engineering III", "CT417");
    Module m2 = new Module("Artificial Intelligence", "CT421");
    Module m3 = new Module("Modern Information Management", "CT422");

    CourseProgramme testCourse = new CourseProgramme("CS&IT", new DateTime(), new DateTime());
    Student student = new Student("Alice Smith", 20, new DateTime(), testCourse);

    testCourse.addModule(m1);
    testCourse.addModule(m2);

    student.addModule(m1);
    student.addModule(m2);
    student.addModule(m3);

    assertEquals(2, student.modules.size());
    assertTrue(m1.students.contains(student));
  }


}

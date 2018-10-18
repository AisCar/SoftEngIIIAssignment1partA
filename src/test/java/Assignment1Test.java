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
    Student s1 = new Student("Alice Smith", 20, new DateTime(), testCourse);
    assertEquals("AliceSmith20", s1.getUsername());
    Student s2 = new Student("Jolkien Rolkien R Tolkien", 120, new DateTime(), testCourse);
    assertEquals("JolkienRolkienRTolkien120", s2.getUsername());
    Student s3 = new Student("paul", 0, new DateTime(), testCourse);
    assertEquals("paul0", s3.getUsername());
  }

  @Test
  public void testModuleRegistration(){
    Module m1 = new Module("Software Engineering III", "CT417");
    Module m2 = new Module("Artificial Intelligence", "CT421");
    Module m3 = new Module("Modern Information Management", "CT422");

    CourseProgramme testCourse = new CourseProgramme("CS&IT", new DateTime(), new DateTime());
    Student student = new Student("Alice Smith", 20, new DateTime(), testCourse);

    testCourse.addModule(m1);
    testCourse.addModule(m2);

    student.addModule(m1);
    student.addModule(m2);
    //Student shouldn't be able to register for modules that are not part of their course
    student.addModule(m3);

    assertEquals(2, student.getModules().size());
    assertTrue(m1.getStudents().contains(student));
    assertTrue(!m3.getStudents().contains(student));

    student.removeModule(m1);
    student.removeModule(m2);

    assertEquals(0, student.getModules().size());
  }

  @Test
  public void testStudentsCanSwitchCourse(){
    CourseProgramme course1 = new CourseProgramme("CS&IT", new DateTime(), new DateTime());
    Student student = new Student("Alice Smith", 20, new DateTime(), course1);

    assertEquals(course1, student.getCourse());
    assertTrue(course1.hasStudent(student));

    CourseProgramme course2 = new CourseProgramme("ECE", new DateTime(), new DateTime());
    student.setCourse(course2);

    assertEquals(course2, student.getCourse());
    assertTrue(!course1.hasStudent(student));
    assertTrue(course2.hasStudent(student));

  }


}

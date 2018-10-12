import java.util.ArrayList;

public class Module {
  public String name;
  public String id;
  public ArrayList<Student> students;
  public ArrayList<CourseProgramme> courses;

  public Module(String name, String id){
    this.name = name;
    this.id = id;
    students = new ArrayList<Student>();
    courses = new ArrayList<CourseProgramme>();
  }

  public void addStudent(Student s){
    //Student can only join module if module is associated with their course
    if(courses.contains(s.course)){
      //Add student to this module
      students.add(s);
      //Add this module to student
      if(!s.isInModule(this)){
        s.addModule(this);
      }
    }
  }

  public void removeStudent(Student s){
    //Remove student from this module
    students.remove(s);
    //Remove this module from student
    if(s.isInModule(this)){
      s.removeModule(this);
    }
  }

  public void addCourse(CourseProgramme course){
    //Add course to this module
    if(!courses.contains(course)){
      courses.add(course);
    }
    //Add this module to course
    if(!course.hasModule(this)){
      course.addModule(this);
    }
  }

  public void removeCourse(CourseProgramme course){
    //remove course from this module
    courses.remove(course);
    //remove this module from course
    if(course.hasModule(this)){
      course.removeModule(this);
    }
  }

  public boolean hasStudent(Student s){
    return students.contains(s);
  }

  public boolean hasCourse(CourseProgramme cp){
    return courses.contains(cp);
  }

}

/*
* Title: Course.java
* Abstract: Implement a Course class that keeprs track of the course information along with
            the number of students enrolled for the course
* ID: 1627
* Name: Israel Andrade
* Date: 3/10/17
*/
import java.util.*;
public class Course
{
  private int course_number;
  private String course_title;
  private int course_capacity;
  private String location;
  private HashMap <Integer, Student> students = new HashMap<Integer, Student>();
  private Instructor instructor;
  private double avgScore;
  private int enrolled;

  public Course()
  {
    course_number = 0;
    course_title = " ";
    course_capacity = 0;
    location = "";
    enrolled = 0;
  }
  public Course(Object obj)
  {
    if(obj instanceof Course)
    {
      Course course = (Course) obj;
      setCourseNumber(course.getCourseNumber());
      setCourseTitle(course.getCourseTitle());
      setCouseCapacity(course.getCourseCapacity());
      setLocation(course.getLocation());
      enrolled = 0;

    }
  }
  public Course(int course_number, String course_title, int course_capacity, String location)
  {
    setCourseNumber(course_number);
    setCourseTitle(course_title);
    setCouseCapacity(course_capacity);
    setLocation(location);
    enrolled = 0;
  }
  public Instructor getInstructor()
  {
    return this.instructor;
  }
  //setters
  public void setCourseNumber(int course_number)
  {
    if(course_number < 0)
    {
      System.out.println("Course number can't be negative");
      course_number = 0;
    }
    else
    {
      this.course_number = course_number;
    }

  }

  public void setCourseTitle(String course_title)
  {
    this.course_title = course_title;
  }

  public void setCouseCapacity(int course_capacity)
  {
    if(course_capacity < 0)
    {
      System.out.println("Capcity can't be nagative");
      course_capacity = 0;
    }
    this.course_capacity = course_capacity;
  }
  public void setLocation(String location)
  {
    this.location = location;
  }
  //getters
  public int getCourseNumber()
  {
    int tempCourseNumber = course_number;
    return tempCourseNumber;
  }
  public String getCourseTitle()
  {
    String tempCourseTitle = course_title;
    return tempCourseTitle;
  }
  public int getEnrolled()
  {
    return this.enrolled;
  }
  public int getCourseCapacity()
  {
    int tempCapacity = course_capacity;
    return tempCapacity;
  }
  public String getLocation()
  {
    String tempLocation = location;
    return tempLocation;
  }
  public void updateLocation(String newLocation)
  {
    this.location = newLocation;
  }
  public boolean hasStudents()
  {
    return !students.isEmpty();
  }
  public boolean hasStudent(int studentId)
  {
    return students.containsKey(studentId);
  }
  public void removeStudent(int studentId)
  {
    if(students.containsKey(studentId))
    {
      students.remove(studentId);
      enrolled--;
      setAvgScore();
    }
  }
  public void setInstructor(Object obj)
  {
    if(obj instanceof Instructor)
    {
      Instructor newIntructor = (Instructor) obj;
      instructor = new Instructor(newIntructor);
    }
  }
  public void addStudent(Object obj)
  {
    if(obj instanceof Student && course_capacity > enrolled)
    {
      Student temp = (Student) obj;
      Student newStudent = new Student(temp);
      students.put(newStudent.getId(), newStudent);
      enrolled++;
    }
    else
    {
      System.out.println("Registration failed – Class is full.");
    }

  }
  /*
  public void addScore(int studentId, double score)
  {
    if(students.containsKey(studentId) && score > 0)
    {
      students.get(studentId).setScore(course_number, score);
    }
    else
    {
      return;
    }
    this.avgScore += score;
  }
  courses.get(courseId).addScore(studentId, score);
  */
  public void setStudentScore(int studentId, double score)
  {
    students.get(studentId).setScore(score);
    //students.get(studentId).setCourseScore(course_number, score);
    setAvgScore();
  }
  public void setScore(double score)
  {
    this.avgScore = score;
  }

  public double getScore()
  {
    double avgTemp = avgScore;
    return avgTemp;
  }

  public void setAvgScore()
  {
    double totalScore = 0;
    if(!students.isEmpty())
    {
      for(HashMap.Entry<Integer, Student> entry: students.entrySet())
      {
        //System.out.println("Student name is: " + entry.getValue().getName());
        //System.out.println("Student Score is: " + entry.getValue().getScore());
        //System.out.println("\n" + entry.getValue());
        totalScore += entry.getValue().getScore();
      }
      //System.out.println("Total Score: " + totalScore);
      avgScore = (totalScore / getClassSize());
      //System.out.println("Class Size: " + getClassSize());
    }
  }


  public int getClassSize()
  {
    return enrolled;
  }

  public void courseInfo()
  {
    System.out.println("Course Number: " + course_number);
    System.out.println("Instructor: " + instructor.getName());
    System.out.println("Course Title: " + course_title);
    System.out.println("Room: " + location);
    System.out.println("Total Enrolled: " + enrolled);
    System.out.println("Course Average: " + avgScore);
  }
}

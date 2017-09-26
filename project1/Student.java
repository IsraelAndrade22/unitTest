/*
* Title: Student.java
* Abstract: Implement Student class that keeps track of the students infromation. The
            student has courses that he/she is currently taking
* ID: 1627
* Name: Israel Andrade
* Date: 3/10/17
*/
import java.util.*;
public class Student
{
  private int studentId;
  private String name;
  private HashMap<Integer, Course> courses = new HashMap<Integer, Course>();
  private double score;

  public Student()
  {
    this.studentId = 0;
    this.name = "";
  }
  public Student(int studentId, String name)
  {
    this.studentId = studentId;
    this.name = name;
  }
  public Student(Object obj)
  {
    if(obj instanceof Student)
    {
      Student student = (Student) obj;
      setId(student.getId());
      setName(student.getName());
      setScore(student.getScore());
      score = 0;

    }
  }
  public String toString()
  {
    /*
    Student Number: 7777
    Name: Alice Otter
    Courses Enrolled:
    306: 100.00
    205: 100.00
    Course Average: 100.00
    */
    String temp = "Student Number: " + studentId + "\n";
    temp += "Name: " + name + "\n";
    temp += "Courses Enrolled:\n";
    for(HashMap.Entry<Integer, Course> entry: courses.entrySet())
    {
      temp += "\t" + entry.getValue().getCourseNumber() + ": ";
      temp += entry.getValue().getScore();
      temp += "\n";
    }
    temp += "Course Average: " + score;
    return temp;
  }
  //setters
  public void setId(int id)
  {
    this.studentId = id;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  //getters
  public int getId()
  {
    int temp = studentId;
    return temp;
  }
  public String getName()
  {
    String tempName = name;
    return tempName;
  }
  public void addCourse(Object obj)
  {
    /*
    if(obj instanceof Course)
    {
      Course newCourse = (Course) obj;
      courses.put(newCourse.getCourseNumber(), newCourse);
      //course_capacity--;
    }
    */
    if(obj instanceof Course)
    {
      Course temp = (Course) obj;
      Course newCourse = new Course(temp);
      courses.put(newCourse.getCourseNumber(), newCourse);
    }
  }


  public void setScore(double score)
  {
    this.score = score;
  }
  public void setCourseScore(int courseId, double score)
  {
    double totalScore = 0;
    if(courses.containsKey(courseId))
    {
      courses.get(courseId).setScore(score);
      //courses.get(courseId).setScore(studentId, score);
    }
    else
    {
      return;
    }

    for(HashMap.Entry<Integer, Course> entry: courses.entrySet())
    {
      totalScore += entry.getValue().getScore();
    }
    this.score = (totalScore / courses.size());
  }

  public double getScore()
  {
    double temp = score;
    return temp;
  }
  public double getCourseScore(int courseId)
  {
    return courses.get(courseId).getScore();
  }
  public boolean isRegistered(int courseId)
  {
    return courses.containsKey(courseId);
  }

  //public boolean equals(Object obj)
}

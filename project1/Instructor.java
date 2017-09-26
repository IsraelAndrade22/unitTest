/*
* Title: Instructor.java
* Abstract: Implement an Instructor class that keeps track of the intructors information
            and the courses that he is currently teaching
* ID: 1627
* Name: Israel Andrade
* Date: 3/10/17
*/
import java.util.*;
public class Instructor
{
  private int employeeId;
  private String name;
  private String email_address;
  private String phone_number;
  private HashMap<Integer, Course> courses = new HashMap<Integer, Course>();
  public Instructor()
  {
    employeeId = 0;
    name = "Default";
    email_address = "Default@csumb.edu";
    phone_number = "111-1111-111";
  }
  public Instructor(int employeeId, String name, String email_address, String phone_number)
  {
    setEmployeeId(employeeId);
    setName(name);
    setEmailAddress(email_address);
    setPhoneNumber(phone_number);
  }
  public Instructor(Object obj)
  {
    if(obj instanceof Instructor)
    {
      Instructor copy = (Instructor) obj;
      setEmployeeId(copy.getEmployeeId());
      setName(copy.getName());
      setEmailAddress(copy.getEmailAddress());
      setPhoneNumber(copy.getPhoneNumber());
    }
  }
  //setters
  public void setEmployeeId(int id)
  {
    if(id < 0)
    {
      System.out.println("Instructors ID can not be negative");
      System.out.println("Employee Id will be set to zero");
      id = 0;
      this.employeeId = id;
    }
    this.employeeId = id;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setEmailAddress(String email_address)
  {
    this.email_address = email_address;
  }
  public void setPhoneNumber(String phone_number)
  {
    this.phone_number = phone_number;
  }
  //getters

  public String getName()
  {
    String tempName = name;
    return tempName;
  }
  public String getEmailAddress()
  {
    String tempEmail = email_address;
    return tempEmail;
  }
  public int getEmployeeId()
  {
    int tempVal = employeeId;
    return tempVal;
  }
  public String getPhoneNumber()
  {
    String tempNumber = phone_number;
    return tempNumber;
  }

  public void addCourse(Object obj)
  {
    if(obj instanceof Course)
    {
      Course newCourse = (Course) obj;
      courses.put(newCourse.getCourseNumber(), newCourse);
      //course_capacity--;
    }
    else
    {
      System.out.println("Noe an instance of course");
    }
  }

  public boolean hasCourse(int courseId)
  {
    for(HashMap.Entry<Integer, Course> entry : courses.entrySet())
    {
      if(entry.getValue().getCourseNumber() == courseId)
      {
        return true;
      }
    }
    return false;
  }
  public String toString()
  {
    String temp = "Instructor Number: " + employeeId  + "\n"
    + "Name: " + name + "\n";
    String temp2 = "";
    for(HashMap.Entry<Integer, Course> entry: courses.entrySet())
    {
      temp2 += "\t" + Integer.toString(entry.getValue().getCourseNumber());
      temp2 += ": " + Integer.toString(entry.getValue().getEnrolled());
      temp2 += " enrolled\n";
    }
    return (temp + temp2);
  }

}

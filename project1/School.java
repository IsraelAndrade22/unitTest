/*
* Title: School.java
* Abstract: Implement school system that keeps track of the courses, students, and instructors
            in the school system
* ID: 1627
* Name: Israel Andrade
* Date: 3/10/17
*/
import java.util.*;
import java.io.*;
public class School
{
  private HashMap <Integer,Instructor> instructors = new HashMap <Integer, Instructor>();
  private HashMap <Integer, Course> courses = new HashMap <Integer, Course> ();
  private HashMap <Integer, Student> students = new HashMap <Integer, Student> ();
  private String name;

  public School()
  {
    this.name = "default";
  }

  public School(String name)
  {
    this.name = name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getName()
  {
    String tempName = name;
    return tempName;
  }
  public void readData(String fileName)
  {
    Scanner in = new Scanner(System.in);
    Scanner file = new Scanner(System.in);
    try
    {
      file = new Scanner(new File(fileName));
    }
    catch(Exception e)
    {
      System.out.println("Error opening file");
      return;
    }
    int numberOfObject = 0;
    int employeeId = 0;
    String name = "";
    String email_address = "";
    String phone_number = "";
    //Get the number of instructors
    try
    {
      numberOfObject = file.nextInt();
    }
    catch(Exception e)
    {
      System.out.println("Error reading in number of instructors");
    }
    //Get the empty space that is left after reading in the number of customers
    String emptyString;
    try
    {
      emptyString = file.nextLine();
    }
    catch(Exception e)
    {
      System.out.println("Error reading in the next line");
    }

    //Use a delimeter to read in comma seperated values
    file.useDelimiter(",");
    for(int i = 0; i < numberOfObject && file.hasNext(); i++)
    {
      try
      {
        employeeId = file.nextInt();
      }
      catch(Exception e)
      {
        System.out.println("Employee id could not be read");
      }

      try
      {
        name = file.next();
      }
      catch(Exception e)
      {
        System.out.println("Name could not be read");
      }
      try
      {
        email_address = file.next();
      }
      catch(Exception e)
      {
        System.out.println("Email could not be read");
      }

      try
      {
        phone_number = file.nextLine();
      }
      catch(Exception e)
      {
        System.out.println("Phone number could not be read");
      }
      try
      {
        phone_number = phone_number.substring(1, phone_number.length());
      }
      catch(Exception e)
      {
        System.out.println("Wrong length for phone number");
      }

      if(instructors.containsKey(employeeId))
      {
        System.out.println("Instructor info reading failed – Employee number " + employeeId +" already used. ");
      }
      else
      {
        Instructor instructor = new Instructor(employeeId, name, email_address, phone_number);
        instructors.put(employeeId, instructor);
      }

    }

    file.useDelimiter("");
    try
    {
      numberOfObject = file.nextInt();
    }
    catch(Exception e)
    {
      System.out.println("Error reading in the next line");
    }
    try
    {
      emptyString = file.nextLine();
    }
    catch(Exception e)
    {
      System.out.println("Error reading in the next line");
    }
    file.useDelimiter(",");
    int course_number = 0;
    String course_title = "";
    int course_capacity = 0;
    String location = "";
    System.out.println("\n");
    for(int i = 0; i < numberOfObject && file.hasNext(); i++)
    {
      try
      {
        course_number = file.nextInt();
      }
      catch(Exception e)
      {
        System.out.println("Error reading in the course number");
      }
      try
      {
        course_title = file.next();
      }
      catch(Exception e)
      {
        System.out.println("Error reading in course title");
      }
      try
      {
        course_capacity = file.nextInt();
      }
      catch(Exception e)
      {
        System.out.println("Error reading in course_capacity");
      }

      try
      {
        location = file.nextLine();
      }
      catch(Exception e)
      {
        System.out.println("Error reading in the location");
      }
      try
      {
        location = location.substring(1, location.length());
      }
      catch(Exception e)
      {
        System.out.println("Wrong length");
      }

      if(courses.containsKey(course_number))
      {
        System.out.println("Course info reading failed – course number " + course_number +" already used. ");
      }
      else
      {
        Course course = new Course(course_number, course_title, course_capacity, location);
        courses.put(course_number, course);
      }

    }

    file.useDelimiter("");
    try
    {
      numberOfObject = file.nextInt();
    }
    catch(Exception e)
    {
      System.out.println("Error reading in the number of students");
    }

    try
    {
      emptyString = file.nextLine();
    }
    catch(Exception e)
    {
      System.out.println("Error reading in next line");
    }
    file.useDelimiter(",");
    int studentId = 0;
    System.out.println("\n");
    for(int i = 0; i < numberOfObject && file.hasNext(); i++)
    {
      try
      {
        studentId = file.nextInt();
      }
      catch(Exception e)
      {
        System.out.println("Error reading in student Id");
      }
      try
      {
        name = file.nextLine();
      }
      catch(Exception e)
      {
        System.out.println("Error reading in student name");
      }
      name = name.substring(1, name.length());

      if(students.containsKey(studentId))
      {
          System.out.println("Student info reading failed – Student Id " + studentId +" already used. ");
      }
      else
      {
        Student student = new Student(studentId, name);
        students.put(studentId, student);
      }
    }
    System.out.println("Done");
    return;
  }
  public void schoolInfo()
  {

    System.out.println("Student Name: " + name);
    System.out.println("Instructor Information");
    for(HashMap.Entry<Integer, Instructor> entry : instructors.entrySet())
    {
      System.out.println("\t" + entry.getValue().getName());
    }

    System.out.println("Course Information");
    for(HashMap.Entry<Integer, Course> entry: courses.entrySet())
    {
      System.out.println("\t" + entry.getValue().getCourseTitle());
    }

    System.out.println("Student Information");
    for(HashMap.Entry<Integer, Student> entry: students.entrySet())
    {
      System.out.println("\t" + entry.getValue().getName());
    }

  }

  public void searchByEmail(String email)
  {

    System.out.println("Search key: " + email);
    for(HashMap.Entry<Integer, Instructor> entry : instructors.entrySet())
    {
      if(entry.getValue().getEmailAddress().equals(email))
      {
        System.out.println("\tEmployee Number: " + entry.getValue().getEmployeeId());
        System.out.println("\tName: " + entry.getValue().getName());
        System.out.println("\tPhone: " + entry.getValue().getPhoneNumber());
      }
    }
    System.out.println("Failed to find email");
  }
  public boolean deleteCourse(int courseId)
  {
    if(courses.containsKey(courseId))
    {
      if(!courses.get(courseId).hasStudents())
      {
        courses.remove(courseId);
        return true;
      }
    }
    System.out.println("Course is not empty");
    return false;
  }

  public void graduateStudent(int studentId)
  {
    //in courses
    //removing students from all courses that they are in
    for(HashMap.Entry<Integer, Course> entry: courses.entrySet())
    {
      entry.getValue().removeStudent(studentId);
    }
    students.remove(studentId);
  }
  public void assignInstructor(int courseId, int instructorId)
  {
    if(courses.containsKey(courseId) && instructors.containsKey(instructorId))
    {
      courses.get(courseId).setInstructor(instructors.get(instructorId));
      instructors.get(instructorId).addCourse(courses.get(courseId));
    }
    else if(!instructors.containsKey(instructorId))
    {
      System.out.println("Instructor " + instructorId + " does not exist");
    }
    else if(!courses.containsKey(courseId))
    {
      System.out.println("Course: " + courseId + " does not exist");
    }
  }
  public void register(int courseId, int studentId)
  {
      if(courses.containsKey(courseId) && students.containsKey(studentId))
      {
        courses.get(courseId).addStudent(students.get(studentId));
        students.get(studentId).addCourse(courses.get(courseId));
      }
      else if(!students.containsKey(studentId))
      {
        System.out.println("Student with id: " + studentId + " does not exist");
      }
      else if(!courses.containsKey(courseId))
      {
        System.out.println("Course with id: " + courseId + " does not exist");
      }
  }
  public void putScore(int courseId, int studentId, double score)
  {
      if(courses.containsKey(courseId) && students.containsKey(studentId))
      {
        if(courses.get(courseId).hasStudent(studentId) && students.get(studentId).isRegistered(courseId))
        {
          courses.get(courseId).setStudentScore(studentId, score);
          students.get(studentId).setCourseScore(courseId, score);
        }
        else if(!students.get(studentId).isRegistered(courseId))
        {
          System.out.println("Student " + studentId + " " + students.get(studentId).getName() + " is not enroled in " + courseId);
        }
        else if(!courses.get(courseId).hasStudent(studentId))
        {
          System.out.println("Course does not have student " + studentId);
        }
      }
      else if(!students.containsKey(studentId))
      {
        System.out.println("Student " + studentId + " does not exist");
      }

      else if(!courses.containsKey(courseId))
      {
          System.out.println("Course " + courseId + " does not exist");
      }
    //return true;
  }
  public void addCourse(int courseId, String courseName, int course_capacity, String location)
  {
    Course newCourse = new Course(courseId, courseName, course_capacity, location);
    if(!courses.containsKey(courseId))
      courses.put(courseId, newCourse);
    else
      System.out.println("Course with id " + courseId + " has been added");
  }

  public void courseInfo()
  {
    System.out.println("Number of Courses: " + courses.size());
    for(HashMap.Entry<Integer, Course> entry: courses.entrySet())
    {
      System.out.println(entry.getValue().getCourseNumber() + ": " + entry.getValue().getClassSize() + " enrolled");
    }
  }
  public void courseInfo(int courseId)
  {
    if(courses.containsKey(courseId))
    {

      courses.get(courseId).courseInfo();
    }

  }
  public Instructor getInstructor(int courseId)
  {
    /*
    if(courses.containsKey(courseId))
      return courses.get(courseId).getInstructor();
    return null;
    */

    for(HashMap.Entry<Integer, Instructor> entry : instructors.entrySet())
    {
      if(entry.getValue().hasCourse(courseId))
      {
        return entry.getValue();
      }
    }
    return null;
  }
  public Student getStudent(int studentId)
  {
    if(students.containsKey(studentId))
      return students.get(studentId);
    System.out.println("No student information.");
    return null;
  }
  public void addStudent(int studentId, String studentName)
  {
    Student newStudent = new Student(studentId, studentName);
    if(!students.containsKey(studentId))
      students.put(studentId, newStudent);
  }
  public void addInstructor(int employeeId, String name, String email, String phone_number)
  {
    Instructor newInstrutor = new Instructor(employeeId, name, email, phone_number);
    if(!instructors.containsKey(employeeId))
    {
      instructors.put(employeeId,  newInstrutor);
    }
    else
    {
      System.out.println("Instructor has already been added");
    }
  }
  public Course getCourse(int courseId)
  {
    if(courses.containsKey(courseId))
    {
      return courses.get(courseId);
    }
    return null;
  }

  public boolean unRegister(int courseId, int studentId)
  {

    courses.get(courseId).removeStudent(studentId);
    return true;
  }







}

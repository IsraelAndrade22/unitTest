public class SchoolDemo
{
  public static void main(String[] args)
  {

    School SCD = new School("SCD");
    Course course1;
    System.out.println("===== Read Data =====");
    SCD.readData("file.txt");
    SCD.addInstructor(700, "E. Tao", "tao@csumb.edu", "777-777-1234");
    SCD.addCourse(300, "CST300 – ProSem", 70, "BIT 110");
    SCD.addCourse(499, "CST499 – iOS Dev", 15, "BIT 104");
    SCD.assignInstructor (205, 200);
    SCD.assignInstructor (306, 100);
    SCD.register (306, 7777);
    SCD.register (306, 8888);
    SCD.putScore (306, 7777, 98.54);
    SCD.unRegister (306, 8888);
    System.out.println("\n===== Error Messages =====");
    SCD.addCourse(306, "CST306 – GUI Dev", 25, "BIT 120");
    SCD.putScore (306, 8888, 58.75);
    SCD.register (306, 9999);
    SCD.assignInstructor (499, 900);
    System.out.println("\n===== Detailed Course Info =====");
    SCD.courseInfo(306);
    course1 = SCD.getCourse(205);
    course1.updateLocation("Library 104");
    System.out.println("\n===== Detailed Course Info 2 =====");
    SCD.courseInfo(205);
    System.out.println("\n===== Detailed Course Info 3 =====");
    SCD.courseInfo();
    SCD.deleteCourse(306);
    SCD.deleteCourse(338);
    System.out.println("\n===== Detailed Course Info 4 =====");
    SCD.courseInfo();
    System.out.println("\n===== Good Job! Bye! =====");
/*
     School SCD = new School("SCD");
     System.out.println("===== Read Data 1 =====");
     SCD.readData("file.txt");
     System.out.println("\n===== School Info 1 =====");
     SCD.schoolInfo();
     System.out.println("===== Read Data 2 =====");
     SCD.readData("file2.txt");
     SCD.schoolInfo();
     System.out.println("\n===== Search by email =====");
     SCD.searchByEmail("ybyun@csumb.edu");
     System.out.println("\n===== Search by email (fail) =====");
     SCD.searchByEmail("byun@csumb.edu");
     System.out.println("\n===== End of SchoolDemo1 =====");
*/
/*
      School SCD = new School("SCD");
      Instructor instructor1;
      Student student1;
      System.out.println("===== Read Data =====");
      SCD.readData("file.txt");
      SCD.assignInstructor(306,200);
      SCD.assignInstructor(205,200);
      SCD.addStudent(5555, "Chris Watson");
      SCD.addStudent(9999, "Mike Watson");
      SCD.register(205, 5555);
      SCD.register(205, 7777);
      SCD.register(306, 7777);
      SCD.register(205, 8888);
      SCD.putScore(205, 5555, 50.0);
      SCD.putScore(205, 7777, 100.0);
      SCD.putScore(306, 7777, 100.0);
      SCD.putScore(205, 8888, 50.0);
      System.out.println("\n===== Error Messages =====");
      SCD.register (205, 9999);
      SCD.unRegister (205, 8888);
      System.out.println("\n===== Detailed Course Info 5 =====");
      SCD.courseInfo(205);
      instructor1 = SCD.getInstructor(205);
      System.out.println("\n===== Detailed Instructor Info =====");
      System.out.println(instructor1);
      student1 = SCD.getStudent(7777);
      System.out.println("\n===== Detailed Student Info =====");
      System.out.println(student1);
      SCD.graduateStudent(7777);
      System.out.println("\n===== Detailed Student Info 2 =====");
      System.out.println(SCD.getStudent(7777));
      System.out.println("\n===== Detailed Course Info 6 =====");
      SCD.courseInfo(205);
      System.out.println("\n===== Good Job! Bye! =====");
*/
  }
}

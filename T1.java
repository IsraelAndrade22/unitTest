package project;

public class T1 {
	 public static void main(String[] args)
	  {
	    School SCD = new School("SCD");

	    SCD.readData("/Users/michaelfletes/Documents/eclipseJava/project/src/test1.txt");

	    System.out.println("\n\n===== ANSWER: 1 Instructor (Y. Byun), 1 Course (CST338), 1 Student (Alice Otter) =====\n");
	    //
	    SCD.schoolInfo();
	  }
}

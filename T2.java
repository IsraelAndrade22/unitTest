package project;

public class T2 {
	public static void main(String[] args)
	  {
	    School SCD = new School("SCD");

	    SCD.readData("/Users/michaelfletes/Documents/eclipseJava/project/src/test1.txt");
	    System.out.println("\n\n===== ANSWER: 3 fail messages. One instructor fail, one course fail, one student fail.  =====\n");
	    //
	    SCD.readData("/Users/michaelfletes/Documents/eclipseJava/project/src/test2.txt");
	  }
}

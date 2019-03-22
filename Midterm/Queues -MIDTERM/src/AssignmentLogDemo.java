import java.sql.Date;

/**
 * Demo of priority queue using the java library PQ.
 * Assignments are entered into the PQ and arranged by due date
 * 
 * @author mhrybyk
 *
 */
public class AssignmentLogDemo {

	public static void main(String[] args) {
		AssignmentLogUsingLibraryPQ myHomework = new AssignmentLogUsingLibraryPQ();

		// add a few assignments
		// demos use of different constructors

		myHomework.addProject("CSC211", "Pg 50, Ex 2", Date.valueOf("2019-4-20"));
		myHomework.addProject("CSC210", "Pg 55, Ex 7", Date.valueOf("2019-5-20"));

		Assignment pg75Ex8 = new Assignment("CSC215", "Pg 75, Ex 8", Date.valueOf("2019-3-14"));
		myHomework.addProject(pg75Ex8);

		// note that the next assignment will be the earliest one due 
		
		// show the next assignment, and then remove it. Repeat for all.
		
		showNextAssignment(myHomework);
		myHomework.removeNextProject();
		
		showNextAssignment(myHomework);
		myHomework.removeNextProject();
		
		showNextAssignment(myHomework);
		myHomework.removeNextProject();

		System.out.println("Assignment finished");

		showNextAssignment(myHomework);

	}

	public static void showNextAssignment(AssignmentLogUsingLibraryPQ log) {
		System.out.println("The following assignment is due next:");
		System.out.println(log.getNextProject());
		System.out.println("Number left to be done: " + log.getNumberOfAssignments());
	}
}

import java.sql.Date;

/**
 * An assignment has a course, a task, and a due date.
 * Implements Comparable so that java library PQ can use it to insert
 * @author mhrybyk
 *
 */
public class Assignment implements Comparable<Assignment> {
	
	private String course;
	private String task;
	private Date date;
	
	Assignment(String newCourse, String newTask, Date newDueDate) {
		course = newCourse;
		task = newTask;
		date = newDueDate;
	}
	
	public String getCourseCode() {
		return course;
	}
	
	public int compareTo(Assignment other) {
		return date.compareTo(other.date);
	}

	public String getTask() {
		return task;
	}

	public Date getDueDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "Assignment: " + course + " : " + task + " : " + date;
	}
}

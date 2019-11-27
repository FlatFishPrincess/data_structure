package GraphPackage;

import StackAndQueuePackage.*;

/**
 * A driver that demonstrates the class DirectedGraph and an unweighted graph
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class TopologicalSortDemo {
	private static DirectedGraph<String> myGraph = new DirectedGraph<>();

	private static final String CS1 = "CS1";
	private static final String CS2 = "CS2";
	private static final String CS3 = "CS3";
	private static final String CS4 = "CS4";
	private static final String CS5 = "CS5";
	private static final String CS6 = "CS6";
	private static final String CS7 = "CS7";
	private static final String CS8 = "CS8";
	private static final String CS9 = "CS9";
	private static final String CS10 = "CS10";

	public static void main(String[] args) {

		System.out.println("Testing topological sort of directed, unweighted graph in Figure 29-8:");
		
		setGraph();
		checkVertexAndEdgeCount(10, 11);  // should be 10 vertices, 11 edges
		testEdges();
		testTopSort(); 

		System.out.println("Done.");
	} // end main

	public static void setGraph() {
		setVertices();
		setEdges();
	} // end setGraphFig29_08

	public static void checkVertexAndEdgeCount(int numberOfVertices, int numberOfEdges) {
		System.out.println(
				"\nNumber of vertices = " + myGraph.getNumberOfVertices() + " (should be " + numberOfVertices + ")");
		System.out.println("Number of edges = " + myGraph.getNumberOfEdges() + " (should be " + numberOfEdges + ")");
	} // end checkVertexAndEdgeCount

	public static void testEdges() {
		// Check existing edges
		boolean ok = true;
		ok = checkEdge(CS1, CS2, ok);
		ok = checkEdge(CS2, CS3, ok);
		ok = checkEdge(CS2, CS4, ok);
		ok = checkEdge(CS2, CS5, ok);
		ok = checkEdge(CS4, CS6, ok);
		ok = checkEdge(CS4, CS7, ok);
		ok = checkEdge(CS5, CS10, ok);
		ok = checkEdge(CS6, CS8, ok);
		ok = checkEdge(CS7, CS8, ok);
		ok = checkEdge(CS7, CS9, ok);
		ok = checkEdge(CS9, CS10, ok);

		// Check some non-existing edges
		ok = checkNoEdge(CS1, CS3, ok);
		ok = checkNoEdge(CS1, CS5, ok);
		ok = checkNoEdge(CS4, CS10, ok);

		if (ok)
			System.out.println("Edges are OK.");
		myGraph.displayEdges();
	} // end testEdgesFig29_08

	private static boolean checkEdge(String vertex1, String vertex2, boolean ok) {
		boolean check = ok;
		if (!myGraph.hasEdge(vertex1, vertex2)) {
			System.out.println("hasEdge error " + vertex1 + " " + vertex2);
			check = false;
		} // end if

		return check;
	} // end checkEdge

	private static boolean checkNoEdge(String vertex1, String vertex2, boolean ok) {
		boolean check = ok;
		if (myGraph.hasEdge(vertex1, vertex2)) {
			System.out.println("hasEdge error " + vertex1 + " " + vertex2);
			check = false;
		} // end if

		return check;
	} // end checkNoEdge

	public static void testTopSort() {
		StackInterface<String> sort = myGraph.getTopologicalOrder();
		System.out.println("\n\nTopological order:");
		displayStack(sort);
		System.out.println(" Actual");
		System.out.println("CS1 CS2 CS3 CS4 CS5 CS6 CS7 CS8 CS9 CS10  Expected");
	} // end testTopSort

	public static void setVertices() {
		myGraph.clear();

		myGraph.addVertex(CS1);
		myGraph.addVertex(CS2);
		myGraph.addVertex(CS3);
		myGraph.addVertex(CS4);
		myGraph.addVertex(CS5);
		myGraph.addVertex(CS6);
		myGraph.addVertex(CS7);
		myGraph.addVertex(CS8);
		myGraph.addVertex(CS9);
		myGraph.addVertex(CS10);
	} // end setVerticesFig29_08

	public static void setEdges() {
		myGraph.addEdge(CS1, CS2);

		myGraph.addEdge(CS2, CS3);
		myGraph.addEdge(CS2, CS4);
		myGraph.addEdge(CS2, CS5);

		myGraph.addEdge(CS4, CS6);
		myGraph.addEdge(CS4, CS7);

		myGraph.addEdge(CS5, CS10);

		myGraph.addEdge(CS6, CS8);

		myGraph.addEdge(CS7, CS8);
		myGraph.addEdge(CS7, CS9);

		myGraph.addEdge(CS9, CS10);
	} // end setEdgesFig29_08



	public static void displayStack(StackInterface<String> s) {
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");

		assert (s.isEmpty());
	} // end displayStack

	public static void displayQueue(QueueInterface<String> q) {
		while (!q.isEmpty())
			System.out.print(q.dequeue() + " ");
	} // end displayQueue
} // end DriverDU

/*
 Testing the directed, unweighted graph in Figure 29-10.
 
 Edges exist from the first vertex in each line to the other vertices in the line.
 (Edge weights are given; weights are zero for unweighted graphs):
 
 I F 0.0
 H I 0.0
 G H 0.0
 F C 0.0 H 0.0
 E F 0.0 H 0.0
 D G 0.0
 C B 0.0
 B E 0.0
 A B 0.0 D 0.0 E 0.0
 
 Number of vertices = 9 (should be 9)
 Number of edges = 13 (should be 13)
 Edges are OK.
 -------------------------------------------------------
 
 
 Breadth-First Traversal beginning at vertex A:
 A B D E G F H C I  Actual
 A B D E G F H C I  Expected
 -------------------------------------------------------
 
 
 Depth-First Traversal beginning at vertex A:
 A B E F C H I D G  Actual
 A B E F C H I D G  Expected
 -------------------------------------------------------
 
 Finding the shortest path in the graph in Figure 29-15a:
 
 
 The shortest path from A to B is A B  and has a length of 1.
 Expected path:                   A B
 
 The shortest path from A to C is A E F C  and has a length of 3.
 Expected path:                   A E F C
 
 The shortest path from A to D is A D  and has a length of 1.
 Expected path:                   A D
 
 The shortest path from A to E is A E  and has a length of 1.
 Expected path:                   A E
 
 The shortest path from A to F is A E F  and has a length of 2.
 Expected path:                   A E F
 
 The shortest path from A to G is A D G  and has a length of 2.
 Expected path:                   A D G
 
 The shortest path from A to H is A E H  and has a length of 2.
 Expected path:                   A E H
 
 The shortest path from A to I is A E H I  and has a length of 3.
 Expected path:                   A E H I
 -------------------------------------------------------
 
 Testing topological sort of directed, unweighted graph in Figure 29-8:
 
 Edges exist from the first vertex in each line to the other vertices in the line.
 (Edge weights are given; weights are zero for unweighted graphs):
 
 CS10
 CS9 CS10 0.0
 CS8
 CS7 CS8 0.0 CS9 0.0
 CS6 CS8 0.0
 CS5 CS10 0.0
 CS4 CS6 0.0 CS7 0.0
 CS3
 CS2 CS3 0.0 CS4 0.0 CS5 0.0
 CS1 CS2 0.0
 
 Number of vertices = 10 (should be 10)
 Number of edges = 11 (should be 11)
 hasEdge error H I
 
 Edges exist from the first vertex in each line to the other vertices in the line.
 (Edge weights are given; weights are zero for unweighted graphs):
 
 CS10
 CS9 CS10 0.0
 CS8
 CS7 CS8 0.0 CS9 0.0
 CS6 CS8 0.0
 CS5 CS10 0.0
 CS4 CS6 0.0 CS7 0.0
 CS3
 CS2 CS3 0.0 CS4 0.0 CS5 0.0
 CS1 CS2 0.0
 
 
 Topological order:
 CS1 CS2 CS3 CS4 CS5 CS6 CS7 CS8 CS9 CS10  Actual
 CS1 CS2 CS3 CS4 CS5 CS6 CS7 CS8 CS9 CS10  Expected
 Done.
*/

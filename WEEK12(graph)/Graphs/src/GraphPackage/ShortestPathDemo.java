package GraphPackage;

import StackAndQueuePackage.*;

/**
 * A driver that demonstrates the class DirectedGraph and an unweighted graph with shortest path
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class ShortestPathDemo {
	private static DirectedGraph<String> myGraph = new DirectedGraph<>();
	private static StackInterface<String> path = new LinkedStack<>();
	private static final String A = "A";
	private static final String B = "B";
	private static final String C = "C";
	private static final String D = "D";
	private static final String E = "E";
	private static final String F = "F";
	private static final String G = "G";
	private static final String H = "H";
	private static final String I = "I";


	public static void main(String[] args) {
		System.out.println("Testing the directed, unweighted graph in Figure 29-10.");
		setGraph();
		myGraph.displayEdges();
		checkVertexAndEdgeCount(9, 13);
		testEdges();
		System.out.println("-------------------------------------------------------");

		testBFS(A);
		System.out.println("A B D E G F H C I  Expected");
		System.out.println("-------------------------------------------------------");

		testDFS(A);
		System.out.println("A B E F C H I D G  Expected");
		System.out.println("-------------------------------------------------------");

		testShortestPath(); // show all shortest paths from A
		System.out.println("-------------------------------------------------------");


		System.out.println("Done.");
	} // end main

	public static void setGraph() {
		setVertices(); // Graph cleared before setting vertices
		setEdges();
	}

	public static void checkVertexAndEdgeCount(int numberOfVertices, int numberOfEdges) {
		System.out.println(
				"Checking Number of vertices = " + myGraph.getNumberOfVertices() + " (should be " + numberOfVertices + ")");
		System.out.println("Checking Number of edges = " + myGraph.getNumberOfEdges() + " (should be " + numberOfEdges + ")");
	} // end checkVertexAndEdgeCount

	public static void testEdges() {
		// Check existing edges
		boolean ok = true;
		ok = checkEdge(A, B, ok);
		ok = checkEdge(A, D, ok);
		ok = checkEdge(A, E, ok);
		ok = checkEdge(B, E, ok);
		ok = checkEdge(C, B, ok);
		ok = checkEdge(D, G, ok);
		ok = checkEdge(E, F, ok);
		ok = checkEdge(E, H, ok);
		ok = checkEdge(F, C, ok);
		ok = checkEdge(F, H, ok);
		ok = checkEdge(G, H, ok);
		ok = checkEdge(H, I, ok);

		// Check some non-existing edges
		ok = checkNoEdge(A, I, ok);
		ok = checkNoEdge(C, E, ok);
		ok = checkNoEdge(C, F, ok);

		if (ok)
			System.out.println("Edges are OK.");
	} // end testEdgesFig29_10


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

	public static void testBFS(String v) {
		System.out.println("Breadth-First Traversal beginning at vertex " + v + ": ");
		QueueInterface<String> bfs = myGraph.getBreadthFirstTraversal(v);

		displayQueue(bfs);
		System.out.println(" Actual");
	} // end testBFS

	public static void testDFS(String v) {
		System.out.println("Depth-First Traversal beginning at vertex " + v + ": ");
		QueueInterface<String> dfs = myGraph.getDepthFirstTraversal(v);

		displayQueue(dfs);
		System.out.println(" Actual");
	} // end testDFS

	public static void testShortestPath() {
		// UNWEIGHTED graph in Figure 29-15a (same as Fig. 29-10)
		
		System.out.println("Showing shortest path to every vertex from A");
		showPath(A, B, "A B");
		showPath(A, C, "A E F C");
		showPath(A, D, "A D");
		showPath(A, E, "A E");
		showPath(A, F, "A E F");
		showPath(A, G, "A D G");
		showPath(A, H, "A E H");
		showPath(A, I, "A E H I");
	} // end testShortestPath

	private static void showPath(String startVertex, String endVertex, String expectedPath) {

		int length = myGraph.getShortestPath(startVertex, endVertex, path);
		System.out.print("The shortest path from " + startVertex + " to " + endVertex + " is ");
		displayStack(path);
		System.out.println("Expected (" + expectedPath + "), length = " + length);

	} // end showPath


	/**
	 * Add all the vertices to the graph
	 */
	public static void setVertices() {
		myGraph.clear();

		myGraph.addVertex(A);
		myGraph.addVertex(B);
		myGraph.addVertex(C);
		myGraph.addVertex(D);
		myGraph.addVertex(E);
		myGraph.addVertex(F);
		myGraph.addVertex(G);
		myGraph.addVertex(H);
		myGraph.addVertex(I);
	} // end setVerticesFig29_10

	/**
	 * Now add all of the edges
	 */
	public static void setEdges() {
		System.out.println("Adding edges");
		System.out.println("Adding A -> BDE");
		myGraph.addEdge(A, B);
		myGraph.addEdge(A, D);
		myGraph.addEdge(A, E);

		System.out.println("Adding B -> E");
		myGraph.addEdge(B, E);

		System.out.println("Adding C -> B");
		myGraph.addEdge(C, B);

		System.out.println("Adding D - > G");
		myGraph.addEdge(D, G);

		System.out.println("Adding E -> FH");
		myGraph.addEdge(E, F);
		myGraph.addEdge(E, H);

		System.out.println("Adding F -> CH");
		myGraph.addEdge(F, C);
		myGraph.addEdge(F, H);

		System.out.println("Adding G -> H");
		myGraph.addEdge(G, H);

		System.out.println("Adding H -> I");
		myGraph.addEdge(H, I);

		System.out.println("Adding I -> F");
		myGraph.addEdge(I, F);

/* Since additions are made to the end of each edge list, 
   these lists appear as follows:
		A: B -> D -> E
		B: E
		C: B
		D: G
		E: F -> H
		F: C -> H
		G: H
		H: I
		I: F
   We can predict the BFS and DFS traversals knowing this. */
	} // end setEdgesFig29_10

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
Adding edges
Adding A -> BDE
Adding B -> E
Adding C -> B
Adding D - > G
Adding E -> FH
Adding F -> CH
Adding G -> H
Adding H -> I
Adding I -> F
DirectedGraph.displayEdges(): Edges exist from the first vertex in each line to the other vertices in the line.
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
Checking Number of vertices = 9 (should be 9)
Checking Number of edges = 13 (should be 13)
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
Showing shortest path to every vertex from A
The shortest path from A to B is A B Expected (A B), length = 1
The shortest path from A to C is A E F C Expected (A E F C), length = 3
The shortest path from A to D is A D Expected (A D), length = 1
The shortest path from A to E is A E Expected (A E), length = 1
The shortest path from A to F is A E F Expected (A E F), length = 2
The shortest path from A to G is A D G Expected (A D G), length = 2
The shortest path from A to H is A E H Expected (A E H), length = 2
The shortest path from A to I is A E H I Expected (A E H I), length = 3
-------------------------------------------------------
Done.

*/

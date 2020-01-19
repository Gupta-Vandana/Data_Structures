import java.util.HashMap;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Boolean> processed = new HashMap<>();
		graph g = new graph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");

		g.addEdge("a", "b", 10);
		g.addEdge("a", "d", 40);
		g.addEdge("b", "c", 10);
		g.addEdge("d", "e", 2);
		g.addEdge("d", "c", 10);
		g.addEdge("e", "f", 3);
		g.addEdge("e", "g", 8);
		g.addEdge("f", "g", 3);

		g.display();
		// System.out.println(g.hasPath("a", "g", processed));
		g.printPath("b", "g", processed, " ");
	}

}

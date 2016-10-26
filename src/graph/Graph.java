package graph;

import java.util.*;


//This class represents a directed graph using adjacency list
//representation
public class Graph
{
	private Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();

	public void addEdge(Integer src, Integer dest) {
		List<Integer> srcNeighbors = this.edges.get(src);
		if (srcNeighbors == null) {
			this.edges.put(src,
					srcNeighbors = new ArrayList<Integer>()
					);
		}
		srcNeighbors.add(dest);
	}

	//returns minimumDistance using BFS traversal from a given source 
	int minimumDistance(int startingVertex, int destination) {
		Map<Integer,Integer> visited = new HashMap<Integer,Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		// Mark the current node as visited and enqueue it
		queue.add(startingVertex);
		visited.put(startingVertex,1);
		int distance = 1;
		while (queue.size()!=0)
		{
			// Dequeue a vertex from queue and print it
			int src = queue.remove();
			List<Integer> srcNeighbors = this.edges.get(src);
			distance = distance + 1;
			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it  
			for(int next : srcNeighbors)
			{
				// If this adjacent node is the destination node,
				// then return the distance stored.
				if (next==destination) {
					return visited.get(src);
				}

				// Else, continue to do BFS
				else if (!visited.containsKey(next))
				{
					visited.put(next,distance);
					queue.add(next);
				}
			}
		}

		// If BFS is complete without visited d
		return 0;
	}

	// Driver method
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		Graph g = new Graph();
		String line = "";
		while (!((line = scanner.nextLine()).isEmpty())) {
			List<Integer> list = new ArrayList<Integer>();
			for (String s : line.split("\\s")) 
				  list.add(Integer.parseInt(s));
			int src = list.get(0);
			for(int i = 1; i < list.size(); i++) {
				g.addEdge(src, list.get(i));
			}
		}
		
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			List<Integer> list = new ArrayList<Integer>();
			for (String s : line.split("\\s")) 
				  list.add(Integer.parseInt(s));
			int src = list.get(0);
			int dest = list.get(1);
			int distance = g.minimumDistance(src, dest);
			System.out.println(distance);

	}
		scanner.close();

	}
}
import java.util.*;
import java.io.*;

class GraphNode{
	int vertex, edge;
	LinkedList<Integer> []adjacencyList;
	
	// constructor
	public GraphNode(int vertex) {
		// TODO Auto-generated constructor stub
		this.vertex = vertex;
		 adjacencyList = new LinkedList[vertex];
		 for(int i=0; i<vertex; ++i) {
			 adjacencyList[i] = new LinkedList<Integer>();
		 }
	}
		 
		 
	// add new edge 
	 void addEdge(int vertex, int edge) {
		adjacencyList[vertex].add(edge); 
	 }
	 
	 
	 // function for breadth first search
	 void BFS(int s) {
		 // Marks all vertices not-visited
		 boolean visited[] = new boolean[vertex];
		 // create queue
		 LinkedList<Integer> Queue = new LinkedList<Integer>();
		 
		 visited[s] = true;
		 Queue.add(s);
		 while(Queue.size() != 0) {
			 // dequeue a vertex from queue and print it
			 s = Queue.poll();
			 System.out.print(s +" ");
			 
			 // get all adjacent vertices and check if they are visited
			 Iterator<Integer> i = adjacencyList[s].listIterator();
			 while(i.hasNext()) {
				 int n = i.next();
				 if(!visited[n]) {
					 visited[n] = true;
					 Queue.add(n);
				 }
			 }
		 }
	 }
	 
	 // function for Depth first search
	 void DFSRecurr(int vertex, boolean visited[]) {
		 // mark all vertices unvisited
		 visited[vertex] = true;
		 System.out.print(vertex + " ");
		 
		 Iterator<Integer> i = adjacencyList[vertex].listIterator();
		 while(i.hasNext()) {
			 int n = i.next();
			 if(!visited[n]) {
				 DFSRecurr(n, visited);
			 }
		 }
	 }
	 
	void DFS() {
		boolean visited[] = new boolean[vertex];
		for (int i = 0; i < vertex; ++i)
            if (visited[i] == false)
                DFSRecurr(i, visited);
	}
	 
	 
}
	

// Main
public class Assignment_0_graph {
	public static void main(String args[]) {
		
		GraphNode g = new GraphNode(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("\n\t\tGraph Traversals\n\n");
		
        System.out.println("Breadth first travarsal is: ");
        g.BFS(2);
        
        System.out.println("\n\nDepth First Traversal is: ");
        g.DFS();
	}

}
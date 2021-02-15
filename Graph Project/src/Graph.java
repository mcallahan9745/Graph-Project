/* 
 * Graph.java
 * 
 * Class: Graph
 * Author: Miriam Callahan
 * Creation Date: March 18th, 2018
 * 
 * This class creates a Graph object that is made up of vertices and edges that are stored in an adjacency matrix.
 * Both weighted and unweighted graphs can be created with the following class.
 */
public class Graph 
{
	private Vertex vertexArray[];
	private int adjMatrix [][];
//----------------------------------------------------------------------
//	This constructor creates an array representing the number of points on the graph and an adjacency matrix to determine
//  where edges will be. In the adjacency matrix, all int values are defaulted to 0, signifying that there is no edge.
// 	Parameters: An int representing the number of vertices
//  Returns: N/A
//----------------------------------------------------------------------
	public Graph(int numOfVertices)
	{
		vertexArray = new Vertex[numOfVertices];
		adjMatrix = new int [numOfVertices][numOfVertices];
	}
//----------------------------------------------------------------------
//  This method creates a non-weighted one way edge.
// 	Parameters: Ints representing the vertices from and to which the edge is created
//  Returns: N/A
//----------------------------------------------------------------------
	public void addDirectedEdge(int fromVertex, int toVertex)
	{
		adjMatrix[fromVertex][toVertex] = 1;
	}
//----------------------------------------------------------------------
//	This method creates a non-weighted two way edge.
// 	Parameters: Ints representing the vertices from/to which the edge is created
//  Returns: N/A
//----------------------------------------------------------------------
	public void addEdge(int v1, int v2)
	{
		adjMatrix[v1][v2] = 1;
		adjMatrix[v2][v1] = 1;
	}
//----------------------------------------------------------------------
//	This method creates an undirected two way edge from two vertices and assigns a weight to it.
// 	Parameters: Ints representing the vertices of the edges and the weight
//  Returns: N/A
//----------------------------------------------------------------------
	public void addEdgeWithWeight (int v1, int v2, int weight)
	{
		adjMatrix[v1][v2] = weight;
		adjMatrix[v2][v1] = weight;
	}
//----------------------------------------------------------------------
//	This method creates a "directed" (one way) edge from two vertices and assigns a weight to it.
//  It assumes that the user will only create unique edges.
// 	Parameters: Ints representing the vertex from which an edge is made, to which the edge is made
//  and the weight
//  Returns: N/A
//----------------------------------------------------------------------
	public void addDirectedEdgeWithWeight (int fromVertex, int toVertex, int weight)
	{
		adjMatrix[fromVertex][toVertex] = weight;
	}
//----------------------------------------------------------------------
//	This method allows the user to name a particular vertex and place it in the vertex array.
// 	Parameters: A string representing the vertex name and an int representing its' index in the array
//  Returns: N/A
//----------------------------------------------------------------------
	public void setVertexName (int vertexIndex, String name)
	{
		Vertex toAdd = new Vertex(name);
		vertexArray[vertexIndex] = toAdd;
	}
//----------------------------------------------------------------------
//	A method which sets all the vertices in the vertex array to unvisited so that they can be used with
//  the search methods.
// 	Parameters: N/A
//  Returns: N/A
//----------------------------------------------------------------------
	private void setAllUnvisited()
	{
		for (int i = 0; i < vertexArray.length; i++)
			vertexArray[i].setUnvisited();
	}
//----------------------------------------------------------------------
//	Based on breadth first search, this method prints out the path length of each vertex from a given start.
// 	Parameters: An int representing the start vertex
//  Returns: N/A
//----------------------------------------------------------------------
	public void shortestPath (int v)
	{
		System.out.println("Shortest path from: " + vertexArray[v].getName() + " " + v);
		setAllUnvisited();
		Queue queue = new Queue();
		queue.enqueue(v);
		vertexArray[v].setWaiting();
		int[] pathLength = new int[vertexArray.length];
		int count = 1;
		while (!queue.empty())
		{
			int dqV = queue.dequeue();
			vertexArray[dqV].setVisited();
			for (int j = 0; j < adjMatrix.length; j++)
			{
					if (adjMatrix[dqV][j] != 0 && vertexArray[j].isUnvisited())
					{
						vertexArray[j].setWaiting();
						queue.enqueue(j);
						pathLength[j] = count;
					}
			}
			count++;
		}
		for (int n = 0; n < pathLength.length; n++)
			System.out.println("Shortest path from " + vertexArray[v].getName() + " " + v  + " to " + vertexArray[n].getName() + " " + n + " is " + pathLength[n]);
	}
//----------------------------------------------------------------------
//	Depth first search is a search algorithm based on traversing the graph along paths from a given starting index.
//  Once the method reaches the end of a particular path, it backtracks to find a new path to go down.
// 	Parameters: An int representing the start vertex
//  Returns: N/A
//----------------------------------------------------------------------
	public String depthFirstSearch(int startVertex)
	{
		String dfsOrder = "";
		setAllUnvisited();
		Stack myStack = new Stack();
		myStack.push(startVertex);
		dfsOrder = vertexArray[startVertex].getName() + " " + startVertex + ", ";
		vertexArray[startVertex].setVisited();
		while (!myStack.empty())
		{
			for (int k = 0; k < adjMatrix.length; k++) {
				int peekedVertex = myStack.peek();
				if ((adjMatrix[peekedVertex][k] != 0) && (vertexArray[k].isUnvisited()))
				{
					
					myStack.push(k);
					dfsOrder += (vertexArray[k].getName() + " " + k + ", ");
					vertexArray[k].setVisited();
				}
				else if (k == adjMatrix.length - 1)
					myStack.pop();
			}
		}
		return dfsOrder;
	} 
//----------------------------------------------------------------------
//	This breadth first search method returns the vertices on the graph in order. 
// 	Parameters: An int representing the start vertex
//  Returns: A string with the order of vertices based on level
//----------------------------------------------------------------------
	public String breadthFirstSearch(int startVertex)
	{
		String bfsOrder = "";
		setAllUnvisited();
		Queue queue = new Queue();
		queue.enqueue(startVertex);
		vertexArray[startVertex].setWaiting(); 
		while (!queue.empty())
		{
			int dqV = queue.dequeue();
			bfsOrder += vertexArray[dqV].getName() + " " + dqV + ", ";
			vertexArray[dqV].setVisited();
			for (int j = 0; j < adjMatrix.length; j++) 
					if (adjMatrix[dqV][j] != 0 && vertexArray[j].isUnvisited())
					{
						vertexArray[j].setWaiting();
						queue.enqueue(j);
					}
		}
		return bfsOrder;
	}
}


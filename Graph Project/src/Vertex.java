/*
 * Vertex.java
 * 
 * Class: Vertex.java
 * Author: CS206 Class
 * Creation Date: April 11th, 2018
 * 
 * This class represents a vertex point on a graph. Each vertex is assigned a name and a flag value to determine whether
 * or not it was visited in a search. Methods have been added to this class.
 */
public class Vertex 
{
	private String name;
	private FlagValue flag;
//----------------------------------------------------------------------
// 	A constructor which creates a vertex object. The string n represents the name of the vertex.
//	Parameters: A string n which is assigned to the instance variable name
//	Returns: N/A
//----------------------------------------------------------------------
	public Vertex(String n)
	{
		name = n;
		flag = FlagValue.UNVISITED;
	}
//----------------------------------------------------------------------
// 	This getter method returns the name of a specified vertex.
//	Parameters: N/A
//	Returns: A string which represents the vertex name
//----------------------------------------------------------------------
	public String getName()
	{
		return name;
	}
//----------------------------------------------------------------------
// 	This setter method changes the name of a specified vertex.
//	Parameters: A string n which will become the new name
//	Returns: N/A
//----------------------------------------------------------------------
	public void setName(String n)
	{
		name = n;
	}
//----------------------------------------------------------------------
// 	A getter method which returns the flag value of a vertex.
//	Parameters: N/A
//	Returns: A flag value (VISITED, WAITING, UNVISITED)
//----------------------------------------------------------------------
	public FlagValue getFlag()
	{
		return flag;
	}
//----------------------------------------------------------------------
// 	This setter method changes the flag value of a vertex to visited.
//	Parameters: N/A
//	Returns: N/A
//----------------------------------------------------------------------
	public void setVisited()
	{
		flag = FlagValue.VISITED;
	}
//----------------------------------------------------------------------
// 	This setter method changes the flag value to waiting.
//	Parameters: N/A
//	Returns: N/A
//----------------------------------------------------------------------
	public void setWaiting()
	{
		flag = FlagValue.WAITING;
	}
//----------------------------------------------------------------------
// 	This setter method changes the flag value to unvisited.
//	Parameters: N/A
//	Returns: N/A
//----------------------------------------------------------------------
	public void setUnvisited()
	{
		flag = FlagValue.UNVISITED;
	}
//----------------------------------------------------------------------
// 	This method determines whether or not a vertex was visited.
//	Parameters: N/A
//	Returns: A boolean value determining if a vertex is unvisited.
//----------------------------------------------------------------------
	public boolean isUnvisited()
	{
		return flag == FlagValue.UNVISITED;
	}
//----------------------------------------------------------------------
// 	This method determines whether or not a vertex is waiting.
//	Parameters: N/A
//	Returns: A boolean value determining if a vertex is waiting.
//----------------------------------------------------------------------
	public boolean isWaiting()
	{
		return flag == FlagValue.WAITING;
	}
}
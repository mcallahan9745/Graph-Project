/* 
 * Queue.java
 * 
 * Class: Queue
 * Author: CS206 Class
 * Creation Date: March 26th, 2018
 * 
 * This class represents a basic queue which is created from a doubly linked list. It was started in class.
 */
public class Queue 
{
private DLL<Integer> q;
//----------------------------------------------------------------------
// 	A constructor which creates a queue of a DLL which is empty. Other nodes will be added to form the doubly linked
// list as other nodes are enqueued.
//	Parameters: N/A
//	Returns: N/A
//----------------------------------------------------------------------
	public Queue()
	{
		q = new DLL<Integer>();
	}
//----------------------------------------------------------------------
//	This enqueue method adds items to the end of the queue.
// 	Parameters: An int num referencing the index of a specific vertex in vertexArray
//  Returns: N/A
//----------------------------------------------------------------------
	public void enqueue(int num)
	{
		q.addToBeginning(num);
	}
//----------------------------------------------------------------------
// This peek method reveals which vertex is next to be dequeued.
// Parameters: N/A
// Returns: An int representing the next vertex to be dequeued.
//----------------------------------------------------------------------		
	public int dequeue()
	{
		return q.removeFromEnd();
	}
//----------------------------------------------------------------------
//	A method which checks if the queue is empty. 
// 	Parameters: N/A
//  Returns: A boolean value representing whether or not the queue is empty.
//----------------------------------------------------------------------	
	public boolean empty()
	{
		return q.isEmpty();
	}
	public boolean contains(int num)
	{
		return q.isFound(num);
	}
}
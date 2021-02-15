/* 
 * DLLNode.java
 * 
 * Class: DLLNode
 * Author: CS206 Class
 * Creation Date: March 28th, 2018
 * 
 * This class represents a doubly linked list node which can then be used to create a list of DLL nodes.
 */
public class DLLNode <T>
{
	private T data;
	public DLLNode<T> next;
	public DLLNode<T> prev;
//----------------------------------------------------------------------
// 	A constructor which creates a DLL Node which solely contains data. Other nodes will be added to create a doubly linked
// 	list to which the node created will have references.
//	Parameters: The data to be entered
//	Returns: N/A
//----------------------------------------------------------------------	
	public DLLNode(T d)
	{
		data = d;
		next = null;
		prev = null;
	}
//----------------------------------------------------------------------
// 	A method which returns the data in a particular node.
//	Parameters: N/A
//	Returns: The data in the node
//----------------------------------------------------------------------
	public T getData()
	{
		return data;
	}
}
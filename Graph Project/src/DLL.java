/* 
 * DLL.java
 * 
 * Class: DLL
 * Author: CS206 Class
 * Creation Date: March 28th, 2018
 * 
 * This class represents a doubly linked list created with a reference to a head and tail node to traverse the list. 
 * All other values in the list need to be accessed through the head and/or tail nodes. Methods have been added to this class.
 */
public class DLL<T> {
	private DLLNode<T> head;
	private DLLNode<T> tail;
//----------------------------------------------------------------------
// 	A constructor which creates a queue of a DLL Node which is empty. Other nodes will be added to create a doubly linked
// 	list as other nodes are enqueued.
//	Parameters: N/A
//	Returns: N/A
//----------------------------------------------------------------------
	public DLL()
	{
		head = null;
		tail = null;
	}
//----------------------------------------------------------------------
// 	A getter method which returns the data stored in the head.
//	Parameters: N/A
//	Returns: the data stored in head
//----------------------------------------------------------------------
	public T getHead()
	{
		return head.getData();
	}
//----------------------------------------------------------------------
// 	A method which tests whether or not the list is empty.
//	Parameters: N/A
//	Returns: A boolean value which states whether or not head is null.
//----------------------------------------------------------------------
	public boolean isEmpty()
	{
		return head == null;
	}
//----------------------------------------------------------------------
// 	This removes the DLLNode at the beginning of the list. It assumes that the list is not empty.
//	Parameters: N/A
//	Returns: The node that was removed
//----------------------------------------------------------------------
	public DLLNode<T> removeFromBeginning()
	{
		DLLNode<T> toRemove = head;
		if (head.next == null)
			head = null;
		else
		{
			head = head.next;
			head.prev = null;
		}
		return toRemove;	
	}
//----------------------------------------------------------------------
// 	This removes the DLLNode at the end of the list.
//	Parameters: N/A
//	Returns: The node that was removed
//----------------------------------------------------------------------
	public T removeFromEnd()
	{
		T returnVal = tail.getData();
		tail = tail.prev;
		if (tail != null)
			tail.next = null;
		else
			head = null;
		return returnVal;
	}
//----------------------------------------------------------------------
// 	This adds a node to the beginning of the list.
//	Parameters: The data which is to be added to the new node
//	Returns: N/A
//----------------------------------------------------------------------	
	public void addToBeginning(T d)
	{
		DLLNode<T> nodeToAdd = new DLLNode<T>(d);
		
		if (isEmpty())
		{
			head = nodeToAdd;
			tail = head;
		}
		else
		{
			nodeToAdd.next = head;
			head.prev = nodeToAdd;
			head = nodeToAdd;
		}
	}
//----------------------------------------------------------------------
// 	This adds a node to the end of the list.
//	Parameters: The data to be added to the node
//	Returns: N/A
//----------------------------------------------------------------------
	public void addToEnd(T d)
	{
		DLLNode<T> nodeToAdd = new DLLNode<T>(d);
		
		if (isEmpty())
		{
			head = nodeToAdd;
			tail = head;
		}
		else
		{
			tail.next = nodeToAdd;
			nodeToAdd.prev = tail;
			tail = nodeToAdd;
		}
	}
//----------------------------------------------------------------------
// 	This delete method removes a particular node from the list.
//	Parameters: The data in the node to be deleted
//	Returns: A boolean determining whether or not the data could be deleted (if it was in the list)
//----------------------------------------------------------------------
	public boolean delete(T dataToDelete)
	{
		DLLNode<T> nodeToDelete = search(dataToDelete);
		if (nodeToDelete == null)
			return false;
		if ((nodeToDelete == head) && (nodeToDelete == tail))
		{
			head = null;
			tail = null;
		}
		else
		{
			if (nodeToDelete == head)
			{
				head = head.next;
				head.prev = null;
			}
			else
			{
				if (nodeToDelete == tail)
				{
					tail = tail.prev;
					tail.next = null;
				}
				else
				{
					nodeToDelete.prev.next = nodeToDelete.next;
					nodeToDelete.next.prev = nodeToDelete.prev;
				}
			}
		}	
		
		return true;
	}
//----------------------------------------------------------------------
// 	This method searches for a particular node in the list.
//	Parameters: The data in the node we are searching for
//	Returns: The node with the data in it
//----------------------------------------------------------------------
	public DLLNode<T> search(T lookFor)
	{
		DLLNode<T> temp = head;
		while (temp != null)
		{	
			if (temp.getData().equals(lookFor))
				return temp; 
			temp = temp.next;
		}
		return null; 
	}
//----------------------------------------------------------------------
// 	Determines whether or not a given piece of data exists in the list.
//	Parameters: The data to look for
//	Returns: A boolean value determining if a certain piece of data is in the list
//----------------------------------------------------------------------
	public boolean isFound(T lookFor)
	{
		return search(lookFor) == null;
	}
//----------------------------------------------------------------------
// 	This toString() method returns the DLL starting at head.
//	Parameters: N/A
//	Returns: the DLL list
//----------------------------------------------------------------------	
	public String toString()
	{
		String listStr = "";
		
		DLLNode<T> temp = head;
		while (temp != null)
		{
			listStr += temp.getData().toString() + "\n";
			temp = temp.next;
		}

		return listStr;
	}
//----------------------------------------------------------------------
// 	This toString() method returns the DLL starting at tail.
//	Parameters: N/A
//	Returns: the DLL list
//----------------------------------------------------------------------
	public String toStringReverse()
	{
		String listStr = "";
		
		DLLNode<T> temp = tail;
		while (temp != null)
		{
			listStr += temp.getData().toString() + "\n";
			temp = temp.prev;
		}

		return listStr;
	}
//----------------------------------------------------------------------
// 	This returns the data in the node at the end of the list.
//	Parameters: N/A
//	Returns: Data at the end of the list
//----------------------------------------------------------------------
	public T getEnd()
	{
		return tail.getData();
	}
}


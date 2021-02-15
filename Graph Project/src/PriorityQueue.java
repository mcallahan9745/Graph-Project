/*
 * PriorityQueue.java
 * 
 * Class: PriorityQueue
 * Author: CS206 Class
 * Creation Date: April 19th, 2018
 * 
 * This class represents a priority queue stored as an array of doubly linked lists. It is a minimum priority heap, so the
 * value with the minimum int priority is dequeued first.
 */
public class PriorityQueue 
{
	public static final int MAXIMUM_PRIORITY = 30;
	private DLL <Integer> pq[];
	private int lowestCurrentPriority; // the priority of the highest priority item
	private int currentSize; // # of elements currently in the pq
//----------------------------------------------------------------------
//	A constructor which creates a priority queue of DLL Nodes which are all empty.
// 	Parameters: N/A
//  Returns: N/A
//----------------------------------------------------------------------
	public PriorityQueue()
	{
		currentSize = 0;
		lowestCurrentPriority = Integer.MAX_VALUE;
		pq = new DLL[MAXIMUM_PRIORITY + 1];
		for (int i = 0; i < pq.length; i++)
		{
			pq[i] = new DLL();
		}
	}
//----------------------------------------------------------------------
//	A method which returns the current size of the priority queue
// 	Parameters: N/A
//  Returns: An int representing the current size
//----------------------------------------------------------------------
	public int size()
	{
		return currentSize;
	}	
//----------------------------------------------------------------------
//	This enqueue method adds items to the end of the priority list.
// 	Parameters: An int item referencing the index of a specific vertex in vertexArray and an int representing its' priority
//  Returns: N/A
//----------------------------------------------------------------------
	public void enqueue(int item, int priority)
	{
		pq[priority].addToBeginning(item);
		if (priority < lowestCurrentPriority)
		{
			lowestCurrentPriority = priority;
		}
		currentSize++;
	}
//----------------------------------------------------------------------
//	This dequeue method removes an item from the priority list with the lowest priority value.
// 	Parameters: N/A
//  Returns: An int representing the vertex that was dequeued
//----------------------------------------------------------------------
	public int dequeue()
	{
		int dequeued = 0;
	
		if (empty())
		{
			dequeued = 0;
		}
		else
		{
			dequeued = (int) pq[lowestCurrentPriority].getHead();
			currentSize--;
			if (currentSize > 0)
			{
				while (pq[lowestCurrentPriority].isEmpty())
					lowestCurrentPriority++;
			}
			else
			{
				lowestCurrentPriority = Integer.MAX_VALUE;
			}
		}
		return dequeued;
	} 
//----------------------------------------------------------------------
//	This peek method reveals which vertex is next to be dequeued.
// 	Parameters: N/A
//  Returns: An int representing the next vertex to be dequeued.
//----------------------------------------------------------------------
	public int peek()
	{
		return (int) pq[lowestCurrentPriority].getHead();
	}
//----------------------------------------------------------------------
//	A method which checks if the priority queue is empty. 
// 	Parameters: N/A
//  Returns: A boolean value representing whether or not the queue is empty.
//----------------------------------------------------------------------	
	public boolean empty()
	{
		return currentSize == 0;
	}
}
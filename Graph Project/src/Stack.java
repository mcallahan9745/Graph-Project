/* 
 * Stack.java
 * 
 * Class: Stack
 * Author: CS206 Class
 * Creation Date: March 23rd, 2018
 * 
 * This class represents the stack data structure and is based off of the StackOfInts structure created in class. 
 * The index top represents the top of the stack where top is the index to push to and top - 1 is the index to pop from.
 */
public class Stack 
{
	private int stack[];
	private int top; 
//----------------------------------------------------------------------
// 	A constructor which creates a stack of 1000 possible elements. Since it is empty, top is set to 0.
//	Parameters: N/A
//	Returns: N/A
//----------------------------------------------------------------------	
	public Stack()
	{
		stack = new int[1000];
		top = 0;
	}
//----------------------------------------------------------------------
// 	A method which returns whether or not the stack is empty.
//	Parameters: N/A
//	Returns: A boolean value determining whether or not the stack is empty
//----------------------------------------------------------------------
	public boolean empty()
	{
		return top == 0;
	}
//----------------------------------------------------------------------
// 	A method which returns the size of the stack.
//	Parameters: N/A
//	Returns: The top value which is equivalent to the size
//----------------------------------------------------------------------
	public int size()
	{
		return top;
	}
//----------------------------------------------------------------------
// 	A method which pushes the data to the top of the stack.
//	Parameters: The int to be pushed
//	Returns: N/A
//----------------------------------------------------------------------
	public void push(int thingToPush)
	{
		stack[top++] = thingToPush;
	}
//----------------------------------------------------------------------
// 	A method which deletes the topmost member of the stack.
//	Parameters: N/A
//	Returns: The deleted data
//----------------------------------------------------------------------
	public int pop()
	{
		return stack[--top];
	}
//----------------------------------------------------------------------
// 	A method which returns the the next stack value that could be deleted.
//	Parameters: N/A
//	Returns: An int representing the data at the top of the stack
//----------------------------------------------------------------------
	public int peek()
	{
		return stack[top - 1];
	}
}

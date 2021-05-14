import java.util.*;

/**
   This class implements a pile of objects by using an array.
   @author Jeremy Hill
   @version 12.0.2
 */
public class PileOfBooks<T> implements PileInterface<T> 
{
	private int top = -1;              //holds the index of the top of pile 
	private int capacity;			   //holds the pile's current capacity
	private T[] pile;                  //holds the array of strings ("books")
	private final int DEFAULT_CAPACITY = 50;  //holds default capacity
	private final int MAX_CAPACITY = 1000;     //holds maximum capacity

	/**
	 * Constructor to create a new pile of books of default length.
	 */
	public PileOfBooks()
	{
		//suppress the unchecked warning
		@SuppressWarnings("unchecked")

		//create temporary pile to set pile equal to 
		T[] tempPile = (T[])new Object[DEFAULT_CAPACITY];

		//set pile equal to temp pile
		pile = tempPile;

		//set capacity equal to the default capacity
		capacity = DEFAULT_CAPACITY;
	
	}


	/**
	 * Constructor to create a new pile of books of user's choice length.
	 * @param cap Int representing the pile's current capacity.
	 */
	public PileOfBooks(int cap)
	{
		if(cap <= MAX_CAPACITY)
		{	
			//suppress the unchecked warning
			@SuppressWarnings("unchecked")

			//create temporary pile to set pile equal to 
			T[] tempPile = (T[])new Object[cap];

			//set pile equal to temp pile
			pile = tempPile;

			//set capacity equal to the user's chosen capacity
			capacity = cap;
		}
		else
		{
			throw new IllegalStateException("Attempt to create "
					+ "a bag whose capacity exceeds allowed "
					+ "maximum.");
		}	
	}


	/**
	 * Adds a new book to the top of this pile.
	 * @param newBook  An object to be added to the pile.
	 */
	public void add (T newBook)
	{
		if (top + 1 == capacity)
		{
			doubleCapacity();
		}
		//increment the value for top
		top++;

		//add the new book to the top of the pile
		pile[top]=newBook;
	}
	

	/**
	 * Removes and returns this pile's top book.
	 * @return A String holding the title of the book removed from the pile.
	 * Or null if the pile is empty
	 */
	public T remove()
	{
		//removes book if pile is not empty
		if (!isEmpty())
		{
			//temporary string to hold the book being removed
			T string = pile[top];

			//clear the pile at top index
			pile[top]=null;

			//top is now set below the removed item
			top--;

			//return string we removed from the top 
			return string;

		}
		//return null if pile is empty
		else
		{
			return null;
		}
		
	}


	/**
	 * Retrieves this pile's top book.
	 * @return Either the top book of the pile if the pile is not empty.
	 * Or null if the pile is empty
	 */
	public T getTopBook()
	{
		//returns top book is pile if not empty
		if (!isEmpty())
		{
			return pile[top];
			
		}
		//returns null is pile is empty
		else
		{
			return null;
		}
	}


	/**
	 * Finds whether this pile is empty.
	 * @return True if the pile is empty or False if the pile is not empty.
	 */
	public boolean isEmpty()
	{
		//return true if top == -1
		if(top == -1)
		{
			return true;
		}
		//return false if top != -1
		else
		{
			return false;
		}
	}


	/**
	 * Removes all books from this pile.
	 */
	public void clear()
	{
		//while the pile is not empty, remove the top book
		while(!isEmpty())
		{
			//calls the remove method
			remove();
		}
	}


	/**
	 * Checks the capacity of this pile. If the user enters a capacity that is
	 * too large, the method throws an IllegalState exception. 
	 * @param cap Int representing the pile's current capacity.
	 */
	private void checkCapacity(int cap)
	{
		//if paramater is greater than max capacity throw an exception
		if(cap > MAX_CAPACITY)
		{
			throw new IllegalStateException("Attempting to create a pile"
					+ " whose capacity exceeds allowed maximum of "
					+ MAX_CAPACITY);
		}
	}


	/**
	 * Doubles the capacity of this pile if the new capacity is less than the
	 * maximum capacity.
	 */
	private void doubleCapacity()
	{
		int newCap = 2 * pile.length;        //holds new capacity of the pile
		checkCapacity(newCap);               //checks new capacity validity
		pile = Arrays.copyOf(pile, newCap);  //creates new pile with new cap
		capacity = newCap;                   //sets capacity to new capacity
	}
}

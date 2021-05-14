/**
   This class is the test program that will demonstrates the PileInterface 
   implementation in the PileOfBooks class.
   of the BagInterface
   @author Jeremy Hill
   @version 12.0.2
 */
public class BookDemo 
{

	public static void main(String[] args) 
	{
		//creates an empty pile of books
		System.out.println("Create an empty pile of books:");
		PileInterface<String> pile = new PileOfBooks<>();


		//Checks to see if the pile is empty
		if (pile.isEmpty())
		{
			System.out.println("isEmpty() returns true");
		}
		else
		{
			System.out.println("isEmpty() returns false");
		}
		System.out.println("");


		//adds books to the pile
		System.out.println("Add to pile.");
		pile.add("And Then There Were None");
		pile.add("The Hobbit");
		pile.add("The Lord of the Rings");
		pile.add("The Da Vinci Code");
		pile.add("The Catcher in the Rye");


		//Checks to see if the pile is empty
		if (pile.isEmpty())
		{
			System.out.println("isEmpty() returns true");
		}
		else
		{
			System.out.println("isEmpty() returns false");
		}
		System.out.println("");


		//tests getTopBook and remove methods
		System.out.println("Testing peek and pop: ");
		System.out.println("");

		//calls the getTopBook and remove methods until the pile is empty
		while(!pile.isEmpty())
		{
			String top = pile.getTopBook();
			System.out.println(top + " is at the top of the pile.");

			top = pile.remove();
			System.out.println(top + " is removed from the pile.");
			System.out.println("");
		}


		//checks if the remove method is working correctly
		System.out.println("The pile should be empty: ");
		if (pile.isEmpty() )
		{
			System.out.println("isEmpty() returns true");
		}
		else
		{
			System.out.println("isEmpty() returns false");
		}
		System.out.println("");


		//adds books to the pile
		System.out.println("Add to pile.");
		pile.add("And Then There Were None");
		pile.add("The Hobbit");
		pile.add("The Lord of the Rings");
		pile.add("The Da Vinci Code");
		pile.add("The Catcher in the Rye");
		System.out.println("");

		
		//tests the clear method
		System.out.println("Testing clear: ");
		pile.clear();
		System.out.println("");


		//checks if the clear method is working correctly
		System.out.println("The pile should be empty: ");
		if (pile.isEmpty())
		{
			System.out.println("isEmpty() returns true");
		}
		else
		{
			System.out.println("isEmpty() returns false");
		}
		System.out.println("");


		//checks if the getTopbook and remove methods return null
		System.out.println("pile.getTopBook() returns: " + pile.getTopBook());
		System.out.println("pile.remove() returns: " + pile.remove());
		System.out.println("");

		//demo is over 
		System.out.println("Done.");
		System.out.println("");
	}

}
// Name: Jasmin Cervantes
// Date: 11/29/2024
// For this assignment I added a shuffle method in LinkList.java and in CardGame.java I called the method to shuffle the method and then display it
// I used AI to help me create the shuffle method.


import java.util.ArrayList;
import java.util.Collections;

public class LinkList
{
	private Link first;            // ref to first link on list

	//-------------------------------------------------------------
	public LinkList()              // constructor
	{
		first = null;               // no links on list yet
	}
	//-------------------------------------------------------------
	public void insertFirst(Card card)
	{                           // make new link
		Link newLink = new Link(card);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
	}
	public void add(Card card)
	{                           // make new link
		Link newLink = new Link(card);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
	}
	//-------------------------------------------------------------
	public Link find(Card cardToFind)      // find link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // start at 'first'
		while(!current.equals(cardToFind))        // while no match,
		{
			if(current.next == null)        // if end of list,
				return null;                 // didn't find it
			else                            // not end of list,
				current = current.next;      // go to next link
		}
		return current;                    // found it
	}
	//-------------------------------------------------------------
	public Link delete(Card cardToFind)    // delete link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // search for link
		Link previous = first;
		while(!current.equals(cardToFind))
		{
			if(!current.equals(cardToFind))
				return null;                 // didn't find it
			else
			{
				previous = current;          // go to next link
				current = current.next;
			}
		}                               // found it
		if(current.equals(cardToFind))               // if first link,
			first = first.next;             //    change first
		else                               // otherwise,
			previous.next = current.next;   //    bypass it
		return current;
	}
	//-------------------------------------------------------------
	public void displayList()      // display the list
	{
		System.out.print("List (first-->last): ");
		Link current = first;       // start at beginning of list
		while(current != null)      // until end of list,
		{
			current.displayLink();   // print data
			current = current.next;  // move to next link
		}
		System.out.println("");
	}
	//-------------------------------------------------------------

	//-------------------------------------------------------------
	public Card getFirst()    // delete link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // search for link
		first = first.next;             //    change first
		return current.cardLink;
	}
	//-------------------------------------------------------------

	//-------------------------------------------------------------
	// Code Added: Method created to shuffle the deck of cards
	// Shuffle the linked list
    public void shuffle() {
        if (first == null || first.next == null) {
            return; // No need to shuffle if the list is empty or has one element
        }

        // Step 1: Transfer nodes to an ArrayList
        ArrayList<Card> cardArray = new ArrayList<>();
        Link current = first;
        while (current != null) {
            cardArray.add(current.cardLink);
            current = current.next;
        }

        // Step 2: Shuffle the ArrayList
        Collections.shuffle(cardArray);

        // Step 3: Rebuild the linked list from the shuffled ArrayList
        first = null; // Clear the list
        for (Card card : cardArray) {
            add(card); // Add each shuffled card back to the list
        }
    }

    //-------------------------------------------------------------
	//necessary to be able to shuffle the deck of cards and store the Card data
    private class Link {
		// Inner class for a link
        public Card cardLink; // Data in the link
        public Link next; // Next link in list

        public Link(Card cardLink) {
            this.cardLink = cardLink;
        }

        public void displayLink() {
            System.out.print(cardLink + " ");
        }
    }
}  // end class LinkList
////////////////////////////////////////////////////////////////
/*class LinkedLists
{
	public static void main(String[] args)
	{
		LinkList theList = new LinkList();  // make list

		theList.insertFirst(new Card("heart", "ace", 11,"ah.gif"));      // insert 4 items
		theList.insertFirst(new Card("Spade", "ace", 11,"as.gif"));
		//theList.insertFirst(66, 6.99);
		//theList.insertFirst(88, 8.99);

		theList.displayList();              // display list

		Link f = theList.find(new Card("heart", "ace", 11,"ah.gif"));          // find item
		if( f != null)
			System.out.println("Found link with key " + f.cardLink);
		else
			System.out.println("Can't find link");

		Link d = theList.delete(new Card("heart", "ace", 11,"ah.gif"));        // delete item
		if( d != null )
			System.out.println("Deleted link with key " + d.cardLink);
		else
			System.out.println("Can't delete link");

		theList.displayList();              // display list
	}  // end main()
}  // end class LinkList2App
////////////////////////////////////////////////////////////////
/// */

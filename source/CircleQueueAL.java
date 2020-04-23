
import java.util.*;

/**
 *  Implementation of Queue, using LinkedList (previous and next).
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class CircleQueueAL 
{
   //private LinkedList headNode;			// 1st element in Queue
   //private LinkedList tailNode;			// Last element in Queue
   //private LinkedList currentNode;
	private Generics firstObject;
	private Generics lastObject;
	private Generics currentObject;
	private ArrayList<Generics> AL = new ArrayList<Generics>();

  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public CircleQueueAL()
  {
    firstObject = null;
    lastObject = null;
    currentObject = null;
	//AL = null;
  }
  
  /**
   *  Returns the head opaqueObject.
   *
   * @return  the head opaqueObject in Stack.
   */
  public Object getFirstObject()
  {
  	currentObject = firstObject;

    if (firstObject == null)
    	return null;
    else
    	return AL.get(0);
  }

  /**
   *  Returns the tail opaqueObjects.
   *
   * @return  the current opaqueObject in Stack.
   */
  public Object getLastObject()
  {
	currentObject = lastObject;

    if (lastObject == null)
    	return null;
    else
    	return AL.get(AL.size()-1);
  }
  
  /**
   *  Returns the current Object
   *
   * @return  the current Object in Stack.
   */
  public Object getObject()
  {
    if (currentObject == null)
  	  return null;
    else
      return AL.indexOf(currentObject);
  }
  
  /**
   *  Advances the current node.
   *
   */
  public void setNext()
  {
	  int currentIndex = AL.indexOf(currentObject);
	  currentObject = AL.get(currentIndex +1);
	  
	// never let currentNode be null, wrap to head
	if (currentObject == null)
		currentObject = firstObject;
  }
  
  /**
   *  Reverses the current node.
   *
   */
  public void setPrevious()
  {
	int currentIndex = AL.indexOf(currentObject);
	  currentObject = AL.get(currentIndex -1);
	
	// never let currentNode be null, wrap to head
	if (currentObject == null)
		currentObject = lastObject;
  }
  
  
  /**
   *  Add a new object at the end of the Queue,
   *
   * @param  o  is the data to be inserted in the Queue object.
   */
  
  public void add(Generics o)
  {
	  // add new object to end of Queue
	  // set opaqueObject
	  // build previous link of tail (as current)
	  AL.add(o);
	  lastObject = AL.get(AL.size()-1);
	  
	  // build next link of current (as tail)
	  if (currentObject != null) {
		  int currentIndex = AL.indexOf(currentObject);
		  AL.set(currentIndex+1,lastObject);
	  }
	  
	  // after links are established current eq tail
	  currentObject = lastObject;

	  // head eq tail on 1st element only
	  if (firstObject == null) {
		  firstObject = lastObject;
	  }
  }
  
  /**
   *  Delete an object from the front of the Queue,
   *
   */
  public Object delete()
  {
	  Generics opaqueObject = null;
	  	  
	  if (firstObject != null) {
		  opaqueObject = AL.get(0);
		  //firstObject = firstObject.getNext();
		  firstObject = AL.get(1);
		  if (firstObject == null)
			  lastObject = firstObject;
		  else
			  AL.set(AL.indexOf(lastObject),null);
			  //headNode.setPrevNode(null);
	  }
	  		
	  return opaqueObject;
  }
  
  
  /**
   *  Returns a string representation of this Queue,
   *  polymorphic nature of toString overrides of standard System.out.print behavior
   *
   * @return    string representation of this Queue
   */
  public String toString()
  {
    String queueToString = "[";

    Generics object = firstObject;  			// start from the head
    while (object != null && object!= lastObject)
    {
    	queueToString += "("+object+")"; 		// append the data to output string
    	int currentIndex = AL.indexOf(object);
    	object = AL.get(currentIndex + 1);				// go to next node
    	if (object != null)
    		queueToString += ", ";
    }										// loop 'till queue ends
    queueToString += "]";
    return queueToString;
  }
  
  /**
   * Performs insertion sort based off of the contents of object
   */
  public void insertionSort() {	
	
	//two nodes needed for insertion sort indexes
    //LinkedList node1 = headNode;
    //LinkedList node2 = (node1 == null) ? null : node1.getNext();
    Generics object1 = firstObject;
    int currentIndex = AL.indexOf(object1);
    Generics object2 = (object1 == null) ? null: AL.get(currentIndex+1);
    
    //continue while nodes remain in bounds
    while (object2 != null) {	
    	
    	//inner loop pointers for compares and shifts
    	//LinkedList slot1 = node1;
    	//LinkedList slot2 = node2;
    	Generics slot1 = object1;
    	Generics slot2 = object2;
    		
		//key to be inserted into sorted slot
		//LinkedList key = new LinkedList(node2);		//note: make key a different object, persistent/static in value (node2 moves)
		//String keyText = node2.getObject().toString();
		Generics key = new StateStatistics(null,0,0,null);
		String keyText = object2.toString();

		//walks slots backwards until key position in found
		/*while (slot1.toString().compareTo(keyText) > 0 && AL.indexOf(slot1) != 0 && AL.indexOf(slot2) != 0) {
	    	//shifts object greater than key value to the right in list
    		AL.set(AL.indexOf(slot2),slot1);

			//moves inner loop pointers
    		int currentIndex1 = AL.indexOf(slot1);
    		int currentIndex2 = AL.indexOf(slot2);
			slot1 = AL.get(currentIndex1-1);
			slot2 = AL.get(currentIndex2-1);
			
			//stop at the front of list
			if (slot1 == null)
				break;
			
    	}*/
		while (slot1.toString().compareTo(keyText) > 0 ) {
		    //shifts object greater than key value to the right in list
		int currentIndex1 = AL.indexOf(slot1);
		    int currentIndex2 = AL.indexOf(slot2);

		    AL.set(currentIndex2,slot1);
		    AL.set(currentIndex1,slot2);

		//stop at the front of list
		if (slot1 == null)
		break;

		    }
		//place key in insertion position
		AL.set(AL.indexOf(slot2), key);
    	//slot2.setObject(key.getObject());

    	//advance insertion sort indexes
		int currentIndex1 = AL.indexOf(object1);
		int currentIndex2 = AL.indexOf(object2);
		
		object1 = AL.get(currentIndex1 + 1);
		object2 = AL.get(currentIndex2 + 1);
    	//node1 = node1.getNext();
    	//node2 = node2.getNext();
    } 
    
  } 
  
}



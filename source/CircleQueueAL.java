
import java.util.*;

import sun.net.www.content.text.Generic;

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
  /*public String toString()
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
  }*/
  public String toString()
  {
	  String queueToString = "[";
	  for(Generics object: AL)
	  {
		  queueToString += object.toString();
		  queueToString += ", ";
	  }
	  
	  queueToString += "]";
	  
	  return queueToString;
  }
  
  public String toString2()
  {
	  String queueToString = "";
	  int i =1;
	  for(Generics object: AL)
	  {
		  queueToString += i + ". ";
		  //queueToString+= StateStatistics.KeyType.name;
		  queueToString += object.toString();
		  queueToString += "\n ";
		  i++;
	  }
	  
	  //queueToString += "]";
	  
	  return queueToString;
  }
  
  /**
   * Performs insertion sort based off of the contents of object
   */
  
  
  //insertionSort for String fields
  public void insertionStringSort()
  {
	  for(int j=1; j<AL.size(); j++)
	  {
		  Generics temp = AL.get(j);
		  int possibleIndex = j;
		  
		  while(possibleIndex>0 && AL.get(possibleIndex - 1).toString().compareTo(temp.toString())>0)
		  {
			  AL.set(possibleIndex, AL.get(possibleIndex -1));
			  possibleIndex--;
			  
		  }
		  
		  AL.set(possibleIndex, temp);
	  }
  
  }
  
  //insertionSort for Number fields
  public void insertionNumberSort()
  {
	  for(int j=1; j<AL.size(); j++)
	  {
		  Generics temp = AL.get(j);
		  int possibleIndex = j;
		  
		  while(possibleIndex>0 && Integer.parseInt(AL.get(possibleIndex - 1).toString()) < Integer.parseInt(temp.toString()))
		  {
			  AL.set(possibleIndex, AL.get(possibleIndex -1));
			  possibleIndex--;
			  
		  }
		  
		  AL.set(possibleIndex, temp);
	  }
  
  }
  
  
}



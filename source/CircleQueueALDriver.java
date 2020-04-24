import java.util.ArrayList;

/**
 * Circle Queue Driver takes a list of Objects and puts them into a Queue
 * @author     John Mortensen
 *
 */
public class CircleQueueALDriver {
	
	private CircleQueueAL cqueue;	// circle queue object
	private int count; // number of objects in circle queue

	/* 
	 * Circle queue constructor
	 */
	public CircleQueueALDriver()
	{
		count = 0;		
		cqueue = new CircleQueueAL();
	}

	/*
	 * Add any array of objects to the queue
	 */
	public void addCQueue(ArrayList<Generics> arrayList)
	{
		ConsoleMethods.println("Add " + arrayList.size());
		for (Generics o : arrayList)
		{
			cqueue.add(o);
			ConsoleMethods.println("Add: " + cqueue.getObject() + " " + cqueue);
			this.count++;
		}
		ConsoleMethods.println();			
	}
	
	/* 
	 * Show key objects/properties of circle queue
	 */
	public void showCQueue()
	{
		ConsoleMethods.println("Size: " + count);
		ConsoleMethods.println("First Element: " + cqueue.getFirstObject());
		ConsoleMethods.println("Last Element: " + cqueue.getLastObject());
		ConsoleMethods.println("Full cqueue: " + cqueue);
		ConsoleMethods.println();
	}
	
	/* 
	 * Delete/Clear all object in circle queue
	 */
	public void deleteCQueue()
	{
		int length = this.count;
		ConsoleMethods.println("Delete " + length);
		
		for (int i = 0; i<length; i++)
		{
			ConsoleMethods.println("Delete: " + cqueue.delete() + " " + cqueue);
			this.count--;
		}
	}
	
	//ADDED THIS METHOD
	public CircleQueueAL getCQueue()
	{
		return cqueue;
	}
	
	
	/* 
	 * Illustrate different Objects that can be placed on same Queue
	 */
	public static void main(String[] args)
	
	{			
		//queue
		CircleQueueALDriver trial = new CircleQueueALDriver();
		
		//add different types of objects to the same opaque queue
		trial.addCQueue(StateStatistics.stateData());	
		//display queue objects in queue order
		trial.showCQueue();
		
		//sort queue objects by specific element within the object and display in sort order
		//IF KEYTYPE IS INTEGER/NUMBER, THEN USE insertionNumberSort!
		//IF KEYTYPE IS STRING, THEN USE insertionStringSort!
		ConsoleMethods.println("Alphabetized States: ");
		StateStatistics.key = StateStatistics.KeyType.name;
		trial.cqueue.insertionStringSort();
		trial.showCQueue();
		
		ConsoleMethods.println("States Ranked by Cases: ");
		StateStatistics.key = StateStatistics.KeyType.numCases;
		trial.cqueue.insertionNumberSort();
		trial.showCQueue();
		
		ConsoleMethods.println("States Ranked by Number Dead: ");
		StateStatistics.key = StateStatistics.KeyType.numDead;
		trial.cqueue.insertionNumberSort();
		trial.showCQueue();
		
		ConsoleMethods.println("States Ranked by Percent Positive ");
		StateStatistics.key = StateStatistics.KeyType.percentPositive;
		trial.cqueue.insertionNumberSortDouble();
		trial.showCQueue();
		
		
		//delete queue objects
		trial.deleteCQueue();
	
	}
	
}

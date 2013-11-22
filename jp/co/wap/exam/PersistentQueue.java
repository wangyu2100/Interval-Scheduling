package jp.co.wap.exam;

/**
* The Queue class represents an immutable first-in-first-out (FIFO) queue of objects.
* @param <E>
*/

import java.util.NoSuchElementException;

public class PersistentQueue<E> {
/**
* requires default constructor.
*/
	private Object[] queue;
	

	public PersistentQueue() 
	{
		
	}


	public PersistentQueue(Object[] obj)
	{
		this.queue=obj;
	}
/**
* Returns the queue that adds an item into the tail of this queue without modifying this queue.
* <pre>
* e.g.
* When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
* this method returns a new queue (2, 1, 2, 2, 6, 4)
* and this object still represents the queue (2, 1, 2, 2, 6) .
* </pre>
* If the element e is null, throws IllegalArgumentException.
* @param e
* @return
* @throws IllegalArgumentException
*/

	public PersistentQueue<E> enqueue(E e) 
	{
	
		int length=0;
		if(queue!=null)
			length=queue.length;
		Object[] decoy=new Object[length+1];
		decoy[length]=e;
		if(queue!=null)
		System.arraycopy(queue, 0, decoy, 0, length);
	
		return new PersistentQueue<E>(decoy);
	}
/**
* Returns the queue that removes the object at the head of this queue without modifying this queue.
* <pre>
* e.g.
* When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
* this method returns a new queue (1, 3, 3, 5, 1)
* and this object still represents the queue (7, 1, 3, 3, 5, 1) .
* </pre>
* If this queue is empty, throws java.util.NoSuchElementException.
* @return
* @throws java.util.NoSuchElementException
*/

	public PersistentQueue<E> dequeue() 

	{

		if (queue == null) {
		throw new NoSuchElementException();
		}
		Object[] decoy = new Object[queue.length-1];
		System.arraycopy(queue, 1, decoy, 0, queue.length-1);   
		return new PersistentQueue<E>(decoy);

	}
/**
* Looks at the object which is the head of this queue without removing it from the queue.
* <pre>
* e.g.
* When this queue represents the queue (7, 1, 3, 3, 5, 1),
* this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
* </pre>
* If the queue is empty, throws java.util.NoSuchElementException.
* @return
* @throws java.util.NoSuchElementException
*/

	@SuppressWarnings("unchecked")
	public E peek() 
	{
		if (queue == null) 
		{
			throw new NoSuchElementException();
			
		}
		
		return (E) queue[0];


	}
/**
* Returns the number of objects in this queue.
* @return
*/

	public int size() 
	{
		if(queue == null)
			return 0;
		else
			return queue.length;
	}
	
}